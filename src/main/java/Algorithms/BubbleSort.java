package Algorithms;


import HelperClasses.ReadFile;

import java.util.ArrayList;

public class BubbleSort implements Algorithm {

    public ArrayList<Integer> sort(ArrayList<Integer> values) {
        boolean swap = false;

        do {
            for (int i = 0; i < values.size() - 1; i++) {
                if (values.get(i) > values.get(i + 1)) {
                    int tmp = values.get(i);
                    values.set(i, values.get(i + 1));
                    values.set(i + 1, tmp);
                    swap = true;
                } else {
                    swap = false;
                }
            }

        } while (swap);


        return values;
    }

    public static void main(String[] args) {
        ReadFile fr = new ReadFile();
        String file = fr.readTestFile(args[0]);
        ArrayList<Integer> values = fr.tokenizeList(file);

        ArrayList<Integer> output = new BubbleSort().sort(values);

        for (int i : output) {
            System.out.println(i);
        }

    }
}