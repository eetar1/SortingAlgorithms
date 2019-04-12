import java.nio.file.*;
import java.util.ArrayList;
import java.lang.System.*;
import java.io.*;
public class MergeSort{

	static String readTestFile(String fname){

			String file = "";

			Path cwd = Paths.get(".").toAbsolutePath();//get the test file stored in the parent directory
			cwd = cwd.getParent().getParent();
			String path = cwd.toString().toString() +"/"+ fname;

			try{
				FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);

				String chunk = "";
				while( (chunk = br.readLine()) != null){
					file += chunk;
				}
				br.close();
			}
			catch (IOException E){
				System.out.println(fname+" was not found");
			}

			return file;
		}

	static ArrayList<Integer> tokenizeList(String values){
		String [] chunks = values.split(" ");

		ArrayList<Integer> num = new ArrayList<Integer>(chunks.length);
	
		for(String s:chunks) num.add(Integer.valueOf(s));
	
		return num;
	}

	static ArrayList<Integer> sort(ArrayList<Integer> values){
		if(values.size() > 1){

			//Split the array
			ArrayList<Integer> left = new ArrayList<Integer>(values.subList(0, values.size()/2));
			ArrayList<Integer> right = new ArrayList<Integer>(values.subList((values.size()/2), values.size()));
			left = sort(left);
			right = sort(right);

			return merge(left,right);


		}
		else{//base case of array size 1
			return values;
		}

	}
	static ArrayList<Integer> merge(ArrayList<Integer> left,ArrayList<Integer> right){
			ArrayList<Integer> out = new ArrayList<Integer>();
		
		while(left.size() > 0 || right.size() > 0){
		
			if(left.size() == 0){
				out.addAll(right);
				return out;
			}
			else if (right.size() == 0){
				out.addAll(left);
				return out;
			}
			else if(left.size() > 0 && left.get(0) > right.get(0)){
				out.add(left.remove(0));
			}
			else if (right.size() > 0 && right.get(0) > left.get(0)){
				out.add(right.remove(0));
			}
		}
		return null;
	}
	public static void main(String [] args){
		String file = readTestFile(args[0]);
		ArrayList<Integer> values = tokenizeList(file);
		ArrayList<Integer> sortedValues = sort(values);
		
		for (Integer i : sortedValues){
			System.out.println(i);
		}


	}
}