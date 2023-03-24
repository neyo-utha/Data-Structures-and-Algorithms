# Heaps, Priority Queues, Graphs and Hashing

In this assignment the student was required to create an algorithm that will build a heap in place using an inputted array, create an algorithm which will generate a graph which is displayed using an adjacency matrix and finally create a dynamically resizable hash table which will store 10 digit ISBN numbers of books in an imitation library book information storage system. The hash table must use the extraction method with division of the last three ISBN digits to create the hash address, account for collisions and use linear probing to address the collisions, dynamically resize itself upon exceeding the limit factor or capacity of the hash table and finally be able to add or remove items to the table. 

Detailed Requirements Description: 

1. As described in Section 21.5 of your textbook, it is possible to make the heap sort algorithm more efficient by writing a method that will build a heap in place using the array to be sorted. Implement such a method and rewrite the heap sort algorithm to make use of it. Show test cases for various inputs, including sorted and unsorted inputs.

2. Complete the implementation of Graph.java using an adjacency matrix that was presented in this chapter. Show test cases for all implemented methods, being sure to test all edge cases where possible.

3. Implement a dynamically resizable hash table to store book names and 10-digit ISBN numbers. Use an initial table size of 11 and a load factor of 0.70. Use the extraction method with division using the last three digits of the ISBN as the first hash address. For a collision, use linear probing. For your testing, make sure you deliberately code ISBNs so that collisions will occur, and demonstrate how the same set of values can result in different hashes, depending on the order in which they are added. Test adding items until the hash table must be resized. Test finding and removing items from the hash table.
