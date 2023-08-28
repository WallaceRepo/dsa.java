public class LinkedList {
    private Node head;
    private Node tail;
    private int length;
    class Node {
        int value;
        Node next;

        Node( int value ){
            this.value = value;
        }

    }
    public LinkedList(int value) {
       Node newNode = new Node(value); // new keyword runs constructor on Node class.
        head = newNode;
        tail = newNode;
        length = 1;
    }
    // add items to linkedList
    public void append( int value) {
        Node newNode = new Node( value);
        if( tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    // remove items from LinkedList
    public Node removeLast(){
        Node temp = head;
        Node pre = head;
        if (tail == null || length == 0 || head == null) {
            return null;
        }
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
       if( length == 0) {
           head = null;
           tail = null;
       }
        return temp;
    }
    // prepend means add at the front of linkedList
    public void prepend( int value ) {
        Node newNode = new Node(value);
        if ( head == null) {
            tail = newNode;
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }
    // Remove item from the front
    public Node removeFirst() {
        Node tmp = head;
        head = head.next;
        tmp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return tmp;
    }
    // Get the node at the particular index
    public Node get( int index) {
        if( index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for ( int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    // Set the value at the node on particular index
    public boolean set( int index, int value ) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
     }
     // insert new node with given value at certain index position in linkedList
     public boolean insert(int index, int value){
        if ( index < 0 || index > length) return false;
        Node newNode = new Node(value);
         if( index == 0) {
             prepend(value);
             return true;
         }
         if ( index == length) {
             append(value);
             return true;
         }
         Node temp = get(index-1);
         newNode.next = temp.next;
         temp.next = newNode;
         length++;
         return true;
     }
    public Node remove(int index) {
        if(index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if(index == length-1) return removeLast();

        Node prev = get(index-1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }
    public void reverse(){
        // switch head and tail using temp var
        Node temp = head;
        head = tail;
        tail = temp;

        // to reverse, bring 2 more var after and before
        Node after = temp.next;
        Node before = null;

        for ( int i = 0; i < length; i++){
            after = after.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
     }
}
public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.append(2);
        myLinkedList.append(2);
        myLinkedList.prepend(10);
        System.out.println(myLinkedList.get(1).value);


//         System.out.println(myLinkedList.removeLast().value);
//         System.out.println(myLinkedList.removeLast().value);
//         System.out.println(myLinkedList.removeLast()); // .value() doesn't run on null. It will cause exception.

        System.out.println(myLinkedList.removeFirst().value);
        System.out.println(myLinkedList.removeFirst().value);
        System.out.println(myLinkedList.removeFirst()); // .value() doesn't run on null. It will cause exception.
       //

    }

}
