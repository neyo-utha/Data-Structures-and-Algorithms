package jsjf;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class DequeNode<T>
{
    DequeNode<T> next;
    DequeNode<T> previous;
    private T element;
    
    /**
     * Constructor that makes a new node
     */
    public DequeNode()
    {
        next = null;
        previous = null;
        element = null;
    }
    
    /**
     * Constructor that makes a new node with specified element
     * @param elem
     */
    public DequeNode(T elem)
    {
        next = null;
        previous = null;
        element = elem;
    }
    
    //getters
    
    /**
     * Get the next node
     * @return
     */
    public DequeNode<T> getNext()
    {
        return next;
    }
    
    /**
     * Get the previous node
     * @return
     */
    public DequeNode<T> getPrevious()
    {
        return previous;
    }
    
    /**
     * Get the element of the node
     * @return
     */
    public T getElement()
    {
        return element;
    }
    
    //setters
    
    /**
     * Set the next node
     * @param node
     */
    public void setNext(DequeNode<T> node)
    {
        next = node;
    }
    
    /**
     * Set the previous node
     * @param node
     */
    public void setPrevious(DequeNode<T> node)
    {
        previous = node;
    }
    
    /**
     * Set this element
     * @param elem
     */
    public void setElement(T elem)
    {
        element = elem;
    }
}
