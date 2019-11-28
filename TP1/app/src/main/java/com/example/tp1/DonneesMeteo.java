package com.example.tp1;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by maxime.esprit on 19/06/2019.
 */

public class DonneesMeteo
    {
        private CityInfo city_info;

        public CityInfo getCityInfo() { return this.city_info; }

        public void setCityInfo(CityInfo city_info) { this.city_info = city_info; }

        private CurrentCondition current_condition;

        public CurrentCondition getCurrentCondition() { return this.current_condition; }

        public void setCurrentCondition(CurrentCondition current_condition) { this.current_condition = current_condition; }



        private String m_sJonString;


        public DonneesMeteo(String sJsonString){
            try {
                m_sJonString = sJsonString;

                JSONObject object = new  JSONObject(sJsonString);

                city_info = new CityInfo(new JSONObject(object.getString("city_info")));

                current_condition = new CurrentCondition(object.getString("current_condition"));

            }
            catch (Exception e) {
                String sMsg = e.getMessage();
            }
        }

        public String toJsonString(){
            return m_sJonString;
        }
}
