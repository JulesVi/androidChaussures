package com.example.chaussuresapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.chaussuresapp.Class.Tuile;
import com.example.chaussuresapp.api.AnnonceHelper;
import com.example.chaussuresapp.auth.ProfileActivity;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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

import java.io.Serializable;
import java.util.Arrays;
import java.util.EventListener;

public class MainActivity extends AppCompatActivity implements Serializable {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private BottomNavigationView bottomNavigationView /*= (BottomNavigationView) findViewById(R.id.nav_view)*/;

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

                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.fui_slide_out_left);
                    return true;
            }
            return false;
        }
    };

    /*private Tuile tuile1 = new Tuile(R.drawable.img1, "Belles chaussures", "Chris Cole");
    private Tuile tuile2 = new Tuile(R.drawable.img2, "Chaussure moche", "Toto");
    private Tuile tuile3 = new Tuile(R.drawable.img3, "Pas une chaussure", "Balthazar");
    private Tuile tuile4 = new Tuile(R.drawable.img1, "Autre chose", "Michel");
    private Tuile tuile5 = new Tuile(R.drawable.img3, "Encore autre truc", "Jean claude");*/

    private Tuile[] tuiles = new Tuile[1];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //lecture de l'annonce robert récupéré dans l'objet annonce1
        final DocumentReference docRef = db.collection("annonce").document("robert");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                AnnonceHelper annonce1 = documentSnapshot.toObject(AnnonceHelper.class);
                Log.i("aa", "" + docRef.getId());
                tuiles[0] = new Tuile(R.drawable.img2, annonce1.getTitre(), docRef.getId().toString(), "gauche", annonce1.getTaille(), "neuf", "Chicago", 1);
                whenDataReady();
            }
        });
    }


    protected void whenDataReady() {
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


        //ajout d'une annonce
        db.collection("annonce").document("robert").set(new AnnonceHelper("NB306", 420, 666, false, "cool chaussure", "http://www.weartested.com/wp-content/uploads/2019/10/Side-1500x728.jpg"));

        //lecture de toutes les annonces
        db.collection("annonce")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("aa", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("aa", "Error getting documents.", task.getException());
                        }
                    }
                });



    }

    @Override
    public void onResume(){
        super.onResume();
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
    }
}
