package com.example.tp1;

public class Jour {
    String ville;
    String condition;
    int humidity;
    int temperature;

    public Jour(String ville, String condition, int humidity, int temperature) {
        this.ville = ville;
        this.condition = condition;
        this.humidity = humidity;
        this.temperature = temperature;
    }

    public String getVille() {
        return ville;
    }
    public String getCondition() {
        return condition;
    }
    public int getHumidity() {
        return humidity;
    }
    public int getTemperature() {
        return temperature;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    //    String ville = data.getCityInfo().getName();
    //    int humidity = data.getCurrentCondition().getHumidity();
    //    String condition = data.getCurrentCondition().getCondition();
}
