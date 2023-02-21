package jsjf;

/**
 * @author Neyoshaan Uthayakumaran TRU : T00665922
 */

/**
 * This hash table takes in book objects and stores them in the hash table with an index
 * which is hashed by extraction (last 3 digits) using the 10 digit ISBN number associated with the book object.
 * Collisions in this hash table are handled using linear probing.
 * If the hash table approaches a threshold capacity it is expanded to double the size and entries are rehashed.
 * @param <T> for this implementation we use book objects from the book class
 */
public class HashTable<T>
{
    private Book[] hashTable; // an array of book objects which represents the hash table
    private int numberOfBooks; // the number of books in the table
    private double loadfactor; // the percentage the hash table can fill up before expansion
    private int size; // the size of the hash table also the length used for location calculation
    private int storageLimit; // once the current storage surpasses this limit increase capacity, this is calculated using load factor
    
    /**
     * Constructor that sets up the hash table and the appropriate variables
     * @param size the intial size of your hash table
     * @param lf   the load factor you wish to use for the hash table, typically 0.7
     */
    public HashTable(int size, double lf)
    {
        if (lf <= 0 || Double.isNaN(lf)) //ensure the load factor is valid
            throw new IllegalArgumentException("Load factor cannot be " + lf);
        if (size < 0)                    //ensure the size is valid
            throw new IllegalArgumentException("Initial size cannot be " + size);
        
        this.size = size; //initialize all variables
        loadfactor = lf;
        storageLimit = (int) (this.size * loadfactor); // storage limit is a percentage of the full size used to expand
        hashTable = new Book[size]; //create the hash table array which will hold book objects
    }
    
    /**
     * Returns the index value where the book will be placed in the hash table based on it's ISBN value
     * @param ISBNkey the ISBN value assigned to the book
     * @param sizeOfHashTable the size of the table which you initialize when you create a new hash table 'size'
     * @return index value
     */
    private int indexValue(String ISBNkey, int sizeOfHashTable)
    {
        int indexValue = Integer.parseInt(ISBNkey.substring(7, 10));//extraction is used here as the hashing function
        return indexValue % sizeOfHashTable;
    }
    
    /**
     * Adds a new book to the hash table
     * @param bookName name of the book you are trying to enter
     * @param ISBNkey the 10 digit ISBN key
     */
    public void newBook( String bookName, String ISBNkey)
    {
        if ((numberOfBooks + 1) > storageLimit) //if we exceed the storageLimit when adding one more book, expand the capacity of the hash table
            expandCapacity();
        
        
        int index = indexValue(ISBNkey, size); //use the input ISBN to calculate the index where this book goes
        
        if (hashTable[index] == null || hashTable[index].getStatus() == false)//if the current position at the index value is empty or has been recently deleted
        {
            hashTable[index] = new Book(bookName, ISBNkey);
        }
        else//if the current space is occupied there will be a collision
        {
            System.out.print("Storing " + bookName + " has caused a collision at index " + (index));
            while (hashTable[index] != null) //iterate through the hash table and check for an empty spot
            {
                if (hashTable[index].getStatus() == false)
                {
                    break;
                }
                index = (index + 1) % size;
            }
            
            hashTable[index] = new Book(bookName, ISBNkey); //when an empty spot is found set the book to that index
            System.out.println(", " + bookName + " will be placed at index " + (index) + ".");
        }
        
        numberOfBooks++;//since a new book was added increment the number of books
    }
    
    /**
     * Returns the index value of a book provided it's ISBN number
     * @param ISBNkey the 10 digit ISBN number associated with the book you are looking for
     * @return the int index of the book you are looking for, or -1 if not found
     */
    private int getIndex(String ISBNkey)
    {
        int index = indexValue(ISBNkey, size);
        
        if(hashTable[index] == null) //In the case that the value at the calculated index is null return -1
        {
            return -1; //not found
        }
        else if(hashTable[index].getKey().equals(ISBNkey)) //when the value at this index equals the searched for ISBN
        {
            if(hashTable[index].getStatus() == false) //In the case the entry has been deleted
            {
                return -1; //not found
            }
            else //In the case the entry is still present or the status is true
            {
                return index; //return the index of the ISBN or book you're looking for
            }
        }
        else //In the case a collision happened and the index has changed for this ISBN or book
        {
            int start = index; //choose a starting point which is index
            index = (index+1)% size; //increase index by 1 so as to iterate
            
            while((hashTable[index].getKey() != null) || (index != start))//while there is a value for key or index does not equal starting point iterate
            {
                
                if(hashTable[index].getKey().equals(ISBNkey)) //check to see if the ISBN at this index equals the search ISBN
                {
                    if (hashTable[index].getStatus() == true) //if this book has not been removed
                    {
                        return index; //return the current index
                    }
                    else
                    {
                        return -1; //not found
                    }
                }
                index = (index+1)% size;//increases index by 1 each time until reaching start once again
                
            }
        }
        
        return -1;//not found
    }
    
    /**
     * Returns the exact book object that represents the book you are looking for given the ISBN number
     * @param ISBNkey the 10 digit ISBN number of the book you're looking for
     * @return a book object representing the book you're looking for
     */
    public Book findBook(String ISBNkey)
    {
        int index = getIndex(ISBNkey); //get the index where this book should be
        if(index == -1) // This means the book is not in the hashtable as we indicated in the getIndex method that -1 means not in the table
        {
            System.out.println("The book is not in the table.");
            return null;
        }
        else //The book is in the table and return it at the index calculated
        {
            return (hashTable[index]);
        }
    }
    
    /**
     * Returns the index of the book associate with the inputted ISBN key using the private method getIndex
     * @param ISBNkey
     * @return index value of the book
     */
    public int findIndex(String ISBNkey) //essentially a public getter method for the getIndex method
    {
        return getIndex(ISBNkey);
    }
    
    /**
     * Removes the book associated with the ISBN number inputed into this method from the hash table
     * @param ISBNkey the 10 digit ISBN number associated with the book
     */
    public void removeBook(String ISBNkey)
    {
        int index = getIndex(ISBNkey);// get the index where this book should be
        if(index == -1) //if index is -1 book is either not in the hash table or already been deleted
        {
            System.out.println("Deletion invalid, the book is not in the table.");
        }
        else //The book is in the hash table, set it's status to false effectively removing it
        {
            hashTable[index].setStatus(false);
            numberOfBooks--; //decrement number of books since a book was removed
        }
    }
    
    /**
     * Expands the size of the hash table once the load factor capacity of the hash table is about to be exceeded
     */
    private void expandCapacity()
    {
        System.out.println("Hash table has exceeded it's capacity, expand and rehash.");
        
        HashTable temp_ExpandedHashTable = new HashTable(size()*2, loadfactor); //create a temporary new hash table with double the size of the previous table
        
        for(int index = 0 ; index < size() ; index++) //transfer all the values in the current hash table over to the new one
        {
            if(hashTable[index] != null)
            {
                //This automatically rehashes as the values in the old hash table are entered into the new hash table via the newBook method which will calculate a new index for each of the old entries
                temp_ExpandedHashTable.newBook(hashTable[index].getName(), hashTable[index].getKey());
            }
        }
        
        //replace the old hash table, size value and threshold value for this old hash table object with the new hash table
        this.hashTable = temp_ExpandedHashTable.hashTable;
        this.size = temp_ExpandedHashTable.size;
        this.storageLimit = temp_ExpandedHashTable.storageLimit;
    }
    
    /**
     * Returns the size of the hash table
     * @return int size of the hash table
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Returns the number of active books which are present in this hash table
     * @return int number of books
     */
    public int getNumberOfBooks()
    {
        return numberOfBooks;
    }
    
    /**
     * Returns the state of the hash table if it is empty or not
     * @return true or false depending on the hash table being empty or not
     */
    public boolean isEmpty()
    {
        return(numberOfBooks == 0);
    }
    
    /**
     * Returns a string representation of this hash table
     * @return String representation of hash table
     */
    public String toString()
    {
        String result = "";
        
        result += "|-----------------------------------------|\n";
        
        for(int i = 0; i < size() ; i++) //Used to display the current index
        {
            if(i < 10) //when i is 0-9 this is single digits so increase the spaces after the index so that text lines up when i increase to 10 and beyond
            {
                result += ("  " + (i) + "  | ");// TWO SPACES BEFORE "--| "
                if(hashTable[i] != null) //if there is a value at this hash table index
                {
                    if(hashTable[i].getStatus() == true)//and if this value is not removed
                    {
                        result += hashTable[i].toString(); //output the value by storing it in result
                    }
                }
                result += "\n";
                
            }
            else //when i is greater than 10 can use one space, this is used just so that the ' | " line up in the representation
            {
                result += ("  " + (i) + " | ");//ONE SPACE BEFORE "-| " this is only difference.
                if(hashTable[i] != null)
                {
                    if(hashTable[i].getStatus() == true)//same as before
                    {
                        result += hashTable[i].toString();
                    }
                }
                result += "\n";
                
            }
            
        }
        result += "|-----------------------------------------|\n";
        return result;
    }
    
    
    
}

