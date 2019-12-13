package com.example.chaussuresapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.chaussuresapp.api.AnnonceHelper;
import com.example.chaussuresapp.auth.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddAnnonce extends AppCompatActivity {
    private TextView mTextMessage;

    private EditText editTextPseudo;
    private EditText editTextTitre;
    private EditText editTextLien;
    private Button buttonAdd;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(AddAnnonce.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                    finish();
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    finish();
                    startActivity(new Intent(AddAnnonce.this, ProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.fui_slide_out_left);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addannonce);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_dashboard);

        editTextPseudo = findViewById(R.id.editTextPseudo);
        editTextTitre = findViewById(R.id.editTextTitre);
        editTextLien = findViewById(R.id.editTextLien);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonPressed();
            }
        });
    }

    private void buttonPressed(){
        db.collection("annonce").document(editTextPseudo.getText().toString()).set(new AnnonceHelper(editTextLien.getText().toString(),
                editTextTitre.getText().toString(),
                editTextPseudo.getText().toString(),
                "descrition de "+editTextPseudo.getText().toString(),
                "droit", 48, "éclaté au sol", "Chicago", 60007, 30000));

    }

}
