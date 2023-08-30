
// Binary Search Trees use divide and conquer:
// Adding an item to a Binary Search Tree is O(n):
// lookup, remove() are O log n

public class BinarySearchTrees {
    // Binary search tree
    // highest value on the left
    Node root;
    // constructor fun is redundant;
//    public BinarySearchTrees( int value){
////        Node newNode = newNode(value);
////        root = newNode;
//       //  root = null;
//    }

    class Node {
        int value;
        Node left;
        Node right;
        Node (int value){
            this.value = value;
        }
    }
    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return true;
         }
          Node temp = root;
          while( true) {
              if (newNode.value == temp.value) return false;

              if (newNode.value < temp.value) {
                  if( temp.left == null) {
                      temp.left = newNode;
                      return true;
                   }
                  temp = temp.left;
             } else {
                  if( temp.right == null) {
                      temp.right = newNode;
                      return true;
                  }
                  temp = temp.right;
              }
          }
    }
     public boolean contains (int value) {
       //  if (root == null) return false; redundant
         Node temp = root;

         while (temp != null) {
             if (temp.value < value) {
                 temp = temp.right;
             } else if (temp.value > value) {
                 temp = temp.left;
             } else {
                 return true;
             }
          }
         return false;
     }
}

public class Main {
    public static void main(String[] args) {

        BinarySearchTrees myBST = new BinarySearchTrees();

         myBST.insert(47);
         myBST.insert(21);
         myBST.insert(76);
         myBST.insert(18);
         myBST.insert(52);
         myBST.insert(82);

         myBST.insert(27);

         System.out.println(myBST.root.left.right.value); // 27
        System.out.println(myBST.root.left.left.value); // 18

        //            47
        //        21      76
         //     18  27   52  82

        System.out.println(myBST.contains(82)); // true
        System.out.println(myBST.contains(17)); // false
    }

}
