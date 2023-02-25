package jsjf;
import jsjf.exceptions.EmptyCollectionException;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

public interface DequeADT<T>
{
    //modelled after QueueADT
    
    /**
     *   A double-ended queue, or deque (pronounced like “deck”), is introduced in Section 14.8.
     *   With a deque you can add, remove, or view elements from both ends of the queue.
     *   Rather than use the Deque interface supplied by the Java API,
     *   design your own DequeADT interface (patterned after QueueADT).
     *   Then, implement a deque using links.
     */
    
    
    /**
     * Adds an element to the front of the deque along with appropriate references next and previous
     * @param element
     */
    public void addFront(T element);
    
    /**
     * Adds an element to the end of the deque along with appropriate references for next and previous
     * @param element
     */
    public void addRear(T element);
    
    /**
     * Removes the first element from the deque and returns the result
     * @return
     * @throws EmptyCollectionException
     */
    public T removeFront();
    
    /**
     * Removes the last element from the deque and returns the result
     * @return
     * @throws EmptyCollectionException
     */
    public T removeRear();
    
    /**
     * Returns the value of the first element in the deque
     * @return
     * @throws EmptyCollectionException
     */
    public T viewFirst();
    
    /**
     * Returns the value of the last element in the deque
     * @return
     * @throws EmptyCollectionException
     */
    public T viewLast();
    
    /**
     * Returns true if this stack contains no elements.
     * @return true if the stack is empty
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    public int size();
    
    /**
     * Returns a string representation of this stack.
     * @return a string representation of the stack
     */
    public String toString();
    
}
