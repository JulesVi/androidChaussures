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

/**
 *
 */
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

    /**
     * constructeur par valeurs de Tuile
     * @param imgId url de l'image : String
     * @param titreAnnonce titre de l'annonce : String
     * @param auteurAnnonce pseudo de l'auteur : String
     * @param description description : String
     * @param pied droit ou gauche : String
     * @param taille taille de la chaussure : int
     * @param etat etat de la chaussure : String
     * @param localisation localisation de l'auteur : String
     * @param cp code postal de l'auteur : int
     * @param prix prix de la chaussure : int
     */
    public Tuile(String imgId, String titreAnnonce, String auteurAnnonce, String description, String pied, int taille, String etat, String localisation, int cp, int prix) {
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

    /**
     * constructeur par firebase objet document de firebase
     * https://firebase.google.com/docs/firestore/query-data/get-data?authuser=0
     * @param document resultat de lecture de collection firebase : QueryDocumentSnapshot
     */
    public Tuile(QueryDocumentSnapshot document) {
        this.imgId = document.get("imgId").toString();
        this.titreAnnonce = document.get("titreAnnonce").toString();
        this.auteurAnnonce = document.getId();
        this.description = document.get("description").toString();
        this.pied = document.get("pied").toString();
        this.taille = new Integer(document.get("taille").toString());
        this.etat = document.get("etat").toString();
        this.localisation = document.get("localisation").toString();
        this.cp = new Integer(document.get("cp").toString());
        this.prix = new Integer(document.get("prix").toString());
    }

    /**
     * getteur de imgId (sous forme de bmp)
     * @return imgId converti en bmp
     * @throws IOException
     */
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

    /**
     * getteur de titreAnnonce
     * @return titreAnnonce
     */
    public String getTitreAnnonce() {
        return titreAnnonce;
    }

    /**
     * getteur de auteurAnnonce
     * @return auteurAnnonce
     */
    public String getAuteurAnnonce() {
        return auteurAnnonce;
    }

    /**
     * getteur de pied
     * @return pied
     */
    public String getPied() {
        return pied;
    }

    /**
     * getteur de taille
     * @return taille
     */
    public int getTaille() {
        return taille;
    }

    /**
     * getteur d'etat
     * @return etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * getteur de localisation
     * @return localisation
     */
    public String getLocalisation() {
        return localisation;
    }

    /**
     * getteur du code postal
     * @return cp
     */
    public int getCp() {
        return cp;
    }

    /**
     * getteur de description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * getteur de prix
     * @return prix
     */
    public String getPrix() {
        return prix+" €";
    }
}