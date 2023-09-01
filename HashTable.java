import java.util.ArrayList;
// Big O of hashmap
// set -> O(1)
// get -> O (1)

//
public class HashTable {
    // separate chaining is to dealing with collision; we use linked list
    // linear probing is one of the type Open addressing

    // constructor
    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
         dataMap = new Node[size];

    }

    public class Node {
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public void printTable() {
        for ( int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while ( temp != null) {
                System.out.println(" {" +temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }
    private int hash( String key) {
        // key = "paint";
        int hash = 0;

        char[] keyChars = key.toCharArray(); // ['p','a','i','n','t']
        for( int i = 0; i < keyChars.length; i++ ) {
              int asciiValue = keyChars[i]; // 112 for 'p' ascii
              hash = (hash + asciiValue * 23) % dataMap.length; // hash % 7
            }
        return hash;
    }
    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while( temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
          while (temp != null) {
              if(temp.key == key) return temp.value;
              temp = temp.next;
          }
          return 0;
    }
    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList<>();

        for ( int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while ( temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
       return allKeys;
    }
}
//
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashTable myHashTable = new HashTable();

        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);
        myHashTable.set("bolts", 200);
        myHashTable.set("screws", 140);

        System.out.println(myHashTable.get("lumber")); // 80
        System.out.println(myHashTable.get("ruler")); // 0

        // myHashTable.printTable();
        System.out.println(myHashTable.keys()); // [screws, bolts, nails, tile, lumber]

        // Interview Questions

        int[] array1 = { 1,2,5};
        int[] array2 = { 2, 4, 5};

       // System.out.println( itemInCommon(array1, array2));
        System.out.println( hashInCommon(array1, array2));
    }
    // Interview Question to check 2 arrays
    public static boolean itemInCommon( int[] array1, int[] array2) {
        // O (n^2)
        for ( int i : array1) {
            for ( int j : array2) {
                if( i == j) return true;
            }
        }
        return false;
    }

    public static boolean hashInCommon( int [] array1, int[] array2) {
      //   0(n)
        HashMap< Integer, Boolean> myHashMap = new HashMap<>();
        for ( int i : array1) {
            myHashMap.put(i, true);
        }
        for ( int j : array2) {
            if (myHashMap.get(j) != null ) return true;
        }
        return false;
    }
}
/*

0:
1:
2:
3:
 {screws= 140}
4:
 {bolts= 200}
5:
6:
 {nails= 100}
 {tile= 50}
 {lumber= 80}

Process finished with exit code 0

 */
