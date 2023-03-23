package jsjf;
import java.util.Arrays;

/**
 * @author Neyoshaan Uthayakumaran TRU : T00665922
 */

/**
 * HeapSort sorts a given array of Comparable objects using a heap.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class HeapSort<T>
{
    protected int comparisonCount;
    private int total1;
    private int total2;
    
    /**
     * Constructor, creates heap
     */
    public HeapSort()
    {
        comparisonCount = 0;
    }
    
    /**
     * Sorts the specified array using a Heap
     *
     * @param data the data to be added to the heapsort
     */
    public void heapSort(T[] data)
    {
        ArrayHeap<T> heap = new ArrayHeap<T>();
        
        // copy the array into a heap
        for (int i = 0; i < data.length; i++)
            heap.addElement(data[i]);
        
        //output the number of operations for add
        int addOperations = heap.numberOfOperations();
        System.out.println("Comparisons made during add operation: " + addOperations);
        System.out.print("Heap representation of the array: ");
        System.out.println(heap);
        
        // place the sorted elements back into the array
        int count = 0;
        while (!(heap.isEmpty()))
        {
            data[count] = heap.removeMin();
            count++;
        }
        
        //output the number of operations for remove
        int removeOperations = heap.numberOfOperations();
        System.out.println("Comparisons made during removal operation: " + removeOperations);
        //Display the sorted array
        System.out.println("The final sorted array: " + Arrays.toString(data));
        //Stores the total comparisons to test efficiency
        total1 = addOperations + removeOperations;
        
    }
    
    /**
     * Takes in an array and builds a heap in place more efficiently by starting in the first non-leaf node
     * comparing to the its children and swap if necessary. Then work backwards in the array until reaching the root
     * @param data
     */
    public void efficientHeapSort(T[] data)
    {
        int numElements = data.length;//number of elements in the heap would be the length of the array
        int height = (int) (Math.log(numElements)/(Math.log(2)));//The height of any binary tree is given by log(n)/log(2) or log base 2 of n where n is the number of elements in the tree
        int leaves = (int) (numElements - (Math.pow(2,height) - 1)); //The number of leaves in a binary tree
        
        //First non-leaf node
        int n = 0;
        if (numElements > 3)
        {
            n = (int) (  ( Math.pow(2,height-1) - 1 ) + ( ((leaves-1)/2) )  );
        }
        
        //After finding the first non-leaf node, compare to children and swap if neccessary, repeat until the root node
        while (n >= 0)
        {
            data = recursiveSwap(data, n);
            n--;
        }
        
        //The array created by recursively swapping is stored as a new array heap
        ArrayHeap<T> heap = new ArrayHeap<T>(data);
        
        //Display statuses
        int addOperations = numberOfComparisons();
        System.out.println("Comparisons made during add operation: " + addOperations);//Displays comparisons for add
        System.out.print("Heap representation of the array: ");//Display heap
        System.out.println(heap);
        
        // remove elements from the heap back into the original array, like in the original heap sort
        int count = 0;
        while (!(heap.isEmpty()))
        {
            data[count] = heap.removeMin();
            count++;
        }
        
        //Display statuses
        int removeOperations = heap.numberOfOperations();
        System.out.println("Comparisons made during removal operation: " + removeOperations);//Displays comparisons for remove
        System.out.println("The final sorted array: " + Arrays.toString(data)); //The final result of the sorted array
        //Stores the total comparisons to test efficiency
        total2 = addOperations + removeOperations;
        
    }
   
    /**
     * Returns an array after recursively swapping nodes with the child node
     * @param data
     * @param n
     * @return
     */
    public T[] recursiveSwap(T[] data, int n)
    {
        boolean swapflag = true; //swagflag indicates whether or not a swap occured
        
        while (swapflag == true) //if a swap took place then enter the while loop
        {
            swapflag = false;//set the swapflag to false so there isn't an infinite loop if there are no swaps
            
            T currentNode = data[n]; //represents the current node being looked at
            T left = null; //both left and right children are intially null
            T right = null;
            int swapIndicator = 0; //indicates whether a left or right swap occured
            
            try //In an array implementation the left child is given by 2n+1 and the right is given by 2n+2 for any node n
            {
                left = data[2*n + 1];
                right = data[2*n + 2];
            } catch (Exception e){} //if there isn't a left or right child then catch
            
            if (right == null & left == null) //when right and left both equal null it means there are no more nodes which means this is a leaf node
            {
                break; // we are at a leaf node so exit the while loop
            }
            
            if (right != null)// right child exists
            {
                if ((((Comparable) currentNode).compareTo(right) > 0)) //If the right child is smaller than the current node
                {
                    comparisonCount++; //increment comparisons
                    data[n] = right; //swap the current node at data[n] with the right child at data[2n+2]
                    data[2*n + 2] = currentNode;
                    currentNode = data[n];//make sure the current node is updated
                    right = data[2*n + 2];//make sure the right child is updated
                    swapflag = true;//since a swap happened update swapflag
                    swapIndicator++;//increment swap count to indicate a right swap
                }
            }
            
            if (left != null)// left child exists
            {
                if ((((Comparable) currentNode).compareTo(left) > 0))// If the left child is smaller than the current node
                {
                    comparisonCount++; //increment comparisons
                    data[n] = left; //swap the current node at data[n] with the left child at data[2n+1]
                    data[2*n + 1] = currentNode;
                    currentNode = data[n];//update the currentNode
                    left = data[2*n + 1];//update the left node
                    swapflag = true;// swap occured so update swap flag
                    swapIndicator--; //decrement swap count to indicate a left swap
                }
            }
            
            // n for the next iteration is decided by these conditional statements
            if (swapIndicator <= 0 && swapflag == true)//when a swap with the left child occurs swapIndicator is decremented to -1, if no swap occurs then swapIndicator will be 0. In both of these cases set n to the left child of the current node and reiterate
            {
                n = 2*n + 1;
            }
            else if ((swapIndicator == 1 && swapflag == true))//when a swap with the right child occurs swapIndicator will be 1, in this case set n to the right child of the current node and reiterate
            {
                n = 2*n + 2;
            }
        }
        
        return data;// once the while loop exits we can return the updated array
        
    }
    
    /**
     * Returns the number of comparisons made
     * @return
     */
    public int numberOfComparisons()
    {
        return comparisonCount;
    }
    
    /**
     * Returns the total comparisons for the given heap sort method
     * @return original heap sort comparisons
     */
    public int getTotal1()
    {
        return total1;
    }
    
    /**
     * Returns the total comparisons for the improved heap sort method
     * @return improved heap sort comparisons
     */
    public int getTotal2()
    {
        return total2;
    }
}