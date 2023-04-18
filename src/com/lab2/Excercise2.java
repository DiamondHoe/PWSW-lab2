package com.lab2;

import java.util.*;
import java.util.stream.Collectors;

public class Excercise2 extends Helpers implements IExcercise{
    public void Start(){
        Double[] range = new Double[] {2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0};

        System.out.println("Analiza statystyczna");
        String prompt = "Wpisz liczbę całkowitą";
        String inputMessage = "Wpisz liczbę całkowitą ze zbioru 2, 2.5, 3, 3.5, 4, 4.5, 5 lub 'x' aby zakończyć wpisywanie liczb";

        //Get Integer Array
        ArrayList<Double> numList = GetIntegerArrayList(prompt, inputMessage, range);

        //Print given list
        System.out.println(numList);

        //Print average
        System.out.println("Wartość średnia to: " + GetAverage(numList));

        //Print max and min
        System.out.println("Wartośc maksymalna to: " + GetMax(numList) + " Wartość minimalna to: " + GetMin(numList));

        //Print Above average
        System.out.println("Wartości powyżej średniej to: " +GetAboveAvg(numList, GetAverage(numList)));


        //Print occurance of each number
        for (Map.Entry<Double, Integer> entry : NumbersOccurence(numList).entrySet()) {
            System.out.println(entry.getKey() + " Wystąpiło " + entry.getValue() + " razy");
        }

        //Print Sum Of Squared Differences
        System.out.println("Średnie odchylenie standardowe: " + sumOfSquaredDifferences(numList, GetAverage(numList)));
    }

    public Double GetAverage(ArrayList<Double> numList){
        return numList
                .stream()
                .mapToDouble(a -> a)
                .average()
                .getAsDouble();
    }

    public Double GetMax(ArrayList<Double> numList){
        return numList
                .stream()
                .mapToDouble(a -> a)
                .max()
                .getAsDouble();
    }

    public Double GetMin(ArrayList<Double> numList){
        return numList
                .stream()
                .mapToDouble(a -> a)
                .min()
                .getAsDouble();
    }

    public ArrayList<Double> GetAboveAvg(ArrayList<Double> numList, Double average){
        return numList
                .stream()
                .filter(value -> value > average)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Map<Double, Integer> NumbersOccurence(ArrayList<Double> numList){
        Map<Double, Integer> countMap = new HashMap<Double, Integer>();
        for (Double number : numList) {
            if (countMap.containsKey(number)) {
                countMap.put(number, countMap.get(number) + 1);
            } else {
                countMap.put(number, 1);
            }
        }
        return countMap;
    }

    public Double sumOfSquaredDifferences(ArrayList<Double> numList, Double average){
        double sumOfSquaredDifferences = 0.0;
        for (Double value : numList) {
            double difference = value - average;
            double squaredDifference = difference * difference;
            sumOfSquaredDifferences += squaredDifference;
        }
        return Math.sqrt(sumOfSquaredDifferences / numList.size());
    }
}

