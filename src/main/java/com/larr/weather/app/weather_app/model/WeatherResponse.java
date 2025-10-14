package com.larr.weather.app.weather_app.model;

import java.util.List;

// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WeatherResponse {
    private double latitude;
    private double longitude;
    private String address;
    private String timezone;
    private double tzoffset;
    private String description;
    private List<Day> days;
}
