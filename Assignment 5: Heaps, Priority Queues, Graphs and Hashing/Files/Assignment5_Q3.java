import jsjf.HashTable;
import jsjf.Book;

/**
 * @author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class Assignment5_Q3
{
    
    public static void main(String[] args)
    {
        System.out.println("\n||--------------------------------------------------------------------------------------------------||\n");
    
        System.out.println("Question 3, Implement a dynamically resizable hash table to store book names and 10-digit ISBN numbers. " +
                "\nUse an initial table size of 11 and a load factor of 0.70. " +
                "\nFor your testing, make sure you deliberately code ISBNs so that collisions will occur. " +
                "\nDemonstrate how the same set of values can result in different hashes, depending on the order in which they are added. " +
                "\nTest adding items until the hash table must be resized. " +
                "\nTest finding and removing items from the hash table.");
    
        //Create a new hash table with size of 11 and load factor 0.7
        System.out.println("\n\nCreate a new hash table of size 11 with a load factor of 0.7.");
        HashTable hashTable = new HashTable(11,0.7);
        
        //Test adding books to the hash table
        System.out.println("Add 3 books, which have deliberate ISBNs so as to fall in index 0, 1 and 2. ");
        hashTable.newBook("Book1" , "5645135121");
        hashTable.newBook("Book2" , "3780423276");
        hashTable.newBook("Book3" , "9058096717");
        System.out.print(hashTable);
        System.out.println("Using the last three digits of each book's ISBN via extraction and dividing by the size of the hash table gives the indices: " +
                "\n121 % 11 = 0 , 276 % 11 = 1 , 717 % 11 = 2 ");
        System.out.println("The indices are as expected and this demonstrates the extraction method using division with the last three digits of the ISBN number.");
        
        //Test collisions using deliberately coded ISBNs
        System.out.println("\n\n\nAdd 3 more books, and use deliberate ISBNs which place all 3 books at index 0 so as to cause collisions.");
        hashTable.newBook("Book4", "6479184011");
        hashTable.newBook("Book5", "7210934022");
        hashTable.newBook("Book6", "1598238033");
        System.out.print(hashTable);
        System.out.println("As you can see above, the books are hashed using linear probing and enter the next available index as expected. ");
        
        //Demonstrate unique hash table based on order of entry of items
        System.out.println("\n\n\nDemonstrate how the same set of values can result in different hashes, depending on the order in which they are added." +
                "\nCreate a new hash table. Add the same books with the same ISBN's in a different order: reverse order from book6 to book1.");
        HashTable hashTable2 = new HashTable(11,0.7);
        hashTable2.newBook("Book6", "1598238033");
        hashTable2.newBook("Book5", "7210934022");
        hashTable2.newBook("Book4", "6479184011");
        hashTable2.newBook("Book3", "9058096717");
        hashTable2.newBook("Book2", "3780423276");
        hashTable2.newBook("Book1", "5645135121");
        System.out.print(hashTable2);
        System.out.println("As you can see above, the books are now stored in reverse order based on the order they were added." +
                "\nThis is despite deliberately coding some ISBNs to place at index 0, 1 and 2 and others specifically at index 0. " +
                "\nThe result is a completely different hash based on the same ISBN numbers added in a different order. ");
        
        //Adding entries until the hash table is resized and rehashed
        System.out.println("\n\n\nTest adding items until the hash table is resized. " +
                "\nRevisiting the first hash table with 6 entries, add 2 more entries until the number of entries is 8," +
                "\nwhereupon the hash table will be resized and expanded with rehashing occuring based on the new size.");
        System.out.println("\nThe first hash table: ");
        System.out.print(hashTable);
        System.out.println("\nAdd two more books.");
        hashTable.newBook("Book7" , "4163926916");
        hashTable.newBook("Book8" , "1527623837");
        System.out.print(hashTable);
        System.out.println("Notice that the indices of the Books have changed as they have been rehashed. " +
                "\nfor example: Book1 is now in index 11 because 121 % 22 = 11." +
                "\npreviously Book1 would have been intially placed in index 0: 121 % 11 = 0.");
        
        //Test finding items in the table
        System.out.println("\n\n\nTest finding items from the hash table. \nFind book1 and book8 using their ISBN number and get their index numbers");
        System.out.println("findBook(): " + hashTable.findBook("5645135121") + ", index: " + hashTable.findIndex("5645135121"));
        System.out.println("findBook(): " + hashTable.findBook("1527623837") + ", index: " + hashTable.findIndex("1527623837"));
        System.out.println("Add a new item called Book9 and try finding the new item.");
        hashTable.newBook("Book9" , "9527623219");
        System.out.print(hashTable);
        System.out.println("findBook(): " + hashTable.findBook("9527623219") + ", index: " + hashTable.findIndex("9527623219"));
        
        //Testing removing items from the table
        System.out.println("\n\n\nTest removing items from the hash table. \nRemove the even number books: Book2, Book4, Book6 and Book8 using their ISBN numbers");
        hashTable.removeBook("3780423276");
        hashTable.removeBook("6479184011");
        hashTable.removeBook("1598238033");
        hashTable.removeBook("1527623837");
        System.out.print(hashTable);
        System.out.println("As you can see only the odd numbered books remain demonstrating the remove method is functional.");
        
        
    }
}