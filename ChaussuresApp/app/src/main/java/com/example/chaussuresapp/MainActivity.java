package com.example.chaussuresapp;

import android.os.Bundle;

import com.example.chaussuresapp.Class.Tuile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

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
//    Tuile(String imgPath, String titreAnnonce, String auteurAnnonce)

    private Tuile tuile1 = new Tuile(R.drawable.img1, "Belles chaussures", "Chris Cole");
    private Tuile tuile2 = new Tuile(R.drawable.img2, "Chaussure moche", "Toto");
    private Tuile tuile3 = new Tuile(R.drawable.img3, "Pas une chaussure", "Balthazar");
    private Tuile tuile4 = new Tuile(R.drawable.img3, "Autre chose", "Michel");
    private Tuile tuile5 = new Tuile(R.drawable.img3, "Encore autre truc", "Jean claude");

    private Tuile[] tuiles = {tuile1, tuile2, tuile3, tuile4, tuile5};

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
    }

}