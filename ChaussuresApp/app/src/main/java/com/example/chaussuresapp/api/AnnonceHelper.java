package com.example.chaussuresapp.api;

/**
 * classe permettant d'instancier des annonces dans la base firebase
 */
public class AnnonceHelper {
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

    public AnnonceHelper(){}

    public AnnonceHelper(String imgId, String titreAnnonce, String auteurAnnonce, String description, String pied, int taille, String etat, String localisation, int cp, int prix ) {
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

    public String getImgId(){
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
    public String getDescription() {
        return description;
    }
    public int getPrix() {
        return prix;
    }
}
