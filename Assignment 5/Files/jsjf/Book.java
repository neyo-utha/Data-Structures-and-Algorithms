package jsjf;

/**
 * @author Neyoshaan Uthayakumaran TRU : T00665922
 */

/**
 * Creates book objects with a name and ISBN which can be used in a hash table
 */
public class Book
{
    private String key; //stores the ISBN number
    private String name; //stores the name of the book
    private boolean status;//status in the hash table, true means a valid entry, false means it has been deleted
    
    /**
     * Constructor that initializes the values of the book object
     * @param bookName name of the book
     * @param ISBNkey the 10 digit ISBN number which is the key
     */
    public Book(String bookName, String ISBNkey)
    {
        name = bookName;
        key = ISBNkey;
        this.status = true;//start off the book as a valid entry can choose to delete later if need be
    }
    
    /**
     * Returns the name of this book object
     * @return the name of this book
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the ISBN key of this book object
     * @return the ISBN key of this book
     */
    public String getKey()
    {
        return key;
    }
    
    /**
     * Sets the status of this book object, true meaning present in the hash table and false meaning removed
     * @param update true or false depending on present or removed
     */
    public void setStatus(boolean update)
    {
        status = update;
    }
    
    /**
     * Returns the status of this book object.
     * If false this book has been removed from the hash table
     * @return boolean status of book, false meaning removed
     */
    public boolean getStatus()
    {
        return status;
    }
    
    /**
     * Returns a string representation of this book objects name and ISBN key.
     * @return ISBN key and name
     */
    public String toString()
    {
        return this.getKey() + ": " + this.getName();
    }
}
