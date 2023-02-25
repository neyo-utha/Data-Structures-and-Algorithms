package jsjf;
import jsjf.exceptions.*;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class LinkedDeque<T> implements DequeADT<T>
{
    //modelled after LinkedQueue
    
    /**
     *   Hint: Start with the LinkedQueue code that you completed as part of Lab 4.
     *   Also, each node will need both a next and a previous reference.
     *
     *   The driver should create a deque of moderate size (say five or six).
     *   It should repetitively add elements to the front, and then the rear.
     *   For each addition, output the contents of the deque as well as the size,
     *   front element, and last element. Then, repetitively remove elements from the deque.
     *   For each removal, output the contents of the deque as well as the size, front element,
     *   and last element. (Adapted from PP 14.6 and PP 14.7.)
     */
    
    private int elements; //number of elements in the deque
    private DequeNode<T> front, rear;
    
    /**
     * Constructor which makes an empty deque
     */
    public LinkedDeque()
    {
        elements = 0;
        front = null;
        rear = null;
    }
    
    /**
     * Adds an element to the front of the deque along with appropriate references next and previous
     * @param element
     */
    public void addFront(T element)
    {
        DequeNode<T> temp = new DequeNode<>(element);
        
        if(isEmpty())
            front = rear = temp; //if the list is empty set the front and rear to temp
        else
        {
            front.setPrevious(temp); //set the current front nodes previous to temp since it will be ahead of current front
            temp.setNext(front); //set temps next reference to the current front since it will be after temp
            temp.setPrevious(null);//unneccessary for visualization purposes showing temp is at the beginning pointing to null previously
        }
        
        front = temp; //front is now temp and the current front is replaced with temp
        elements++;
    }
    
    /**
     * Adds an element to the end of the deque along with appropriate references for next and previous
     * @param element
     */
    public void addRear(T element)
    {
        DequeNode<T> temp = new DequeNode<>(element);
        
        if(isEmpty())
            rear = front = temp;
        else
        {
            rear.setNext(temp); //temp will be coming after the rear element so set rear's next to temp
            temp.setPrevious(rear); //temps previous should be rear
            temp.setNext(null);//unneccessary for visualization purposes showing temp is at the end pointing to null next
        }
        
        rear = temp; //replace current rear with temp which is new rear
        elements++;
    }
    
    /**
     * Removes the first element from the deque and returns the result
     * @return
     * @throws EmptyCollectionException
     */
    public T removeFront() throws EmptyCollectionException
    {
        if(isEmpty())
            throw new EmptyCollectionException("Deque");
        
        T result = front.getElement(); //gets the element at the front of the deque
        front = front.getNext(); //sets front to the next element in the deque
        front.setPrevious(null);//changes the next elements previous reference to null since it's now at the beginning
        elements--; //we lost an element so decrease elements counter
        
        if(isEmpty())
            front = rear = null; //in the case that the deque becomes empty set the front and rear to null again
        
        return result;
    }
    
    /**
     * Removes the final element in the deque and returns the result
     * @return
     * @throws EmptyCollectionException
     */
    public T removeRear() throws EmptyCollectionException
    {
        
        DequeNode<T> temp = new DequeNode<>();
        
        if(isEmpty()) //when elements is 0
            throw new EmptyCollectionException("Deque");
        
        if(elements > 1) //when elements is more than 1 we have to adjust the previous reference
        {
            temp = rear; // store the last element in a temp node object
            rear = rear.getPrevious(); //set the new rear to the previous element
            rear.setNext(null); // set the new rears next reference to null indicating that it is the end
            
        }
        else //when elements is 1
        {
            temp = rear = front; //if theres only one entry in the list then temp is just front or rear
        }
        
        T result = temp.getElement(); //store the result of temp.getElement in result, no need for temp anymore
        elements--; //decrease the elements because we are going to remove this element
        
        if(isEmpty())
            front = rear = null; //if the value of elements was 1 then this case will happen where elements goes to 0
        
        return result;
    }
    
    /**
     * Returns the number of elements in the deque
     * @return
     */
    public int size()
    {
        return elements;
    }
    
    /**
     * Returns the value of the first element in the deque
     * @return
     * @throws EmptyCollectionException
     */
    public T viewFirst() throws EmptyCollectionException
    {
        if(isEmpty())
            throw new EmptyCollectionException("Deque");
        
        T result = front.getElement(); //simply gets value of front
        
        return result;
    }
    
    /**
     * Returns the value of the last element in the deque
     * @return
     * @throws EmptyCollectionException
     */
    public T viewLast() throws EmptyCollectionException
    {
        if(isEmpty())
            throw new EmptyCollectionException("Deque");
    
        if(elements <=1)
            rear = front; //in case we get an outlier let's just ensure that when list is 1 or smaller rear is always correct
        
        T result = rear.getElement();
        
        return result;
    }
    
    /**
     * Returns a boolean based on if the deque is empty or not
     * @return
     */
    public boolean isEmpty()
    {
        return(elements == 0);
    }
    
    /**
     * Takes in the input as the output of isEmpty and prints out a relevant statement
     * @param isEmpty
     */
    public static void emptyStatus(boolean isEmpty)
    {
        if(isEmpty)
        {
            System.out.println("The deque is empty");
        }
        else
        {
            System.out.println("The deque is not empty");
        }
    }
    
    /**
     * Prints out the contents of the deque in a simple manner for the viewer
     * @return
     */
    public String toString()
    {
        String queueValues = "[ ";
        DequeNode<T> scan = front;
        
        
        while(scan != null)
        {
            //while the next link isn't null provide a comma
            if(scan.getNext() != null)
            {
                queueValues = queueValues + (scan.getElement()).toString() + ", ";
                scan = scan.getNext();
            }
            else//when the next link is null or at the end of the list there's no comma needed.
            {
                queueValues = queueValues + (scan.getElement()).toString();
                scan = scan.getNext();
            }
            
        }
        
        //At the end of the linked list when scan is null end the string with a closing brace
        if(scan == null)
        {
            queueValues = queueValues + " ]";
        }
        
        return queueValues;
    }
    
    /**
     * tests the functionality of the next references and can also be used for toString
     */
    public String printForwards()
    {
        String output = "[ ";
        DequeNode<T> start = front;
    
        while(start != null)
        {
            //while the next link isn't null provide a comma
            if(start.getNext() != null)
            {
                output = output + (start.getElement()).toString() + ", ";
                start = start.getNext();
            }
            else//when the next link is null or at the end of the list there's no comma needed.
            {
                output = output + (start.getElement()).toString();
                start = start.getNext();
            }
        
        }
    
        //At the end of the linked list when scan is null end the string with a closing brace
        if(start == null)
        {
            output = output + " ]";
        }
    
        return output;
        
    }
    
    /**
     * tests the functionality of the previous references
     */
    public String printBackwards()
    {
        String output = "[ ";
        DequeNode<T> end = rear;
    
        while(end != null)
        {
            //while the next link isn't null provide a comma
            if(end.getPrevious() != null)
            {
                output = output + (end.getElement()).toString() + ", ";
                end = end.getPrevious();
            }
            else//when the next link is null or at the end of the list there's no comma needed.
            {
                output = output + (end.getElement()).toString();
                end = end.getPrevious();
            }
        
        }
    
        //At the end of the linked list when scan is null end the string with a closing brace
        if(end == null)
        {
            output = output + " ]";
        }
    
        return output;
    }
    
    /**
     * Helps visualize the nodes to see if previous and next are working properly
     */
    public void printNodes()
    {
        DequeNode<T> scan = front;
        
        while(scan != null)
        {
            System.out.println("Node address: " + scan + " || previous: " + scan.getPrevious() +  ", element: " + scan.getElement() + ", next: " + scan.getNext() );
            scan = scan.getNext();
        }
        
    }
    
}
