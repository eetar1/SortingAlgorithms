import java.util.ArrayList;

class RadixSort{


    static int[] sort(int[] values){

        int[][] radix = new int[10][values.length];
        int rad = 10;
        int itr = 1;
        for(int i : values){
            int idx = i % rad;
            radix[idx/itr][radix[idx].length] = i;
        }
        


        return values;
    }

    public static void main(String args[]){
        ReadFile fr = new ReadFile();
		String file = fr.readTestFile(args[0]);
        int[] values = fr.tokenizeListArr(file);
        
        values = sort(values);
    }
}