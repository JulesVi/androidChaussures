package com.example.chaussuresapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.chaussuresapp.Class.Tuile;
import com.firebase.ui.auth.AuthUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.EventListener;

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

    private Tuile tuile1 = new Tuile(R.drawable.img1, "Belles chaussures", "Chris Cole");
    private Tuile tuile2 = new Tuile(R.drawable.img2, "Chaussure moche", "Toto");
    private Tuile tuile3 = new Tuile(R.drawable.img3, "Pas une chaussure", "Balthazar");
    private Tuile tuile4 = new Tuile(R.drawable.img1, "Autre chose", "Michel");
    private Tuile tuile5 = new Tuile(R.drawable.img3, "Encore autre truc", "Jean claude");
    private Tuile tuile6 = new Tuile(R.drawable.img1, "Belles chaussures", "Chris Cole");
    private Tuile tuile7 = new Tuile(R.drawable.img2, "Chaussure moche", "Toto");
    private Tuile tuile8 = new Tuile(R.drawable.img3, "Pas une chaussure", "Balthazar");
    private Tuile tuile9 = new Tuile(R.drawable.img3, "Autre chose", "Michel");
    private Tuile tuile10 = new Tuile(R.drawable.img2, "Encore autre truc", "Jean claude");
    private Tuile tuile11 = new Tuile(R.drawable.img1, "Belles chaussures", "Chris Cole");
    private Tuile tuile12 = new Tuile(R.drawable.img2, "Chaussure moche", "Toto");
    private Tuile tuile13 = new Tuile(R.drawable.img3, "Pas une chaussure", "Balthazar");
    private Tuile tuile14 = new Tuile(R.drawable.img1, "Autre chose", "Michel");
    private Tuile tuile15 = new Tuile(R.drawable.img3, "Encore autre truc", "Jean claude");
    private Tuile tuile16 = new Tuile(R.drawable.img1, "Belles chaussures", "Chris Cole");
    private Tuile tuile17 = new Tuile(R.drawable.img2, "Chaussure moche", "Toto");
    private Tuile tuile18 = new Tuile(R.drawable.img3, "Pas une chaussure", "Balthazar");
    private Tuile tuile19 = new Tuile(R.drawable.img3, "Autre chose", "Michel");
    private Tuile tuile20 = new Tuile(R.drawable.img2, "Encore autre truc", "Jean claude");
    private Tuile tuile21 = new Tuile(R.drawable.img1, "Belles chaussures", "Chris Cole");
    private Tuile tuile22 = new Tuile(R.drawable.img2, "Chaussure moche", "Toto");
    private Tuile tuile23 = new Tuile(R.drawable.img3, "Pas une chaussure", "Balthazar");
    private Tuile tuile24 = new Tuile(R.drawable.img1, "Autre chose", "Michel");
    private Tuile tuile25 = new Tuile(R.drawable.img3, "Encore autre truc", "Jean claude");
    private Tuile tuile26 = new Tuile(R.drawable.img1, "Belles chaussures", "Chris Cole");
    private Tuile tuile27 = new Tuile(R.drawable.img2, "Chaussure moche", "Toto");
    private Tuile tuile28 = new Tuile(R.drawable.img3, "Pas une chaussure", "Balthazar");
    private Tuile tuile29 = new Tuile(R.drawable.img3, "Autre chose", "Michel");
    private Tuile tuile30 = new Tuile(R.drawable.img2, "Encore autre truc", "Jean claude");
    private Tuile tuile31 = new Tuile(R.drawable.img1, "Belles chaussures", "Chris Cole");
    private Tuile tuile32 = new Tuile(R.drawable.img2, "Chaussure moche", "Toto");
    private Tuile tuile33 = new Tuile(R.drawable.img3, "Pas une chaussure", "Balthazar");
    private Tuile tuile34 = new Tuile(R.drawable.img1, "Autre chose", "Michel");
    private Tuile tuile35 = new Tuile(R.drawable.img3, "Encore autre truc", "Jean claude");
    private Tuile tuile36 = new Tuile(R.drawable.img1, "Belles chaussures", "Chris Cole");
    private Tuile tuile37 = new Tuile(R.drawable.img2, "Chaussure moche", "Toto");
    private Tuile tuile38 = new Tuile(R.drawable.img3, "Pas une chaussure", "Balthazar");
    private Tuile tuile39 = new Tuile(R.drawable.img3, "Autre chose", "Michel");
    private Tuile tuile40 = new Tuile(R.drawable.img2, "Encore autre truc", "Jean claude");

    private Tuile[] tuiles = {
            tuile1, tuile2, tuile3, tuile4, tuile5, tuile6, tuile7, tuile8, tuile9, tuile10, tuile11, tuile12, tuile13, tuile14, tuile15, tuile16, tuile17, tuile18, tuile19, tuile20,
            tuile21, tuile22, tuile23, tuile24, tuile25, tuile26, tuile27, tuile28, tuile29, tuile30, tuile31, tuile32, tuile33, tuile34, tuile35, tuile36, tuile37, tuile38, tuile39, tuile40
    };

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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d("Monlog", String.valueOf(position));
                Intent intent = new Intent(MainActivity.this, DescriptionAnnonce.class);
                startActivity(intent);
            }
        });

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