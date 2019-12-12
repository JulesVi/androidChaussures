package com.example.chaussuresapp.Class;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.chaussuresapp.R;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

public class Tuile implements Serializable {
    private String imgId;
    private String titreAnnonce;
    private String auteurAnnonce;
    private String pied;
    private int taille;
    private String etat; // à transformer en Enum (Mauvais, moyen, bon, très bon, neuf)
    private String localisation;
    private int cp; // code postal

    public Tuile(String imgId, String titreAnnonce, String auteurAnnonce, String pied, int taille, String etat, String localisation, int cp ) {
        this.imgId = imgId;
        this.titreAnnonce = titreAnnonce;
        this.auteurAnnonce = auteurAnnonce;
        this.pied = pied;
        this.taille = taille;
        this.etat = etat;
        this.localisation = localisation;
        this.cp = cp;
    }

    public Bitmap getImgId() throws IOException {
        Bitmap bmp = null;
        try {
            URL url = new URL("https://www.villeneuvecycles.fr/upload/17-09-14-23-03-09-e7ujh8.png");
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
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
}