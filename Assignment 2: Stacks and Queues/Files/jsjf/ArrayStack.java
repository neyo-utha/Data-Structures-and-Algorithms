package jsjf;
import jsjf.exceptions.*;
import java.util.Arrays;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class ArrayStack<T> implements StackADT<T>
{
    /**
     *   The ArrayStack implementation in Chapter 12 uses the top variable to point to the next
     *   array position available in the stack i.e. above the actual top of the stack.
     *   Modify the array implementation such that stack[top] is the actual top of the stack.
     *   Do not introduce any other counter variables.
     *   Make sure your driver demonstrates any method that you modify
     *
     *   Hint: Start with the ArrayStack code that you completed as part of Lab 3.
     *   Consider starting top at a value other than 0 and altering where top may
     *   be incremented or decremented.
     */

    private final static int DEFAULT_CAPACITY = 100;
    
    private int top;
    private T[] stack;
    
    
    /**
     * Base constructor of the class
     */
    public ArrayStack()
    {
        top = -1; //initialize top to -1 so that when top is incremented it alligns with the actual top of the stack
        stack = (T[])(new Object[DEFAULT_CAPACITY]); //create a new stack with the default capactiy and assign it to our stack reference variable
    }
    
    /**
     * Creates an empty stack using the specified capacity.
     * Constructor with parameter/overloaded constructor
     * @param initialCapacity the initial size of the array
     */
    public ArrayStack(int initialCapacity)
    {
        top = -1; //initiailize top to -1 here as well goes without saying
        stack = (T[])(new Object[initialCapacity]);
    }
    
    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the array if necessary.
     * @param element generic element to be pushed onto stack
     */
    public void push(T element)
    {
        if (size() == stack.length) //when size equals stack.length the stack is full then expand capacity
            expandCapacity();
    
        top++; //increment the top pointer to where it has to be first then add the element, since it starts at the current top
        stack[top] = element; //since top is what we're using to indicate where element goes, incrementing top first makes sense
        
    }
    
    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        
        
        T result = stack[top]; //since top now points to the current top element no need to decrement first, simply reference
        stack[top] = null; //next remove the top element after you have the return variable result
        top--; //finally we decrement top so that it still points to the current top variable after pop()
        
        return result; //return the result we got from top at the beginning
    }
    
    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        
        return stack[top]; //This can be set to stack[top] instead of stack[top - 1] since top now points to the top of stack
    }
    
    /**
     * Returns true if this stack is empty and false otherwise.
     * @return true if this stack is empty
     */
    public boolean isEmpty()
    {
        return (top == -1); //The stack will only be empty if top is -1 now, so make this the new condition
    }
    
    /**
     * Takes in the output of isEmpty() and prints the result to screen
     * @param isEmpty
     */
    public static void emptyStatus(boolean isEmpty)
    {
        System.out.println("Testing isEmpty(): ");
        if(isEmpty)
        {
            System.out.println("The stack is empty");
        }
        else
        {
            System.out.println("The stack is not empty");
        }
    }
    
    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    public int size()
    {
        return top+1; //Since top now points to the top of the array and array indexes are one less (ex: 0,1,2,3 : top is 3 size would be 3+1 though) add one to top to get size
    }
    
    /**
     * Returns a string representation of this stack.
     * @return a string representation of the stack
     */
    public String toString() //custom toString I made to print out the elements in a way I like it
    {
        String result = "[ "; //start with opening brace
        
        
        for (int scan=0; scan <= top; scan++)
        {//Have to iterate until top since top will be the final value
            if (scan < top)
            {
                result = result + stack[scan] + ", "; //while we have not reached the end, add commas
            }
            else //when scan = top
            {
                result = result + stack[scan] + " <--TOP ] "; // at the final value or top then indicate TOP and add closing braces
            }
        }
        
        if(this.isEmpty())
        {
            result = result + "empty ]"; //if the stack is empty then close with [ empty ]
        }
        
        return result;
    }
    
    /**
     * Creates a new array to store the contents of this stack with
     * twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }
    
}
