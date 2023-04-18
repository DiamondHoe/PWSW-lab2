package com.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Helpers {

    public int GetInt(String prompt, String inputMessage){
        Scanner sc = new Scanner(System.in);

        int returnValue = 0;
        boolean _getInput = true;

        System.out.println(prompt);

        while (_getInput) {
            System.out.println(inputMessage);
            String inputValue = sc.next();

            if (Objects.equals(inputValue, "x")){
                _getInput = false;
            }
            else if(IsNumber(inputValue)){
                returnValue = Integer.parseInt(inputValue);
                _getInput = false;
            }
        }

        return returnValue;
    }

    ArrayList<Integer> GetIntegerArrayList(String prompt, String inputMessage)
    {
        ArrayList<Integer> returnArray = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        boolean _getInput = true;
        System.out.println(prompt);

        while (_getInput) {
            System.out.println(inputMessage);
            String inputValue = sc.next();

            if (Objects.equals(inputValue, "x")){
                _getInput = false;
            }
            else if(IsNumber(inputValue)){
                returnArray.add(Integer.parseInt(inputValue));
            }
        }
        return returnArray;
    }

    ArrayList<Double> GetIntegerArrayList(String prompt, String inputMessage, Double[] range)
    {
        ArrayList<Double> returnArray = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        boolean _getInput = true;
        System.out.println(prompt);

        while (_getInput) {
            System.out.println(inputMessage);
            String inputValue = sc.next();

            if (Objects.equals(inputValue, "x")){
                _getInput = false;
            }
            else if(IsDouble(inputValue) && Arrays.asList(range).contains(Double.parseDouble(inputValue))){
                returnArray.add(Double.parseDouble(inputValue));
            }
            else{
                System.out.println("Podana liczba nie zawiera się w przedziale");
            }
        }
        return returnArray;
    }

    public boolean IsNumber(String number){
        try {
            Integer intValue = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Wpisana wartość nie jest liczbą!");
            return false;
        }
    }

    public boolean IsDouble(String doubleNumber){
        try {
            Double doubleValue = Double.parseDouble(doubleNumber);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Wpisana wartość nie jest liczbą double!");
            return false;
        }
    }
}
