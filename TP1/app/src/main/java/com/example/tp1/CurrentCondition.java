package com.example.tp1;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by maxime.esprit on 19/06/2019.
 */

public class CurrentCondition {
    private String date;

    public String getDate() { return this.date; }

    public void setDate(String date) { this.date = date; }

    private String hour;

    public String getHour() { return this.hour; }

    public void setHour(String hour) { this.hour = hour; }

    private int tmp;

    public int getTmp() { return this.tmp; }

    public void setTmp(int tmp) { this.tmp = tmp; }

    private int wnd_spd;

    public int getWndSpd() { return this.wnd_spd; }

    public void setWndSpd(int wnd_spd) { this.wnd_spd = wnd_spd; }

    private int wnd_gust;

    public int getWndGust() { return this.wnd_gust; }

    public void setWndGust(int wnd_gust) { this.wnd_gust = wnd_gust; }

    private String wnd_dir;

    public String getWndDir() { return this.wnd_dir; }

    public void setWndDir(String wnd_dir) { this.wnd_dir = wnd_dir; }

    private int pressure;

    public int getPressure() { return this.pressure; }

    public void setPressure(int pressure) { this.pressure = pressure; }

    public int humidity;

    public int getHumidity() {return humidity;}

    public void setHumidity(int humidity) {this.humidity = humidity;}

    public String condition;

    public String getCondition() {return condition;}

    public void setCondition(String condition) { this.condition = condition;}

    public String condition_key;

    public String getCondition_key() {return condition_key;}

    public void setCondition_key(String condition_key) {this.condition_key = condition_key;}

    public CurrentCondition(String sJson) throws JSONException {

	JSONObject object = new JSONObject(sJson);

        date = object.getString("date");
        hour = object.getString("hour");
        tmp = object.getInt("tmp");
        wnd_spd = object.getInt("wnd_spd");
        wnd_gust = object.getInt("wnd_gust");
        wnd_dir = object.getString("wnd_dir");
        pressure = object.getInt("pressure");
    }
}
