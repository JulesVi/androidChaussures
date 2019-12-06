package com.example.chaussuresapp.auth;

import android.app.Activity;
import android.os.Bundle;

import com.example.chaussuresapp.R;
import com.example.chaussuresapp.base.BaseActivity;
import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;

public class SignInActivity extends BaseActivity {

    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startSignInActivity();
        setResult(Activity.RESULT_CANCELED);
        finish();
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
