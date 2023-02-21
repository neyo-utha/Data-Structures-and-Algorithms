import jsjf.HeapSort;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class Assignment5_Q1
{
    
    public static void main(String[] args)
    {
        System.out.println("\n||--------------------------------------------------------------------------------------------------||\n");
    
        //Test cases for random arrays
        System.out.println("Question 1 part one, test more efficient heap sort method using random unsorted arrays.\nI recommend turning off the \"soft-wrapping\" feature in your console if possible for these test cases.");
        
        Integer[] randomArray10 = randomArray(10);
        Integer[] randomArray100 = randomArray(100);
        Integer[] randomArray1000 = randomArray(1000);
        
        //Random array of 10 integers
        System.out.print("\n\nRandom array of 10 integers: ");
        System.out.println(Arrays.toString(randomArray10));
        HeapSort<Integer> heap1 = new HeapSort<Integer>();
        System.out.println("\n|---Running the default heap sort---|");
        heap1.heapSort(Arrays.copyOf(randomArray10,randomArray10.length));
        System.out.println("Total Comparisons: " + heap1.getTotal1());
        System.out.println("\n|---Running the efficient heap sort---|");
        heap1.efficientHeapSort(Arrays.copyOf(randomArray10,randomArray10.length));
        System.out.println("Total Comparisons: " + heap1.getTotal2());
        System.out.println();
        //Random array of 100 integers
        System.out.print("\n\nRandom array of 100 integers: ");
        System.out.println(Arrays.toString(randomArray100));
        HeapSort<Integer> heap2 = new HeapSort<Integer>();
        System.out.println("\n|---Running the default heap sort---|");
        heap2.heapSort(Arrays.copyOf(randomArray100,randomArray100.length));
        System.out.println("Total Comparisons: " + heap2.getTotal1());
        System.out.println("\n|---Running the efficient heap sort---|");
        heap2.efficientHeapSort(Arrays.copyOf(randomArray100,randomArray100.length));
        System.out.println("Total Comparisons: " + heap2.getTotal2());
        System.out.println();
        //Random array of 1000 integers
        System.out.print("\n\nRandom array of 1000 integers: ");
        System.out.println(Arrays.toString(randomArray1000));
        HeapSort<Integer> heap3 = new HeapSort<Integer>();
        System.out.println("\n|---Running the default heap sort---|");
        heap3.heapSort(Arrays.copyOf(randomArray1000,randomArray1000.length));
        System.out.println("Total Comparisons: " + heap3.getTotal1());
        System.out.println("\n|---Running the efficient heap sort---|");
        heap3.efficientHeapSort(Arrays.copyOf(randomArray1000,randomArray1000.length));
        System.out.println("Total Comparisons: " + heap3.getTotal2());
        System.out.println();
        
        
        //Testing using sorted arrays
        System.out.println("\n\nQuestion 1 part two, test more efficient heap sort method using sorted arrays.");
        
        Integer[] sortedArray10 = ascendingArray(10);
        Integer[] sortedArray100 = ascendingArray(100);
        Integer[] sortedDescendingArray10 = descendingSortedArray(10);
        Integer[] sortedDescendingArray100 = descendingSortedArray(100);
    
        //Ascending arrays
        System.out.print("\n\nSorted ascending array of 10 integers: ");
        System.out.println(Arrays.toString(sortedArray10));
        HeapSort<Integer> heap4 = new HeapSort<Integer>();
        System.out.println("\n|---Running the default heap sort---|");
        heap4.heapSort(Arrays.copyOf(sortedArray10,sortedArray10.length));
        System.out.println("Total Comparisons: " + heap4.getTotal1());
        System.out.println("\n|---Running the efficient heap sort---|");
        heap4.efficientHeapSort(Arrays.copyOf(sortedArray10,sortedArray10.length));
        System.out.println("Total Comparisons: " + heap4.getTotal2());
        System.out.println();
    
        System.out.print("\n\nSorted ascending array of 100 integers: ");
        System.out.println(Arrays.toString(sortedArray100));
        HeapSort<Integer> heap5 = new HeapSort<Integer>();
        System.out.println("\n|---Running the default heap sort---|");
        heap5.heapSort(Arrays.copyOf(sortedArray100,sortedArray100.length));
        System.out.println("Total Comparisons: " + heap5.getTotal1());
        System.out.println("\n|---Running the efficient heap sort---|");
        heap5.efficientHeapSort(Arrays.copyOf(sortedArray100,sortedArray100.length));
        System.out.println("Total Comparisons: " + heap5.getTotal2());
        System.out.println();
    
        //Descending arrays
        System.out.print("\n\nSorted descending array of 10 integers: ");
        System.out.println(Arrays.toString(sortedDescendingArray10));
        HeapSort<Integer> heap6 = new HeapSort<Integer>();
        System.out.println("\n|---Running the default heap sort---|");
        heap6.heapSort(Arrays.copyOf(sortedDescendingArray10,sortedDescendingArray10.length));
        System.out.println("Total Comparisons: " + heap6.getTotal1());
        System.out.println("\n|---Running the efficient heap sort---|");
        heap6.efficientHeapSort(Arrays.copyOf(sortedDescendingArray10,sortedDescendingArray10.length));
        System.out.println("Total Comparisons: " + heap6.getTotal2());
        System.out.println();
    
        System.out.print("\n\nSorted descending array of 100 integers: ");
        System.out.println(Arrays.toString(sortedDescendingArray100));
        HeapSort<Integer> heap7 = new HeapSort<Integer>();
        System.out.println("\n|---Running the default heap sort---|");
        heap7.heapSort(Arrays.copyOf(sortedDescendingArray100,sortedDescendingArray100.length));
        System.out.println("Total Comparisons: " + heap7.getTotal1());
        System.out.println("\n|---Running the efficient heap sort---|");
        heap7.efficientHeapSort(Arrays.copyOf(sortedDescendingArray100,sortedDescendingArray100.length));
        System.out.println("Total Comparisons: " + heap7.getTotal2());
        System.out.println();
    
        System.out.println("\n\nConclusions:");
        System.out.println("In the random tests, the total number of operations/comparisons done was seen to decrease significantly as larger sizes of\n" +
                "arrays were inputed into the efficient heap method, or as the size of n, where n is the size of the array, increased.\n" +
                "In the sorted arrays there was no noticeable difference in the total operations and this was expected because the input was sorted.\n" +
                "In the descending arrays there was a noticeable difference in total operations as n (array size) increased displaying efficiency of the new heap sort.\n" +
                "We can therefore conclude that at larger values of n (array size), the efficient heap method is indeed more efficient for\n" +
                "random inputs and sorted arrays in descending order. For sorted arrays there was no difference. Also, at lower values of n there was not\n" +
                "a significant difference indicating that efficiency scales with n as stated previously.");
    
    
        System.out.println("\n||--------------------------------------------------------------------------------------------------||\n");
    
    }
    
    /**
     * Returns an array of set length containing random Integer values
     * @param length
     * @return
     */
    private static Integer[] randomArray(int length)
    {
        Integer[] array = new Integer[length];//create new Integer array and set to desired length
        Random random = new Random();//create instance of the Random class for our values
        
        for(int i=0; i<length; i++)//iterate through the length of the array
        {
            Integer integer = random.nextInt(length);//generate random number
            array[i] = integer;
        }
        
        return array;//return array of random Integers
    }
    
    /**
     * Returns an ascending sorted array that ranges from 1 to the length of the array
     * @param length
     * @return
     */
    private static Integer[] ascendingArray(int length)
    {
        Integer[] array = new Integer[length];//create new Integer array and set to desired length
        
        for(int i=0; i<length; i++)//add the numbers 1 through length to the array
        {
            array[i] = i+1;
        }
        
        return array;//return the ascending sorted array
    }
    
    /**
     * Returns a descending sorted array that ranges from 1 to the length of the array
     * @param length
     * @return
     */
    private static Integer[] descendingSortedArray(int length)
    {
        Integer[] array = new Integer[length];//create new Integer array and set to desired length
        
        for(int i=0; i<length; i++)//add the numbers from length to 1 to the array
        {
            array[i] = length-i;
        }
        
        return array;//return the descending sorted array
    }
}