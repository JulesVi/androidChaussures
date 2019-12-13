package com.example.chaussuresapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.chaussuresapp.Class.Tuile;
import com.example.chaussuresapp.api.AnnonceHelper;
import com.example.chaussuresapp.auth.ProfileActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private BottomNavigationView bottomNavigationView /*= (BottomNavigationView) findViewById(R.id.nav_view)*/;

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        /**
         * mise en place de la bottom navigation
         * @param item
         * @return
         */
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

    private ArrayList<Tuile> tuiles = new ArrayList<Tuile>();

    /**
     * liaison des attributs avec ceux de la view,
     * lecture de la collection annonce dans firebase,
     * remplissage de tuiles
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //db.collection("annonce").document("robert").set(new AnnonceHelper("https://scene7.zumiez.com/is/image/zumiez/pdp_hero/New-Balance-Numeric-306-Foy-Blue-%26-Red-Skate-Shoes-_320281-front-US.jpg","chaussures pas ouf", "robert", "descrition de robert", "droit", 48, "éclaté au sol", "Chicago", 60007, 30000));

        //lecture de toutes les annonces
//        db.collection("annonce")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d("aa", document.getId() + " => " + document.getData());
//                                tuiles.add(new Tuile(document));
//
//                            }
//                        } else {
//                            Log.w("aa", "Error getting documents.", task.getException());
//                        }
//                        whenDataReady();
//                    }
//                });
    }


    /**
     * envoi du contenu de tuiles dans la gridView
     */
    protected void whenDataReady() {
        GridView gridView = (GridView) findViewById(R.id.GridView);
        TuilesAdapter tuilesAdapter = new TuilesAdapter(this, tuiles);
        gridView.setAdapter(tuilesAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DescriptionAnnonce.class);
                intent.putExtra("tuile", tuiles.get(position));
                startActivity(intent);
            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        tuiles = new ArrayList<Tuile>();
        //lecture de toutes les annonces
        db.collection("annonce")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("aa", document.getId() + " => " + document.getData());
                                tuiles.add(new Tuile(document));

                            }
                        } else {
                            Log.w("aa", "Error getting documents.", task.getException());
                        }
                        whenDataReady();
                    }
                });
    }
}
