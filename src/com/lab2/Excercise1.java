package com.lab2;

import java.util.ArrayList;

public class Excercise1 extends Helpers implements IExcercise {

        public void Start(){
                String prompt = "Wpisz liczbę całkowitą";
                String inputMessage = "Wpisz liczbę całkowitą lub 'x' aby zakończyć wpisywanie liczb";

                System.out.println("Witaj w sortowaniu podanych liczb");

                ArrayList<Integer> numList = GetIntegerArrayList(prompt, inputMessage);

                System.out.println(BubbleSort(numList));
        }

        public ArrayList<Integer> BubbleSort(ArrayList<Integer> array) {
                int temp = 0;
                for(int i=0; i < array.size(); i++){
                        for(int j=1; j < (array.size()-i); j++){
                                if(array.get(j-1) > array.get(j)){
                                        temp = array.get(j-1);
                                        array.set(j-1, array.get(j));
                                        array.set(j, temp);
                                }
                        }
                }
                return array;
        }
}
