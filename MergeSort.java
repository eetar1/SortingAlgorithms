import java.util.Scanner;
import java.util.ArrayList;
import java.lang.System.*;
import java.io.*;
public class MergeSort{

	static String readTestFile(String fname){
			String file = "";

			try{
				FileReader fr = new FileReader(fname);
			}
			catch (IOException E){
				System.out.println(fname+" was not found");
			}
			
	

			return file;
		}

	static ArrayList<Integer> tokenizeList(String values){
		String [] chunks = values.split(" ");

		ArrayList<Integer> num = new ArrayList<Integer>(chunks.length);
	
		for(String s:chunks){
			System.out.println(s);
			//num.add(Integer.valueOf(s));
		}
	
		return num;
	}
		public static void main(String [] args){
			String file = readTestFile(args[0]);
			ArrayList<Integer> values = tokenizeList(file);

			for(Integer i:values){
				System.out.println(i);
			}


	
		}
}