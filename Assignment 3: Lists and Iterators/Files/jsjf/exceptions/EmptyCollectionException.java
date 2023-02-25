package jsjf.exceptions;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

/**
 * Represents the situation in which a collection is empty.
 *
 *
 */
public class EmptyCollectionException extends RuntimeException
{
    
    /**
     * Sets up this exception with an appropriate message.
     * @param collection the name of the collection
     */
    public EmptyCollectionException(String collection)
    {
        super("The " + collection + " is empty.");
    }
    
    
}
