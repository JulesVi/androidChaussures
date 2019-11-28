package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    // variables, essentiellement pour le binding code/vue
    ListView m_ListView;

    List<Jour> m_joursAVenir = new ArrayList<Jour>();
    ArrayAdapter<Jour> m_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // on récupère les données transmises, les élements textView etc
        Intent intent = getIntent();
        String login = intent.getStringExtra("userLogin");
        m_ListView = (ListView) findViewById(R.id.conteneur);

        // on appelle le webService pour lancer les requêtes
        callWebService();

        m_Adapter = new MeteoAdapter(this, 0);

        m_ListView.setAdapter(m_Adapter);
    }

    private void callWebService(){
        String sURL = "https://www.prevision-meteo.ch/services/json/grenoble";

        RequestQueue queue = Volley.newRequestQueue(HomePage.this);

        StringRequest request = new StringRequest(Request.Method.GET, sURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // afficher
                        DonneesMeteo data = new DonneesMeteo(response);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        // ici alerter l'utilisateur qu'il y a une erreur
                    }
                });

        queue.add(request);
    }
}
