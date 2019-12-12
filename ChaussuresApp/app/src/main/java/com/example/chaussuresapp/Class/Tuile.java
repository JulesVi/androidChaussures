package com.example.chaussuresapp.Class;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;

import com.example.chaussuresapp.R;
import com.example.chaussuresapp.api.AnnonceHelper;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

public class Tuile implements Serializable {
    private String imgId;
    private String titreAnnonce;
    private String auteurAnnonce;
    private String description;
    private String pied;
    private int taille;
    private String etat; // à transformer en Enum (Mauvais, moyen, bon, très bon, neuf)
    private String localisation;
    private int cp; // code postal
    private int prix;

    public Tuile(String imgId, String titreAnnonce, String auteurAnnonce, String description, String pied, int taille, String etat, String localisation, int cp, int prix ) {
        this.imgId = imgId;
        this.titreAnnonce = titreAnnonce;
        this.auteurAnnonce = auteurAnnonce;
        this.description = description;
        this.pied = pied;
        this.taille = taille;
        this.etat = etat;
        this.localisation = localisation;
        this.cp = cp;
        this.prix = prix;
    }

    public Tuile(QueryDocumentSnapshot document) {
        this.imgId = document.get("image").toString();
        this.titreAnnonce = document.get("titre").toString();
        this.auteurAnnonce = document.getId();
        this.description = document.get("description").toString();
        this.pied = document.get("pied").toString();
        this.taille = new Integer(document.get("taille").toString());
        this.etat = document.get("etat").toString();
        this.localisation = "localisation en dur";
        this.cp = new Integer(document.get("cp").toString());
        this.prix = new Integer(document.get("prix").toString());
    }

    public Bitmap getImgBmp() throws IOException {
        Bitmap bmp = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            //fonctionne uniquement avec les images HTTPS
            URL url = new URL(imgId);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }
    public String getTitreAnnonce() {
        return titreAnnonce;
    }
    public String getAuteurAnnonce() {
        return auteurAnnonce;
    }
    public String getPied() {
        return pied;
    }
    public int getTaille() {
        return taille;
    }
    public String getEtat() {
        return etat;
    }
    public String getLocalisation() {
        return localisation;
    }
    public int getCp() {
        return cp;
    }
    public String getDescription() {
        return description;
    }
    public String getPrix() {
        return prix+" €";
    }
}