package jsjf;
import jsjf.exceptions.*;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class LinkedStack<T> implements StackADT<T>
{
    
    /**
     *   There is a data structure called a drop-out stack that behaves like a stack in
     *   every respect except that the size is fixed. If the stack size is n, the bottom
     *   element is lost when the n+1 element is pushed onto the top. Implement a drop-out
     *   stack using links, by modifying the LinkedStack code that you completed
     *   as part of Lab 3.
     *
     *   The driver should create a stack of moderate size (say five) and push on that many
     *   String elements consisting of people’s names (include your own).
     *   Output the contents of the stack and the results of the size() and peek() operations.
     *   Push two more elements onto the stack, outputting the contents and the results of
     *   the size() and peek() operations for each. (Adapted from PP 13.8.)
     */

    private int elements;
    private LinearNode<T> top;
    
    /**
     * Creates an empty stack.
     */
    public LinkedStack()
    {
        elements = 0;
        top = null;
    }
    
    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     */
    public void push(T element)
    {
        LinearNode<T> temp = new LinearNode<T>(element);
        
        temp.setNext(top);
        top = temp;
        elements++;
    }
    
    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        
        T result = top.getElement();
        top = top.getNext();
        elements--;
        
        return result;
    }
    
    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        if(isEmpty())
            throw new EmptyCollectionException("stack");
        
        T result = top.getElement();
        
        return result;
    }
    
    /**
     * Returns true if this stack is empty and false otherwise.
     * @return true if stack is empty
     */
    public boolean isEmpty()
    {
        return (elements == 0);
    }
    
    /**
     * Returns the number of elements in this stack.
     * @return number of elements in the stack
     */
    public int size()
    {
        return elements;  // temp
    }
    
    /**
     * Returns a string representation of this stack.
     * @return string representation of the stack
     */
    public String toString()
    {
        String result = "";
        LinearNode<T> scan = top;
    
    
    
        while(scan != null)
        {
            if(scan == top)
            {
                result = result+ scan.getElement() + " <- TOP "+ "\n"  ;
                scan = scan.getNext();
            }
            else if(scan.getNext() == null)
            {
                result =  result+ scan.getElement() + " <- BOTTOM"   ;
                scan = scan.getNext();
            
            }
            else
            {
                result = result+ scan.getElement() + "\n"  ;
                scan = scan.getNext();
            }
        
        }
    
        if(top == null)
        {
            System.out.println("The stack is empty.");
        }
    
        return result;
    }
    
}
