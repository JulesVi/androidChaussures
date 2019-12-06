package com.example.chaussuresapp;

import android.os.Bundle;

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
                    System.out.println("il n'y a pas de probleme");
                    finish();
                    return true;
                case R.id.navigation_dashboard:
                    finish();
                    return true;
                case R.id.navigation_notifications:
                    finish();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_annonce);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Tuile tuileAnnonce = (Tuile)getIntent().getSerializableExtra("tuile");

        TextView titreAnnonce = findViewById(R.id.nomAnnonce);
        titreAnnonce.setText(tuileAnnonce.getTitreAnnonce());

        ImageView imageAnnonce = findViewById(R.id.imageAnnonce);
        imageAnnonce.setImageResource(tuileAnnonce.getImgId());
    }
}
