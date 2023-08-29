public class Stack {
    private Node top;
    private int height;
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
    // stack constructor
    public Stack( int value) {
        Node newNode = new Node( value);
        top = newNode;
        height = 1;
    }
    public void printStack(){
        Node temp = top;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void getTop(){
        System.out.println("Top: " + top.value);
    }
    public void getHeight(){
        System.out.println("Height: " + height);
    }

    // Push method
    public void push(int value) {
        Node newNode = new Node(value);
        if(height == 0) {
           top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }
    public Node pop() {
        if(height == 0 ) return null;

       Node temp = top;
       top = top.next;
       temp.next = null;

       height--;
       return temp;
    }
}
public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(4);

        myStack.getTop();
        myStack.getHeight();
        myStack.push(10);
        myStack.push(11);
        myStack.push(12);
        myStack.pop();
        myStack.printStack();



    }

}
