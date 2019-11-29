package com.example.chaussuresapp;

import android.os.Bundle;

import com.example.chaussuresapp.Class.Tuile;
import com.firebase.ui.auth.AuthUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_add);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_profil);
                    return true;
            }
            return false;
        }
    };
    private Tuile tuile1 = new Tuile("tuile1");
    private Tuile tuile2 = new Tuile("tuile2");
    private Tuile tuile3 = new Tuile("tuile3");
    private Tuile[] tuiles = {tuile1, tuile2, tuile3};

    private Button btn;

    //FOR DATA
    // 1 - Identifier for Sign-In Activity
    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        GridView gridView = (GridView)findViewById(R.id.GridView);
        TuilesAdapter tuilesAdapter = new TuilesAdapter(this, tuiles);
        gridView.setAdapter(tuilesAdapter);

        btn = (Button) findViewById(R.id.btnSearch);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startSignInActivity();
            }
        });
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

}