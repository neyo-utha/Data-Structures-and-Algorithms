package jsjf;
import java.util.ArrayList;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class StackUsingArrayList<T> implements StackADT<T>
{
    private ArrayList<T> list;
    private int top; //points to the top of the stack
    private int size;//can also do top+1 but for readability sake I am using size as a seperate variable
    
    /**
     * Constructor that creates the empty Array List
     */
    public StackUsingArrayList()
    {
        list = new ArrayList<T>();
        top = -1; //setting top to -1 allows it to point to the actual top of the stack
        size = 0;//size is 0 initially
    }
    
    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed onto the stack
     */
    public void push(T element)
    {
        list.add(element);
        top++; //when an element is added top now points to the first element and size is increased
        size++;
    }

    /**
     * Removes and returns the top element from this stack.
     * @return the element removed from the stack
     */
    public T pop()
    {
        T element;
        
        if(list.isEmpty()) //checks for the case where list is empty and returns null
        {
            System.out.println("The stack is empty.");
            return null;
        }
        else
        {
            element = list.remove(top);
            top--;
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
        return list.get(top);
    } //since top points to the top of the stack we can return it

    /**
     * Returns true if this stack contains no elements.
     * @return true if the stack is empty
     */
    public boolean isEmpty()
    {
        return(size == 0);
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
        String result = "[ ";//custom toString made by myself to present the list in a uniform way easy to read
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
