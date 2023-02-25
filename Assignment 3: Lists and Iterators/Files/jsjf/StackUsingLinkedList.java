package jsjf;
import java.util.LinkedList;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */


public class StackUsingLinkedList<T> implements StackADT<T>
{
    private LinkedList<T> list;
    private int size; //size of the list
    
    /**
     * Constructor which creates an empty stack
     */
    public StackUsingLinkedList()
    {
        list = new LinkedList<T>();
        size = 0;
    }
    
    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed onto the stack
     */
    public void push(T element)
    {
        list.add(element);
        size++;
    }
    
    /**
     * Removes and returns the top element from this stack.
     * @return the element removed from the stack
     */
    public T pop()
    {
        T element;
        if(list.isEmpty()) //checks if the list is empty
        {
            System.out.println("The stack is empty.");
            return null;
        }
        else
        {
            element = list.removeLast();//stores removed element and returns it
            size--;
        }
        return element;
    }
    
    /**
     * Returns without removing the top element of this stack.
     * @return the element on top of the stack
     */
    public T peek()
    {
        return list.getLast(); //since this stack is implemented as the last element being the top we can use the getLast function from LinkedList
    }
    
    /**
     * Returns true if this stack contains no elements.
     * @return true if the stack is empty
     */
    public boolean isEmpty()
    {
        return(size == 0); //check if list is empty by using size, pretty standard by now
    }
    
    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Returns a string representation of this stack.
     * @return a string representation of the stack
     */
    public String toString()
    {
        String result = "[ "; //custom toString made by myself to present the list in a uniform way easy to read
        for(int i =0; i < size ; i++)
        {
            if (i < size - 1)
                result = result + list.get(i) + ", ";
            else
                result = result + list.get(i) + " <- TOP ]";
            
        }
        
        if(list.isEmpty())
            result = result + "empty ]";
        
        return result;
    }
}
