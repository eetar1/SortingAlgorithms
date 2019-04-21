


class BubbleSort{

    static int[] sort(int[] values){
        boolean swap = false;

        do {
            swap = false;
            for(int i =0;i<values.length-1;i++){
                if(values[i] > values[i+1]){
                    int tmp = values[i];
                    values[i] = values[i+1];
                    values[i+1] = tmp;
                    swap = true;
                }
            }

        } while(swap);


        return values;
    }

    public static void main(String[] args){
        ReadFile fr = new ReadFile();
		String file = fr.readTestFile(args[0]);
        int[] values = fr.tokenizeListArr(file);
        
        int[] output = sort(values);
        
        for(int i : output){
            System.out.println(i);
        }

    }
}