package jsjf;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class DropOutStack<T> implements StackADT<T>
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
    
    private final int n = 5; //This is the maximum size we want to create
    private LinearNode<T> secondLastElement;
    private LinearNode<T> iterationEndCondition;
    
    /**
     * Creates the stack with no elements and top pointing to null
     */
    public DropOutStack()
    {
        elements = 0;
        top = null;
    }
    
    /**
     * Adds an element to the top of the stack
     */
    public void push(T element)
    {
        LinearNode<T> temp = new LinearNode<T>(element);
        //check if the number of elements in the stack is less than max size
        if(elements < n) //if less than set this element next reference to current top and then make this the top
        {
            temp.setNext(top);
            top = temp;
            elements++;
        }
        else if(elements >= n && n!= 1)//In the event that the stack is full
        {
            secondLastElement = top; //at the end of the while loop coming up we want this to be at the second last element
            //when secondLastElement.getNext().getNext() is null we are at the second last element
            //secondLastElement.getNext() would be the last element
            
            while(secondLastElement.getNext().getNext() != null)
            {
                secondLastElement = secondLastElement.getNext(); //iterates along with current until previous is the second last entry
               
            }
    
            secondLastElement.setNext(null); //once previous is the second last element in the full stack take out the next element or the last entry by setting previous.next to null
            elements--; //decrease the number of elements because we lost the last entry
            push(element); //push the element again now since #ofelements < n and it will just be added to the top of the stack now
        }
        else //when n is 1
        {
            top.setElement(element);
        }
    }
    
    /**
     * Removes the element at the top of the stack and returns a reference to it
     */
    public T pop()
    {
        if(isEmpty())
            return null;
        
        T result = top.getElement();
        top = top.getNext();
        elements--;
        
        return result;
    }
    
    /**
     * Returns a reference to the top of the stack
     */
    public T peek()
    {
        if(isEmpty())
            return null;
        
        T result = top.getElement();
        
        return result;
    }
    
    /**
     * Returns a boolean value indicating if the stack is empty or not
     * @return
     */
    public boolean isEmpty()
    {
        return(elements == 0);
    }
    
    /**
     * Returns the number of elements in this stack
     * @return
     */
    public int size()
    {
        return elements;
    }
    
    /**
     * Prints out the contents of the Dropout Stack to the user interface
     * @return
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
