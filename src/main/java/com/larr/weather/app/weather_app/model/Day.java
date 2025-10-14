package com.larr.weather.app.weather_app.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

// import org.apache.logging.log4j.util.Strings;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Day {
    @JsonProperty("datetime")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private double tempmax;
    private double tempmin;
    private double temp;
    private double feelslike;
    private double humidity;
    private double precip;
    private double windspeed;
    private double uvindex;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime sunrise;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime sunset;
    private String description;
    private List<Hour> hours;
}
