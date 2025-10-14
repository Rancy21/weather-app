package com.larr.weather.app.weather_app.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Hour {
    @JsonProperty("datetime")
    private LocalTime time;
    private double temp;
    private double humidity;
    private double feelslike;
    private double precip;
    private double windspeed;
    private double uvindex;
    private String conditions;
}
