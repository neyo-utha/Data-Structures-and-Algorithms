package jsjf;
import java.util.ArrayList;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class QueueUsingArrayList<T> implements QueueADT<T>
{
    private ArrayList<T> list;
    private int front;//create variables for essential parameters of Queue size, front, rear
    private int rear;
    private int size;
    
    /**
     * Constructor creates an empty Queue/ArrayList
     */
    public QueueUsingArrayList()
    {
        list = new ArrayList<T>();
        front = rear = size = 0;//initially all parameters are the same 0
    }
    
    /**
     * Adds one element to the rear of this queue.
     * @param element  the element to be added to the rear of the queue
     */
    public void enqueue(T element)
    {
        if(front==rear)//empty queue, add to front
        {
            list.add(front,element);
            rear++;
        }
        else//not empty then add to rear
        {
            list.add(rear,element);
            rear++;
        }
        size++; //increase the size after any addition
    }

    /**
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of the queue
     */
    public T dequeue()
    {
        if(list.isEmpty())//checks if empty
        {
            System.out.println("The queue is empty.");
            return null;
        }
        else
        {
            T element = list.get(front);//standard way to store and reference
            front++;
            size--;
            return element;
        }
    }

    /**
     * Returns without removing the element at the front of this queue.
     * @return the first element in the queue
     */
    public T first()
    {
        return list.get(front);
    }
    
    /**
     * Returns without removing the element at the end of the queue
     */
    public T last()
    {
        return list.get(rear-1);
    } //the same thing applies for the array list, rear points to the element after the last element in the list so we have to do rear-1 to get the last element otherwise there will be an out of bounds error

    /**
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty
     */
    public boolean isEmpty()
    {
        return(size == 0);
    }

    /**
     * Returns the number of elements in this queue.
     * @return the integer representation of the size of the queue
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns a string representation of this queue.
     * @return the string representation of the queue
     */
    public String toString()
    {
        String result = "[ ";//custom toString made by myself to present the list in a uniform way easy to read
        for(int i = front; i < rear ; i++)
        {
            if (i < rear - 1)
                result = result + list.get(i) + ", ";
            else
                result = result + list.get(i) + " ]";
        
        }
    
        if(front == rear)
            result = result + "empty ]";
    
        return result;
    }
}
