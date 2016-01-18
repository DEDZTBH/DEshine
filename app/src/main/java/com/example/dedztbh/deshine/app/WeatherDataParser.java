package com.example.dedztbh.deshine.app;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by peiqi on 2016/1/15.
 */
public class WeatherDataParser {

//    /**
//     * Given a string of the form returned by the api call:
//     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
//     * retrieve the maximum temperature for the day indicated by dayIndex
//     * (Note: 0-indexed, so 0 would refer to the first day).
//     */
//    public static double getMaxTemperatureForDayUsingString(String weatherJsonStr, int dayIndex)
//            throws JSONException {
//        int IndexOfdt = 0;
//        for (int i = 0; i<=dayIndex; i++){
//            IndexOfdt = weatherJsonStr.indexOf("\"dt\"",IndexOfdt+1);
//        }
//        int IndexOfmax = weatherJsonStr.indexOf("\"max\"",IndexOfdt);
//        int IndexOfComma = weatherJsonStr.indexOf(",",IndexOfmax);
//        String maxTemp = weatherJsonStr.substring(IndexOfmax+6, IndexOfComma);
////        System.out.print("Max Temp is " + maxTemp);
//        return Double.parseDouble(maxTemp);
//    }
//
//    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
//            throws JSONException {
//        JSONObject weather = new JSONObject(weatherJsonStr);
//        JSONArray days = new JSONArray("list");
//        JSONObject dayInfo = days.getJSONObject(dayIndex);
//        JSONObject temperatureInfo = dayInfo.getJSONObject("temp");
//        return temperatureInfo.getDouble("max");
//    }

}
