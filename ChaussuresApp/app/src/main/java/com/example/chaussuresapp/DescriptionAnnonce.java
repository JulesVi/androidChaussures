package com.example.chaussuresapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.chaussuresapp.auth.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.chaussuresapp.Class.Tuile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionAnnonce extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    finish();
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(DescriptionAnnonce.this, AddAnnonce.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.fui_slide_out_left);
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(DescriptionAnnonce.this, ProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.fui_slide_out_left);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Tuile tuileAnnonce = (Tuile)getIntent().getSerializableExtra("tuile");

        TextView titreAnnonce = findViewById(R.id.nomAnnonce);
        titreAnnonce.setText(tuileAnnonce.getTitreAnnonce());

        ImageView imageAnnonce = findViewById(R.id.imageAnnonce);
        //imageAnnonce.setImageResource(tuileAnnonce.getImgId());
    }
}
