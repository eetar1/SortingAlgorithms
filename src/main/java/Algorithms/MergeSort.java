package Algorithms;

import HelperClasses.ReadFile;

import java.nio.file.*;
import java.util.ArrayList;
import java.lang.System.*;
import java.io.*;

public class MergeSort implements Algorithm {

	public MergeSort(){}

	public ArrayList<Integer> sort(ArrayList<Integer> values){
		if(values.size() > 1){

			//Split the array
			ArrayList<Integer> left = new ArrayList<>(values.subList(0, values.size() / 2));
			ArrayList<Integer> right = new ArrayList<>(values.subList((values.size() / 2), values.size()));
			left = sort(left);
			right = sort(right);

			return merge(left,right);

		}
		else{//base case of array size 1
			return values;
		}

	}

	ArrayList<Integer> merge(ArrayList<Integer> left,ArrayList<Integer> right){
			ArrayList<Integer> out = new ArrayList<>();
		
		while(left.size() > 0 || right.size() > 0){
		
			if(left.size() == 0){
				out.addAll(right);
				return out;
			}
			else if (right.size() == 0){
				out.addAll(left);
				return out;
			}
			else if(left.get(0) < right.get(0)){
				out.add(left.remove(0));
			}
			else if (right.get(0) < left.get(0)){
				out.add(right.remove(0));
			}
		}

		return null;
	}

	public void main(String [] args){

		ReadFile fr = new ReadFile();
		String file = fr.readTestFile(args[0]);
		ArrayList<Integer> values = fr.tokenizeList(file);
		
		ArrayList<Integer> sortedValues = sort(values);
		
		for (Integer i : sortedValues){
			System.out.println(i);
		}
	}
}