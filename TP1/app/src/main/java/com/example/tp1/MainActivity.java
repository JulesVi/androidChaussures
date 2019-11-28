package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView m_imgHead;
    TextView m_headTitle;
    EditText m_login;
    EditText m_password;
    Button m_btnCo;
    Button m_btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on récupère les différents éléments de la vue
        m_imgHead = (ImageView) findViewById(R.id.imgHead);
        m_headTitle = (TextView) findViewById(R.id.headTitle);
        m_login = (EditText) findViewById(R.id.login);
        m_password = (EditText) findViewById(R.id.password);
        m_btnCo = (Button) findViewById(R.id.btnConnexion);
        m_btnCreate = (Button) findViewById(R.id.btnCreate);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.baseline_menu_black_18dp);


        // on va "ecouter" le bouton de connexion
        m_btnCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeBtnLoginClick();
            }
        });
    }

    private void executeBtnLoginClick(){
        if (! m_login.getText().toString().equals("Jules")){
            // on va chercher le message d'erreur dans les strings
            String sErrorMsg = getResources().getString(R.string.ErrorBadLogin);

            m_login.setError(sErrorMsg);
            return;
        }

        if (! m_password.getText().toString().equals("corimjvl")){
            String sErrorMsg = getResources().getString(R.string.ErrorBadPwd);

            m_password.setError(sErrorMsg);
            return;
        }

        //bon identifiants si on arrive ici, donc nouvelle activité
        Intent myIntent = new Intent(this, HomePage.class);
        myIntent.putExtra("userLogin", m_login.getText().toString());
        startActivity(myIntent);
    }
}
