This is a Java assignment which demonstrates Bubble sort, Optimized bubble sort, Shell sort, Merge sort, Quick sort, Insertion sort and Selection sort. The demonstration file included shows how to input test cases. Test cases also demonstrate the respective run time of each algorithm implemented.



The Shell sort (invented by Dr. Donald Shell) is a variation of the bubble/exchange sort. Instead of comparing adjacent values, the Shell sort adapts the partitioning concept from the binary search to determine a “gap” across which values are compared before any swap takes place. In the first pass, the gap is half the size of the array. For each subsequent pass, the gap size is cut in half. For the final pass(es), the gap size is 1, so it would be the same as a bubble sort. The passes continue until no swaps occur.

Below is the same set of values as per the bubble sort example in Chapter 18 (p. 667), showing the first pass of the Shell sort:

![image](https://user-images.githubusercontent.com/117210225/220446123-becb0167-c96d-4f05-9ed3-225a4b46cdbc.png)

The pseudo-code for the Shell sort is as follows:

![image](https://user-images.githubusercontent.com/117210225/220446162-bcf383ea-9218-4052-8570-b490156998ca.png)


Modify Sorting.java to include a shellSort method that implements the above algorithm. Include an output of the array any time a swap occurs to demonstrate that your code works correctly. For the driver, create an Integer array using an initializer list to reproduce the above example and two additional random sets of 10 and 20 integers.

The bubble sort algorithm shown in Chapter 18 is less efficient than it could be. If a pass is made through the list without exchanging any elements, the list is sorted and there is no reason to continue. Create a copy of the bubbleSort method called bubbleSort2 that implements this algorithm so that is will stop as soon as it recognizes that the list is sorted. Do not use a break statement! Include outputs of the array for both sorts for each pass through the array so you can demonstrate that the code is working correctly. The driver should test both methods with a random set of 10 integers and an already sorted set of 10 integers.

Hint: You have to introduce a swapflag that is set true if a swap occurs on a given pass. Replace the outer “for loop” with a “while loop” that tests the swapflag and takes care of “index counting” within the loop.

Hint: Remember that arrays are passed by reference in Java. Use Arrays.copyOf() or a similar method to test each sort method on the exact same data content in separate arrays.

Modify the shellSort, bubbleSort, and bubbleSort2 methods from above by adding code to each to tally the total number of comparisons made between the elements being sorted (i.e., just the compareTo() calls; ignore relational operators between indexes). Also tally and report the number of swaps that occur. Determine and report the total execution time of each algorithm. Comment out the outputs of each swap or pass for this final step. Execute each of these sort algorithms against the same list, recording information for the total number of comparisons and total execution time. The driver should construct lists of size 10, 100, and 1000—both in random and already in sorted order. Use the Integer wrapper class for the array type.

Use a spreadsheet to present the test cases you have prepared, along with the comparisons, swaps, and execution time. Describe how the data obtained relates to the theoretical discussion of algorithm efficiency presented in the chapter.
