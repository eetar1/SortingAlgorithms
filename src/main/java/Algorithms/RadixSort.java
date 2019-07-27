package Algorithms;

import DataStructure.Que;
import HelperClasses.ReadFile;

import java.util.ArrayList;

public class RadixSort implements Algorithm {

    public ArrayList<Integer> sort(ArrayList<Integer> values){
        Que[] radix = new Que[10];
        for(int x=0;x<10;x++){
            radix[x] = new Que();
        }

        int rad = 10;
        int itr = 1;
        for(int y=0;y<11;y++){  

            for(Integer val : values){
                radix[(val % rad)/itr].push(val);
                
            }
            values.clear();
            for(Que q: radix){
                while(q.size > 0){
                    values.add(q.pop());
                }
            }
            itr *= 10;
            rad *=10;
        }
        return values;
    }


    public static void main(String args[]){
        ReadFile fr = new ReadFile();
		String file = fr.readTestFile(args[0]);
        ArrayList<Integer> values = fr.tokenizeList(file);
        
        ArrayList<Integer> output = new RadixSort().sort(values);

        for(Integer i : output){
            System.out.println(i);
        }
    }
}