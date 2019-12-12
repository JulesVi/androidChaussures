package com.example.chaussuresapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.chaussuresapp.Class.Tuile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit tests for the {@link Tuile}.
 */
@RunWith(MockitoJUnitRunner.class)
public class TuilesTestMockito {
    private String TEST_imgId = "New-Balance-Numeric-306-Foy-Blue-%26-Red-Skate-Shoes-_320281-front-US.jpg";
    private String TEST_titreAnnonce = "TestTitre";
    private String TEST_auteurAnnonce = "TestAuteur";
    private String TEST_description = "Test dune description longue et complete";
    private String TEST_pied = "TestDroit";
    private int TEST_taille = 43;
    private String TEST_etat = "Test";
    private String TEST_localisation = "TestGrenoble";
    private int TEST_cp = 38000;
    private int TEST_prix = 25;

    @Mock
    Tuile mTuile;

    @Before
    public void initMocks() {
        mTuile = new Tuile(TEST_imgId, TEST_titreAnnonce, TEST_auteurAnnonce, TEST_description, TEST_pied, TEST_taille, TEST_etat, TEST_localisation, TEST_cp, TEST_prix);
    }

    @Test
    public void TuilesTestMockito_CreateBitmapImgOnURL() {
        //fonctionne uniquement avec les images HTTPS
        Bitmap bmp = BitmapFactory.decodeFile(TEST_imgId);
        // a corriger, check si bmp est bien un bitmap
//        Bitmap m_bmp = BitmapFactory.decodeFileDescriptor(R.drawable.imgtest);
//        assertThat("Check that bitmap creating on url...return bitmap", bmp, is(m_bmp));
    }
}