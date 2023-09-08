import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();

    }
    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }
    private int leftChild( int index) {
        return 2 * index + 1;
    }
    private int rightChild( int index) {
        return 2 * index + 2;
    }
    private int parent( int index) {
        return (index - 1) / 2;
    }
    private void swap ( int index1, int index2) {
        int temp = heap.get( index1);
        heap.set( index1, heap.get(index2));
        heap.set(index2, temp);
    }
    public void insert ( int value) {
        heap.add(value); // built in method for List interface that adds element at the end of the list
        int current = heap.size()-1;
        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
              swap(current, parent(current));
              current = parent(current);
        }
    }
    public Integer remove () {
        // Always remove the top heap
        if(heap.size() == 0) return null;
        if ( heap.size() == 1 ) return heap.remove(0); // built in method for List interface that removes at index

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);
        return maxValue;
    }
    private void sinkDown (int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }
            if ( rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }
            if ( maxIndex != index) {
                swap(index, maxIndex); // swapping values
                index = maxIndex;
            } else {
                return;
            }
        }
    }
}
//////
public class Main {
    public static void main(String[] args) {

          Heap myHeap = new Heap();
          myHeap.insert(99);
          myHeap.insert(72);
          myHeap.insert(61);
          myHeap.insert(58);

          System.out.println(myHeap.getHeap());// [99, 72, 61, 58]

          myHeap.insert(100);

          System.out.println(myHeap.getHeap()); //  [100, 99, 61, 58, 72]
          myHeap.insert(75);

        System.out.println(myHeap.getHeap()); // [100, 99, 75, 58, 72, 61]

        Heap myHeaps = new Heap();
        myHeaps.insert(95);
        myHeaps.insert(75);
        myHeaps.insert(80);
        myHeaps.insert(55);
        myHeaps.insert(60);
        myHeaps.insert(50);
        myHeaps.insert(65);

        System.out.println(myHeaps.getHeap()); // [95, 75, 80, 55, 60, 50, 65]

        myHeaps.remove();

        System.out.println(myHeaps.getHeap());  // [80, 75, 65, 55, 60, 50]

        myHeaps.remove();

        System.out.println(myHeaps.getHeap());  // [75, 60, 65, 55, 50]
    }

}
