import java.util.ArrayList;

class HeapSort{

    ArrayList<Integer> heap;

    void heapify(ArrayList<Integer> values){
        for(Integer i : values){
            heap.add(i);
            bubbleUp();
        }
    }

    void bubbleUp(){

        for(int i = heap.size()-1;i>0;i /=2){
            if( heap.get(i) > head.get(i/2)){
                
            }
        }
    }
    
    public void main(String args[]){

        ReadFile fr = new ReadFile();
		String file = fr.readTestFile(args[0]);
        ArrayList<Integer> values = fr.tokenizeList(file);
        head = new ArrayList<Integer>(values.size()*2);
      
    }
}