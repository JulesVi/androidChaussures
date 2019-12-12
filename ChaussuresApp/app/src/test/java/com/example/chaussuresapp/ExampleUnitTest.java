package com.example.chaussuresapp;

import android.os.StrictMode;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    // permet de tester la forme de l'url (si il est bien créé) et 200 s'il retourne bien un lien
    public void imageValidator_CorrectLinkSimple_ReturnsTrue() {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            URL url = new URL("https://scene7.zumiez.com/is/image/zumiez/pdp_hero/New-Balance-Numeric-306-Foy-Blue-%26-Red-Skate-Shoes-_320281-front-US.jpg");
            HttpsURLConnection huc = (HttpsURLConnection) url.openConnection();
            int responseCode = huc.getResponseCode();
            Assert.assertEquals(HttpsURLConnection.HTTP_OK, responseCode);
        } catch (IOException e) {}
    }

    @Test
    public void imageValidator_InvalidUrlNoHttp_ReturnFalse() {
        boolean imgExist = false;
        try {
            URL url = new URL("scene7.zumiez.com/is/image/zumiez/pdp_hero/New-Balance-Numeric-306-Foy-Blue-%26-Red-Skate-Shoes-_320281-front-US.jpg");
            imgExist = true;
        } catch (MalformedURLException e) {
        }
        assertFalse(imgExist);
    }

    @Test
    public void imageValidator_NullUrl_ReturnFalse() {
        boolean imgExist = false;
        try {
            URL url = new URL("");
            imgExist = true;
        } catch (MalformedURLException e) {
        }
        assertFalse(imgExist);
    }


}