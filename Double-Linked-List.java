public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    public DoublyLinkedList(int value ){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    class Node {
        int value;
        Node next;
        Node prev;
        Node(int value) {
            this.value = value;
        }
    }
    public void getHead() {
        System.out.println("Head: " + head.value);
    }
    public void printList(){
       Node temp = head;
       while ( temp != null){
           System.out.println(temp.value);
           temp =temp.next;
       }
    }
    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }
    public void getLength() {
        System.out.println("Length: " + length);
    }
    // append or add at the end
    public void append(int value){
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
         } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    public Node removeLast(){
        if (length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = temp.prev;
            tail.next = null;
            temp.prev = null;
        }
       length--;
       return temp;
    }
    public void prepend(int value){
       Node newNode = new Node(value);
       if( length == 0) {
           tail = newNode;
           head = newNode;
       } else {
           newNode.next = head;
           head.prev = newNode;
           head = newNode;
       }
       length++;
    }
    public Node removeFirst(){
        if (length == 0) return null;
        Node temp = head;
        if( length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
         }
        length--;
        return temp;
    }
    public Node get(int index){
        if(index < 0 || index >= length) return null;
        Node temp;
        if( index <= length / 2) {
            temp = head;
            for ( int i = 0; i < index; i++) {
                temp = temp.next;
             }
          } else {
            temp = tail;
            for ( int i = length-1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }
    public boolean set(int index, int value) {
        Node temp = get(index);
        if ( temp!= null) {
            temp.value = value;
            return true;
        }
      return false;
    }
    public boolean insert( int index, int value) {
        if ( index < 0 || index > length) return false;
        if( index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = get(index-1);
        Node after = before.next;

        newNode.prev = before;
        before.next = newNode;

        newNode.next = after;
        after.prev = newNode;

        length++;
       return true;
    }
    public Node remove( int index){
        if( index < 0 ||  index >= length) return null;
        if ( index == 0) return removeFirst();
        if (index == length-1) return removeLast();

        Node temp = get(index);
        // there are different way using before and after variable;
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;

        temp.next = null;
        temp.prev = null;

        length--;
        return temp;
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myDDL = new DoublyLinkedList(1);
//         myDDL.getHead();
//         myDDL.getTail();
//         myDDL.getLength();

//         myDDL.append(4);
//         myDDL.prepend(0);
 //        myDDL.set(0, 4);
         myDDL.insert(0,45);
         myDDL.insert(1, 88);
         myDDL.remove(3);
         myDDL.printList();

//         System.out.println(myDDL.removeLast().value);
//         System.out.println(myDDL.removeLast().value);

//           System.out.println(myDDL.removeFirst().value);
//           System.out.println(myDDL.removeFirst().value);
//           System.out.println(myDDL.removeFirst().value);
//           System.out.println(myDDL.removeFirst());
//        System.out.println(myDDL.get(1).value);
//        System.out.println(myDDL.get(2).value + "\n");


    }

}
