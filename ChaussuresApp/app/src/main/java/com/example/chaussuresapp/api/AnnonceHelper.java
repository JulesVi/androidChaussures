package com.example.chaussuresapp.api;

public class AnnonceHelper {
    private String image;
    private String description;
    private Boolean droite;
    private int prix;
    private int taille;
    private  String titre;

    public AnnonceHelper(){}

    public AnnonceHelper(String titre, int taille, int prix, Boolean droite, String description, String image){
        this.titre = titre;
        this.taille = taille;
        this.prix = prix;
        this.droite = droite;
        this.description = description;
        this.image = image;
    }

    public String getTitre(){
        return titre;
    }

    public int getTaille(){
        return taille;
    }

    public int getPrix(){
        return prix;
    }

    public Boolean getDroite(){
        return droite;
    }

    public String getDescription(){
        return description;
    }

    public String getImage(){
        return image;
    }
}
