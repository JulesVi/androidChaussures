package com.example.chaussuresapp.Class;

import com.example.chaussuresapp.R;

import java.io.Serializable;

public class Tuile implements Serializable {
    private int imgId;
    private String titreAnnonce;
    private String auteurAnnonce;
    private String pied;
    private int taille;
    private String etat; // à transformer en Enum (Mauvais, moyen, bon, très bon, neuf)
    private String localisation;
    private int cp; // code postal

    public Tuile(int imgId, String titreAnnonce, String auteurAnnonce, String pied, int taille, String etat, String localisation, int cp ) {
        this.imgId = imgId;
        this.titreAnnonce = titreAnnonce;
        this.auteurAnnonce = auteurAnnonce;
        this.pied = pied;
        this.taille = taille;
        this.etat = etat;
        this.localisation = localisation;
        this.cp = cp;
    }

    public int getImgId() {
        return imgId;
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