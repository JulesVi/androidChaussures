package com.example.chaussuresapp.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.chaussuresapp.MainActivity;
import com.example.chaussuresapp.R;
import com.example.chaussuresapp.base.BaseActivity;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;

public class ProfileActivity extends BaseActivity {

    private static final int RC_SIGN_IN = 123;
    private Button btn;
    private TextView textInputEditTextUsername;
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
        if (this.getCurrentUser() != null)
            btn.setText("deconnexion");
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonPressed();
            }
        });

        textInputEditTextUsername = (TextView) findViewById(R.id.textInputEditTextUsername);
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

}