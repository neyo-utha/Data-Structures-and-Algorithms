package jsjf;
import java.util.LinkedList;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class QueueUsingLinkedList<T> implements QueueADT<T>
{
    private LinkedList<T> list;
    int size;//create variables for essential parameters of Queue size, front, rear
    int front;
    int rear;
    
    /**
     * Constructor creates the empty Queue/LinkedList
     */
    public QueueUsingLinkedList()
    {
        list = new LinkedList<T>();
        size = front = rear = 0; //initially all parameters are the same 0
    }
    
    /**
     * Adds one element to the rear of this queue.
     * @param element  the element to be added to the rear of the queue
     */
    public void enqueue(T element)
    {
        if(front == rear) //this is the case of the empty queue
        {
            list.add(front,element);//notice here that rear always points immediately behind the elements in the list so we can add an element behind the list at any point by doing list.add(rear,element)
            rear++;
        }
        else //queue thats not empty, add to rear not front
        {
            list.add(rear,element);
            rear++;
        }
        size++; //in both cases increase size of course
    }

    /**
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of the queue
     */
    public T dequeue()
    {
        if (list.isEmpty())//check if empty
        {
            System.out.println("The queue is empty.");
            return null;
        }
        else //if not empty then dequeue the element at the front
        {
            T element = list.get(front);
            front++; //make front the next element and decrease size
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
            return list.get(front); //front is always pointing to front so no decrement or increment needed here
    }
    
    /**
     * Returns without removing the element at the end of the queue
     * @return
     */
    public T last()
    {
            return list.get(rear-1);
    } //rear actually points to the element after the last element of the list so if we want the last element we must do rear-1 to get to one element ahead which is the end otherwise there will be an error

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
