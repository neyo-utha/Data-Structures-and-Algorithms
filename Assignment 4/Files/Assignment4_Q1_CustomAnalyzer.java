import java.io.*;

/**
 * @author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class Assignment4_Q1_CustomAnalyzer
{
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("\nQuestion 1 part three, develop and demonstrate another decision tree that is more complex than backpainanalyzer,\nprovide two correct traversals of this tree");
    
        //Traversal 1 of custom decision tree
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("Traversal 1: ");
        System.out.println("Let's see what your spirit animal is!");
        DecisionTree case1 = new DecisionTree("animal.txt");
        case1.evaluate();
        System.out.println("|-------------------------------------------------------|\n\n");
        //Traversal 2 of custom decision tree
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("Traversal 2: ");
        System.out.println("Let's see what your spirit animal is!");
        DecisionTree case2 = new DecisionTree("animal.txt");
        case2.evaluate();
        System.out.println("|-------------------------------------------------------|\n\n");
        //Traversal 3 of custom decision tree
        System.out.println("\n|-------------------------------------------------------|");
        System.out.println("Traversal 3: ");
        System.out.println("Let's see what your spirit animal is!");
        DecisionTree case3 = new DecisionTree("animal.txt");
        case3.evaluate();
        System.out.println("|-------------------------------------------------------|\n\n");
    }
}