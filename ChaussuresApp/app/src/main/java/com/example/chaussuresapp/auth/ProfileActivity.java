package com.example.chaussuresapp.auth;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.chaussuresapp.R;
import com.example.chaussuresapp.api.AnnonceHelper;
import com.example.chaussuresapp.api.UserHelper;
import com.example.chaussuresapp.base.BaseActivity;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;

public class ProfileActivity extends BaseActivity {

    private static final int RC_SIGN_IN = 123;
    // Creating identifier to identify REST REQUEST (Update username)
    private static final int UPDATE_USERNAME = 30;

    private Button btn;
    private Button btnModifCompte;
    private EditText textInputEditTextUsername;
    private TextView usernameTV;
    private TextView textViewEmail;
    private ImageView imageViewProfile;

    // 2 - Identify each Http Request
    private static final int SIGN_OUT_TASK = 10;
    private static final int DELETE_USER_TASK = 20;

    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    finish();
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.configureToolbar();
        setContentView(R.layout.activity_profile);

        btn = (Button) findViewById(R.id.profile_activity_button_update);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonPressed();
            }
        });

        btnModifCompte = (Button) findViewById(R.id.modifCompteBtn);
        btnModifCompte.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textInputEditTextUsername.setEnabled(true);
                if(btnModifCompte.getText() == "oui"){
                    updateUsernameInFirebase();
                }
                btnModifCompte.setText("oui");
            }
        });

        if (this.getCurrentUser() != null){
            btn.setText("deconnexion");
            btnModifCompte.setVisibility(View.VISIBLE);
        }

        textInputEditTextUsername = (EditText) findViewById(R.id.textInputEditTextUsername);
        textInputEditTextUsername.setEnabled(false);
        usernameTV = (TextView) findViewById(R.id.usernameTV);

        textViewEmail = (TextView) findViewById(R.id.textViewEmail);

        imageViewProfile = (ImageView) findViewById(R.id.imageViewProfile);


        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bottomNavigationView.setSelectedItemId(R.id.navigation_notifications);

        this.updateUIWhenCreating();
    }

    private void buttonPressed(){
        if (this.getCurrentUser() != null){
            this.signOutUserFromFirebase();
            btn.setText("connexion");
        }else{
            this.startSignInActivity();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        btn.setText("deconnexion");
        btnModifCompte.setVisibility(View.VISIBLE);
        updateUIWhenCreating();
    }

    // 2 - Launch Sign-In Activity
    private void startSignInActivity(){
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setTheme(R.style.AppTheme)
                            .setAvailableProviders(
                                    Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build(), //EMAIL
                                            new AuthUI.IdpConfig.GoogleBuilder().build())) // SUPPORT GOOGLE))
                            .setIsSmartLockEnabled(false, true)
                            .build(),
                    RC_SIGN_IN);
    }

    // 1 - Update UI when activity is creating
    private void updateUIWhenCreating(){

        if (this.getCurrentUser() != null) {

            //Get picture URL from Firebase
            if (this.getCurrentUser().getPhotoUrl() != null) {
                Glide.with(this)
                        .load(this.getCurrentUser().getPhotoUrl())
                        .apply(RequestOptions.circleCropTransform())
                        .into(imageViewProfile);
            }else{
                imageViewProfile.setImageResource(R.drawable.baseline_account_circle_black_48dp);
            }

            //Get email & username from Firebase
            String email = TextUtils.isEmpty(this.getCurrentUser().getEmail()) ? "email not found" : this.getCurrentUser().getEmail();
            String username = TextUtils.isEmpty(this.getCurrentUser().getDisplayName()) ? "username not found" : this.getCurrentUser().getDisplayName();

            //Update views with data
            this.textInputEditTextUsername.setText(username);
            this.textInputEditTextUsername.setVisibility(View.VISIBLE);
            this.textViewEmail.setText(email);
            this.textViewEmail.setVisibility(View.VISIBLE);

            this.usernameTV.setVisibility(View.VISIBLE);
        }
    }

    private void signOutUserFromFirebase(){
        AuthUI.getInstance()
                .signOut(this)
                .addOnSuccessListener(this, this.updateUIAfterRESTRequestsCompleted(SIGN_OUT_TASK));
    }

    // 3 - Create OnCompleteListener called after tasks ended
    private OnSuccessListener<Void> updateUIAfterRESTRequestsCompleted(final int origin){
        return new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                switch (origin){
                    case SIGN_OUT_TASK:
                        finish();
                        break;
                    case DELETE_USER_TASK:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        };
    }

    // 3 - Update User Username
    private void updateUsernameInFirebase(){

        String username = this.textInputEditTextUsername.getText().toString();

        /*if (this.getCurrentUser() != null){
            if (!username.isEmpty() &&  !username.equals("")){
                UserHelper.updateUsername(username, this.getCurrentUser().getUid()).addOnFailureListener(this.onFailureListener()).addOnSuccessListener(this.updateUIAfterRESTRequestsCompleted(UPDATE_USERNAME));
            }
        }*/
    }

}