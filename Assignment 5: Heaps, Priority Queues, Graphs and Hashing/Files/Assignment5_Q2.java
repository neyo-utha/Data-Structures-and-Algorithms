import jsjf.Graph;
import java.util.Arrays;

/**
 * @author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class Assignment5_Q2
{
    
    public static void main(String[] args)
    {
        System.out.println("\n||--------------------------------------------------------------------------------------------------||\n");
    
        System.out.println("Question 2, complete the implementation of graph.java using an adjacency matrix.\nShow test cases for implemented methods ");
        
        //Create a graph, test isEmpty() and toString()
        System.out.println("\n\nCreate a new graph and test the isEmpty and toString methods.");
        Graph<String> graph = new Graph<String>();
        System.out.println("isEmpty(): " + graph.isEmpty());
        System.out.println("toString(): " + graph);
       
        //Add vertices to the graph and display it then test isEmpty() again
        System.out.println("\n\nAdd vertices A,B,C and D to the graph, display the graph, \ntest isEmpty again and check size. ");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        System.out.print(graph);
        System.out.println("isEmpty(): " + graph.isEmpty());
        System.out.println("size(): " + graph.size());
        
        //Add edges between the vertices using vertex and index values
        System.out.println("\n\nAdd edges between A and B using vertex values. \nAdd edges between C and D using indexes 2 and 3. \nDisplay the graph.\nCheck connectivity.");
        graph.addEdge("A","B"); //vertex A and B
        graph.addEdge(2,3); //C is index 2 and D is index 3
        System.out.print(graph);
        System.out.println("isConnected(): " + graph.isConnected());
        
        //Testing connectivity
        System.out.println("\n\nFully connect the graph and test connectivity again.");
        graph.addEdge(0,0);//connect diagonals
        graph.addEdge(1,1);
        graph.addEdge(2,2);
        graph.addEdge(3,3);
        graph.addEdge(0,2);//connect upper right quadrant, lower left will be connected via mirroring since undirected
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        System.out.print(graph);
        System.out.println("isConnected(): " + graph.isConnected());
    
        //Testing addVertex without a value and toString with null value
        System.out.println("\n\nAdd an empty vertex. \nDisplaying the vertices here is an edge case because of the null value present that was resolved (check toString)");
        graph.addVertex();
        System.out.print(graph);
        
        //Testing getIndex with repeated vertex to ensure first occurrence, null vertex and non existent vertex
        System.out.println("\n\nAdd three more vertices \"E\", \"E\" and \"F\" \nGet the index of the first E vertex and the null vertex (edge case: see getIndex implementation). " +
                "\nTest getIndex on a vertex that doesn't exist (Z)."+"\nTest connectivity and size again.");
        graph.addVertex("E");
        graph.addVertex("E");
        graph.addVertex("F");
        System.out.print(graph);
        System.out.println("getIndex(E): " + graph.getIndex("E") + ", getIndex(null): " + graph.getIndex(null) + ", getIndex(Z): " + graph.getIndex("Z"));
        System.out.println("isConnected(): " + graph.isConnected() + ", size(): " + graph.size());
        
        //Testing the removeVertex methods
        System.out.println("\n\nRemove the null vertex at index 4. \nRemove the extra \"E\" vertex at index 5. " +
                "\nConnect the graph and test connectivity and size again.");
        graph.removeVertex(4);
        graph.removeVertex("E");
        graph.addEdge(0,4);
        graph.addEdge(0,5);
        graph.addEdge(1,4);
        graph.addEdge(1,5);
        graph.addEdge(2,4);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,4);
        graph.addEdge(4,5);
        graph.addEdge(5,5);
        System.out.print(graph);
        System.out.println("isConnected(): " + graph.isConnected() + ", size(): " + graph.size());
    
        //Testing the removeEdges methods
        System.out.println("\n\nRemove Edges between (1,1), (B,E) and (E,E)");
        graph.removeEdge(1,1);
        graph.removeEdge("B","E");
        graph.removeEdge("E","E");
        System.out.print(graph);
        
        //Testing the getVertices method
        System.out.println("\n\nPrint out the vertices of the graph \nusing the getVertices() method.");
        System.out.println(Arrays.toString(graph.getVertices()));
        
        //Edge cases
        System.out.println("\n\nCheck edge cases where attempting to remove a vertex at an index that doesn't exist (6),"
                            +"\nand removing an edge that does not exist with a vertex that does not exist (A,Z).");
        graph.removeVertex(6);
        graph.removeEdge("A","Z");
        
        
    }
}