import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    // nodes are called vertex in graph :) Vertex == Node ; vertexies
    // Edges and weighted edges, edges directional, edges by-directional

    // examples are network routing protocol, and facebook friend network, and instagram follow

    // ADGENCANCY MATRIX Adgencancy List
    // Hash Map is -> key, value pairs -> { }
    // { "A" = []
    //  }
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();
    public void printGraph(){
        System.out.println(adjList);
    }
    public boolean addVertex(String vertex) {
        if ( adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
       return false;
    }
    public boolean addEdge( String vertex1, String vertex2) {
        if( adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;

    }

    public boolean removeEdge ( String vertex1, String vertex2) {
        if(adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex1);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
       return false;
    }
    public boolean removeVertex ( String vertex) {
        if( adjList.get(vertex) == null ) return false;
        for( String otherVertex : adjList.get(vertex)){
            adjList.get(otherVertex).remove(vertex);

        }
        adjList.remove(vertex);
        return true;
    }
}

///
public class Main {
    public static void main(String[] args) {

        Graph myGraph = new Graph();
        myGraph.addVertex("A");  // {A=[] }
        myGraph.addVertex("B"); // {A=[], B=[]}
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("A", "D");
      //  myGraph.removeEdge("A", "B");
        myGraph.addEdge("B", "D");
        myGraph.addEdge("C", "D");

        myGraph.removeVertex("D"); // {A=[B, C], B=[A], C=[A]}

        myGraph.printGraph();  // {A=[B], B=[A]}

        // {A=[B, C], B=[C], C=[A, B]}

    }
}
