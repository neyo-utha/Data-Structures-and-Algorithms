import jsjf.LinkedBinarySearchTree;
import jsjf.ArrayList;
import java.util.Iterator;

/**
 * @author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class Assignment4_Q2
{
    public static void main(String[] args)
    {
        
        System.out.println("\nQuestion 2 part one, show that all implemented methods in LinkedBinarySearchTree work.\nInclude edge cases where applicable.");
    
        System.out.println("\n||--------------------------------------------------------------------------------------------------||\n");
        //Create a new binary search tree with the root element set as 4 using the constructor parameter
        LinkedBinarySearchTree tree = new LinkedBinarySearchTree<Integer>(4);
        System.out.println("A new tree is created with the root set to 4.");
        
        //Add elements to this tree with the addElement() method
        tree.addElement(2);
        tree.addElement(6);
        tree.addElement(1);
        tree.addElement(3);
        tree.addElement(5);
        tree.addElement(7);
        tree.addElement(8);
        System.out.println("The following numbers were added to the tree in this order: 2,6,1,3,5,7,8");
        
        System.out.println("\nBelow there are in order and level order traversals of the tree,\nPlease reference this as the initial snapshot of the tree before methods are tested\n");
        System.out.println("This is the inorder representation of the tree");
        System.out.println(tree);
        
        
        int treeSize;//used to compare against counter to see when to add the bracket
        int counter; //when counter exceeds the size of the tree by 1 the else condition is achieved and a bracket is added
    
        //This allows me to print out the level order as a tree contained within brackets as well just like my toString method
        System.out.println("This is the level order representation of the tree");
        Iterator iterator = tree.iteratorLevelOrder();
        String result = "[";
        treeSize = tree.size();
        counter = 1;
        //Print using the iterator
        while(iterator.hasNext())
        {
            if(counter < treeSize)
            {
                result = result + iterator.next() + ", ";
                counter++;
            }
            else
            {
                result = result + iterator.next() +  "]";
            }
        }
        System.out.println(result + "\n");
    
        //Test cases for the implemented methods
        System.out.println("Test cases for the implemented methods: \n");
        
        System.out.println("findMin(): ");
        System.out.println("The smallest value in the tree is: " + tree.findMin());
        System.out.println("Tree after method execution: ");
        System.out.println(tree);
        System.out.println();
    
        System.out.println("findMax(): ");
        System.out.println("The largest value in the tree is: " + tree.findMax());
        System.out.println("Tree after method execution: ");
        System.out.println(tree);
        System.out.println();
        
        System.out.println("removeMax(): ");
        System.out.println("The element removed is: " + tree.removeMax());
        System.out.println("Tree after method execution: ");
        System.out.println(tree);
        System.out.println();
    
        System.out.println("getLeft(): ");
        System.out.println("The left subtree is: " + tree.getLeft());
        System.out.println("Tree after method execution: ");
        System.out.println(tree);
        System.out.println();
    
        System.out.println("getRight(): ");
        System.out.println("The right subtree is: " + tree.getRight());
        System.out.println("Tree after method execution: ");
        System.out.println(tree);
        System.out.println();
    
        //The following are test cases for edge cases which result in an exception being thrown you can uncomment these sections to test edge cases
        //System.out.println("Test cases for the edge cases: \n");
        //Create new tree for test cases
        //LinkedBinarySearchTree edgeCase = new LinkedBinarySearchTree<>();
        //System.out.println("An exception is thrown when the tree is empty for all methods implemented an example below getLeft()\n");
        //System.out.println(edgeCase.getLeft());
        
        
        System.out.println("||--------------------------------------------------------------------------------------------------||\n");
    
        System.out.println("\nQuestion 2 part two, show that the implemented method to balance a tree works.\nInclude test cases for two different degenerate trees and output height before and after balancing.\nInclude another test case, insert into a balanced tree and create a degenerate tree. \nBalance the degenerate tree and output the height before and after.");
        System.out.println("\n||--------------------------------------------------------------------------------------------------||\n");
        
        //Create degenerate trees
        System.out.println("|--- Create the first degenerate tree by adding elements to a tree with root of 7. ---|\nElements added in order: \"6,5,4,3,2,1\"\n");
        LinkedBinarySearchTree degenTree1 = new LinkedBinarySearchTree<>(7);
        degenTree1.addElement(6); //add elements to tree to create degenerate tree
        degenTree1.addElement(5);
        degenTree1.addElement(4);
        degenTree1.addElement(3);
        degenTree1.addElement(2);
        degenTree1.addElement(1);
        
        //Print out the trees
        System.out.println("The degenerate tree (in order) : " + degenTree1);
        System.out.print("The degenerate tree (level order) : ");
        iterator = degenTree1.iteratorLevelOrder();
        result = "[";
        treeSize = degenTree1.size();
        counter = 1;
        while(iterator.hasNext()) //utilizing same level order printer that I created before
        {
            if(counter < treeSize)
            {
                result = result + iterator.next() + ", ";
                counter++;
            }
            else
            {
                result = result + iterator.next() +  "]";
            }
        }
        System.out.println(result);
        
        //Print out the height of the degenerate tree
        System.out.println("The height of the degenerate tree is: " +degenTree1.getHeight());
        System.out.println();
        
        //Balance the tree
        System.out.print("The balanced tree (level order): ");
        degenTree1 = degenTree1.balanceTree();
        
        //Print out the balanced tree
        iterator = degenTree1.iteratorLevelOrder();
        result = "[";
        treeSize = degenTree1.size();
        counter = 1;
        while(iterator.hasNext())
        {
            if(counter < treeSize)
            {
                result = result + iterator.next() + ", ";
                counter++;
            }
            else
            {
                result = result + iterator.next() +  "]";
            }
        }
        System.out.println(result);
        
        //Print out the height of the balanced tree
        System.out.println("The height of the balanced tree is: " + degenTree1.getHeight());
    
        //Create the second case of degenerate tree, this time a right sided degenerate
        System.out.println("\n\n|--- Create the second degenerate tree by adding elements to a tree with root of 1. ---|\nElements added in order: \"2,3,4,5,6,7\"\n");
        LinkedBinarySearchTree degenTree2 = new LinkedBinarySearchTree<>(1);
        degenTree2.addElement(2);
        degenTree2.addElement(3);
        degenTree2.addElement(4);
        degenTree2.addElement(5);
        degenTree2.addElement(6);
        degenTree2.addElement(7);
    
        //Print out the trees
        System.out.println("The degenerate tree (in order) : " + degenTree2);
        System.out.print("The degenerate tree (level order) : ");
        iterator = degenTree2.iteratorLevelOrder();
        result = "[";
        treeSize = degenTree2.size();
        counter = 1;
        while(iterator.hasNext())
        {
            if(counter < treeSize)
            {
                result = result + iterator.next() + ", ";
                counter++;
            }
            else
            {
                result = result + iterator.next() +  "]";
            }
        }
        System.out.println(result);
        
        //Print out the height of the degenerate tree
        System.out.println("The height of the degenerate tree is: " +degenTree2.getHeight());
        System.out.println();
    
        //Balance the tree
        System.out.print("The balanced tree (level order): ");
        degenTree2 = degenTree2.balanceTree();
        
        //Print out the balanced tree
        iterator = degenTree2.iteratorLevelOrder();
        result = "[";
        treeSize = degenTree2.size();
        counter = 1;
        while(iterator.hasNext())
        {
            if(counter < treeSize)
            {
                result = result + iterator.next() + ", ";
                counter++;
            }
            else
            {
                result = result + iterator.next() +  "]";
            }
        }
        System.out.println(result);
        
        //Print out the height of the balanced tree
        System.out.println("The height of the balanced tree is: " + degenTree2.getHeight());
        
        //New section of question 2 where we insert into a balanced tree and rebalance
        System.out.println("\n\n|--- Insert into a balanced tree and create a degenerate tree. ---| \nBalance the degenerate tree and output the height before and after.\n");
        LinkedBinarySearchTree balancedTreeTest = new LinkedBinarySearchTree<>(4);
        balancedTreeTest.addElement(2);
        balancedTreeTest.addElement(6);
        balancedTreeTest.addElement(1);
        balancedTreeTest.addElement(3);
        balancedTreeTest.addElement(5);
        balancedTreeTest.addElement(7);
        
        //Print the balanced tree
        System.out.print("The balanced tree (level order): ");
        iterator = balancedTreeTest.iteratorLevelOrder();
        result = "[";
        treeSize = balancedTreeTest.size();
        counter = 1;
        while(iterator.hasNext())
        {
            if(counter < treeSize)
            {
                result = result + iterator.next() + ", ";
                counter++;
            }
            else
            {
                result = result + iterator.next() +  "]";
            }
        }
        System.out.println(result);
        
        //Print the height of the balanced tree
        System.out.println("The height of the balanced tree is: " + balancedTreeTest.getHeight());
        
        //Create the degenerate tree
        System.out.println("Inserting the following elements to create a degenerate tree (8,9,10,11,12,13,14,15,16)");
        balancedTreeTest.addElement(8);
        balancedTreeTest.addElement(9);
        balancedTreeTest.addElement(10);
        balancedTreeTest.addElement(11);
        balancedTreeTest.addElement(12);
        balancedTreeTest.addElement(13);
        balancedTreeTest.addElement(14);
        balancedTreeTest.addElement(15);
        
        //Print out the degenerate tree
        System.out.print("The degenerate tree (level order): ");
        iterator = balancedTreeTest.iteratorLevelOrder();
        result = "[";
        treeSize = balancedTreeTest.size();
        counter = 1;
        while(iterator.hasNext())
        {
            if(counter < treeSize)
            {
                result = result + iterator.next() + ", ";
                counter++;
            }
            else
            {
                result = result + iterator.next() +  "]";
            }
        }
        System.out.println(result);
        
        //Print out the height of the degenerate tree
        System.out.println("The height of the degenerate tree is: " + balancedTreeTest.getHeight());
        System.out.println();
        
        //Balance the newly created degenerate tree to produce a balanced tree again
        System.out.println("Balance the newly created degenerate tree. ");
        balancedTreeTest = balancedTreeTest.balanceTree();
        System.out.print("The newly balanced tree (level order): ");
        iterator = balancedTreeTest.iteratorLevelOrder();
        result = "[";
        treeSize = balancedTreeTest.size();
        counter = 1;
        while(iterator.hasNext())
        {
            if(counter < treeSize)
            {
                result = result + iterator.next() + ", ";
                counter++;
            }
            else
            {
                result = result + iterator.next() +  "]";
            }
        }
        System.out.println(result);
        
        //Print out the height of the newly balanced tree
        System.out.println("The height of the newly balanced tree is: " + balancedTreeTest.getHeight());
        
        System.out.println("||--------------------------------------------------------------------------------------------------||\n\n");
        
    }
    
}