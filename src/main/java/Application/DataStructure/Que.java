package Application.DataStructure;

public class Que{
    public IntNode head;
    public IntNode tail;
    public int size = 0;
    public void push(int val){

        if(head == null){
            IntNode tmp = new IntNode(val);
            head = tmp;
            tail = tmp;
        }
        else{
            IntNode tmp = new IntNode(val);
            tail.right = tmp;
            tail = tail.right;
        }
        size++;
    }
    public int pop(){
        int tmp = head.value;
        head = head.right;
        size--;
        return tmp;
        

    }
    public Que(){
        head = null;
        tail = null;
    }
}