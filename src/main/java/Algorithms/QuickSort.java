package Algorithms;

import HelperClasses.ReadFile;

import java.util.ArrayList;
import java.lang.Math;

public class QuickSort implements Algorithm{


    public ArrayList<Integer> sort(ArrayList<Integer> values){

        if(values.size() < 2){
            return values;
        }
        else {
            ArrayList<Integer> hi = new ArrayList<>(values.size());
            ArrayList<Integer> lo = new ArrayList<>(values.size());
    
            int pivot = getRandomPivot(values.size());
            Integer listPivot = values.get(pivot);

            for(Integer i : values){
                if(i < listPivot){
                    lo.add(i);
                }
                else {
                    hi.add(i);
                }
            }
            hi = sort(hi);
            lo = sort(lo);  
            lo.addAll(hi);
            return lo;
        }


    }

    static int getRandomPivot(int max){
        double pivot = (Math.random()*max);

        return (int)pivot;
    }

    public static void main(String[] args) {
        ReadFile RF = new ReadFile();
        String file = RF.readTestFile(args[0]);

        ArrayList<Integer> values = RF.tokenizeList(file);

        values  = new QuickSort().sort(values);
        for(Integer i : values){
            System.out.println(i);
        }
    }
}