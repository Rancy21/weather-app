package com.larr.weather.app.weather_app.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.apache.logging.log4j.util.Strings;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Day {
    @JsonProperty("datetime")
    private LocalDate date;
    private double tempmax;
    private double tempmin;
    private double temp;
    private double feelslike;
    private double humidity;
    private double precip;
    private double windspeed;
    private double uvindex;
    private LocalTime sunrise;
    private LocalTime sunset;
    private Strings description;
    private List<Hour> hours;
}
