package com.example.chaussuresapp.Class;

import com.example.chaussuresapp.R;

public class Tuile {
    private int imgId;
    private String titreAnnonce;
    private String auteurAnnonce;

    public Tuile(int imgId, String titreAnnonce, String auteurAnnonce) {
        this.imgId = imgId;
        this.titreAnnonce = titreAnnonce;
        this.auteurAnnonce = auteurAnnonce;
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
}
