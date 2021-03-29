package com.jatin;

import javax.swing.*;
import java.lang.*;
import java.util.Locale;

public class Main {
    /**
     * @param args main method args
     */
    public static void main(String[] args) {
        //Show Welcome message to user
        JOptionPane.showMessageDialog(null, "Welcome User to Feels like Temprature calculator!!");
        /** String Builder class usage */
        StringBuilder selectMessage = new StringBuilder();
        /**String Builder method usage append: Usage 1 */
        selectMessage.append("Please enter day of week:");
        DayOfWeek day;
        Float windSpeed;
        Integer temperature;
        String input;
        while(true) {
            input = JOptionPane.showInputDialog(selectMessage);
            String errorMessage = "Invalid input";
            /**String Method usage concat: Usage 1 */
            errorMessage = errorMessage.concat(" for day of week!");
            if(input == null ) {
                JOptionPane.showMessageDialog(null, errorMessage);
                continue;
            }
            try {
                /**String Method usage toUpperCase: Usage 2 */
                //Getting day of week input
                day = DayOfWeek.valueOf(input.toUpperCase());
            }
            catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, errorMessage);
                continue;
            }

            break;
        }

        /**String Builder method replace: Usage 2 */
        selectMessage.replace(0, selectMessage.length() - 1, "Please enter " + day.toString()
                + "'s temprature in ℃");
        while(true) {
            String errorMessage = "Invalid input!";
            /**String Method usage replace: Usage 3 */
            errorMessage = errorMessage.replace("input", "input for temprature");
            input = JOptionPane.showInputDialog(selectMessage);
            if(input == null) {
                JOptionPane.showMessageDialog(null, errorMessage);
                continue;
            }
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, errorMessage);
                continue;
            }
            //Getting temprature of the day input
            temperature = Integer.parseInt(input);
            if(temperature < -100 || temperature > 100) {
                JOptionPane.showMessageDialog(null, errorMessage
                        + "\nMust be between -100 to 100 ℃");
                continue;
            }
            break;
        }
        /**String Builder method delete: Usage 3 */
        selectMessage.delete(0, selectMessage.length());
        selectMessage.append("Please enter " + day.toString()
                + "'s wind speed in kmph");
        while(true) {
            input = JOptionPane.showInputDialog(selectMessage);
            String errorMessage = "Invalid input for wind speed!";
            if(input == null ) {
                JOptionPane.showMessageDialog(null, errorMessage);
                continue;
            }
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, errorMessage);
                continue;
            }
            //Getting wind speed input
            windSpeed = Float.parseFloat(input);
            if(windSpeed < 0 || windSpeed > 100) {
                JOptionPane.showMessageDialog(null, errorMessage
                        + "\nMust be between 0 to 100 kmph");
                continue;
            }
            break;
        }

        //Create Temperature Calculator class object
        TemperatureCalculator tempCalc = new TemperatureCalculator(day, windSpeed, temperature);
        //Call Method to calculate feels like temperature
        tempCalc.calcFeelsLikeTemp();
        //Method to show feels like temperature to the user
        tempCalc.showFeelsLikeTemp();
    }
}
