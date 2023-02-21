package jsjf;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class LinearNode<T>
{
    private LinearNode<T> next; //essentially the next LinearNode object
    private T element;
    
    /**
     * Creates an empty node.
     */
    public LinearNode()
    {
        next = null;
        element = null;
    }
    
    /**
     * Creates a node storing the specified element.
     * @param elem element to be stored
     */
    public LinearNode(T elem)
    {
        element = elem;
        next = null;
        
    }
    
    //Getters
    
    /**
     * Returns the element stored in this node.
     * @return element stored at the node
     */
    public T getElement()
    {
        return element;
    }
    
    /**
     * Returns the node that follows this one.
     * @return reference to next node
     */
    public LinearNode<T> getNext()
    {
        return next;
    }
    
    //Setters
    
    /**
     * Sets the element stored in this node.
     * @param elem element to be stored at this node
     */
    public void setElement(T elem)
    {
        element = elem;
    }
    
    /**
     * Sets the node that follows this one.
     * @param node node to follow this one
     */
    public void setNext(LinearNode<T> node)
    {
        next = node;
    }
}
