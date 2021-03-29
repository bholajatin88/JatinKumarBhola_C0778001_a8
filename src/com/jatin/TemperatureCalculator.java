package com.jatin;

import javax.swing.*;
import java.util.ArrayList;

/** Enum for day of week */
enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

/**
 * Class for performing Temperature calculations
 */
public class TemperatureCalculator {
    /** Wrapper class usage of Integer
     * Wrapper class usage of Float
     * Wrapper class usage of Double
     */
    private ArrayList<Integer> temperatures;
    private ArrayList<Float> windSpeeds;
    private ArrayList<DayOfWeek> days;
    private Double feelsLikeTemp = 0.0;

    /**
     * default constructor
     */
    public TemperatureCalculator() {
        temperatures = new ArrayList<Integer>();
        windSpeeds = new ArrayList<Float>();
        days = new ArrayList<DayOfWeek>();
    }

    /**
     * Parameterized Constructor
     * @param day setup day of week for which temprature is calculated
     * @param windspeed setup wind speed on that day
     * @param temperature temperature of that day
     */
    public TemperatureCalculator(DayOfWeek day, Float windspeed, Integer temperature) {
        temperatures = new ArrayList<Integer>();
        windSpeeds = new ArrayList<Float>();
        days = new ArrayList<DayOfWeek>();
        temperatures.add(temperature);
        days.add(day);
        windSpeeds.add(windspeed);
    }

    /**
     * @return feels like temperature
     * Getter for feels like temp
     */
    public Double getFeelsLikeTemp() {
        return feelsLikeTemp;
    }

    /**
     *  @param feelsLikeTemp feels like temperature setup for class instance
     * Setter for feels like temp
     */
    public void setFeelsLikeTemp(Double feelsLikeTemp) {
        this.feelsLikeTemp = feelsLikeTemp;
    }

    //ArrayList Usage
    public ArrayList<Integer> getTemperatures() {
        return temperatures;
    }
    //ArrayList Usage
    public ArrayList<Float> getWindSpeeds() {
        return windSpeeds;
    }
    //ArrayList Usage
    public ArrayList<DayOfWeek> getDays() {
        return days;
    }

    /**
     * Method to calculate feels like temperature
     */
    public void calcFeelsLikeTemp() {
        Double temp = 1.8 * this.getTemperatures().get(0) + 32;
        Float speed = 0.621371f * this.getWindSpeeds().get(0);
        Double val = Math.pow(speed, 0.16);
        Double fTemp = 35.74 + 0.6215 * temp -
                35.75 * val + 0.4275 * temp * val;
        setFeelsLikeTemp((fTemp - 32) * 5/9);
    }

    /**
     * Method to show calculated feels like temperature to user
     */
    public void showFeelsLikeTemp() {
        JOptionPane.showMessageDialog(null, days.get(0).toString() +
                "'s feels like temperature is " + Math.round(getFeelsLikeTemp()) + "℃");
    }
}