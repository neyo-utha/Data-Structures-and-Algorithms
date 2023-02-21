import java.io.*;

/**
 * @author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class Assignment4_Q1_BackPainAnalyzer
{
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("\nQuestion 1 part one, Show the textbook output from listing 19.6. \nThe level order node is displayed in brackets for elements in the tree for easy tracking");
        
        //Initial output to match textbook listing
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("So, you're having back pain.");
        DecisionTree case1 = new DecisionTree("input.txt");
        case1.evaluate();
        System.out.println("|-------------------------------------------------------|\n\n");
        
        System.out.println("Question 1 part two, show two other correct traversals of this tree");
        //traversal 2 of textbook tree
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("Traversal 1: ");
        System.out.println("So, you're having back pain.");
        DecisionTree case2 = new DecisionTree("input.txt");
        case2.evaluate();
        System.out.println("|-------------------------------------------------------|\n\n");
    
        //traversal 3 of textbook tree
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("Traversal 2: ");
        System.out.println("So, you're having back pain.");
        DecisionTree case3 = new DecisionTree("input.txt");
        case3.evaluate();
        System.out.println("|-------------------------------------------------------|\n\n");
        
    }
}