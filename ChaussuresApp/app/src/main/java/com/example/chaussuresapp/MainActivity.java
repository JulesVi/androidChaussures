package com.example.chaussuresapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.chaussuresapp.Class.Tuile;
import com.example.chaussuresapp.auth.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements Serializable {
    private BottomNavigationView bottomNavigationView /*= (BottomNavigationView) findViewById(R.id.nav_view)*/;

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(MainActivity.this, AddAnnonce.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.fui_slide_out_left);
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.fui_slide_out_left);
                return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tuile tuile1 = new Tuile(bmp, "Belles chaussures", "Chris Cole", "gauche", 41, "neuf", "Grenoble", 38100);
        Tuile tuile2 = new Tuile(bmp, "Chaussure moche", "Toto", "gauche", 41, "neuf", "Grenoble", 38100);
        Tuile tuile3 = new Tuile(bmp, "Pas une chaussure", "Balthazar", "gauche", 41, "neuf", "Grenoble", 38100);
        Tuile tuile4 = new Tuile(bmp, "Autre chose", "Michel", "gauche", 41, "neuf", "Grenoble", 38100);
        Tuile tuile5 = new Tuile(bmp, "Encore autre truc", "Jean claude", "gauche", 41, "neuf", "Grenoble", 38100);

        Tuile[] tuiles = { tuile1, tuile2, tuile3, tuile4, tuile5 };

        bottomNavigationView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        GridView gridView = (GridView)findViewById(R.id.GridView);
        TuilesAdapter tuilesAdapter = new TuilesAdapter(this, tuiles);
        gridView.setAdapter(tuilesAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DescriptionAnnonce.class);
                intent.putExtra("tuile", tuiles[position]);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
    }
}
