import jsjf.QueueUsingArrayList;
import jsjf.QueueUsingLinkedList;
import jsjf.StackUsingArrayList;
import jsjf.StackUsingLinkedList;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */


public class Assignment3
{
    public static void main(String[] args)
    {
        StackUsingLinkedList<Integer> list1 = new StackUsingLinkedList<>();
        
        System.out.println("\n||--------------Implementing a stack using a Linked List--------------||" + "\n");
        
        //push elements onto the stack
        System.out.println("push(5): ");
        list1.push(5);
        System.out.println(list1.toString());
        System.out.println("peek: " + list1.peek() + ", size: " + list1.size());
        System.out.println();
        
        System.out.println("push(4): ");
        list1.push(4);
        System.out.println(list1.toString());
        System.out.println("peek: " + list1.peek() + ", size: " + list1.size());
        System.out.println();
        
        System.out.println("push(3): ");
        list1.push(3);
        System.out.println(list1.toString());
        System.out.println("peek: " + list1.peek() + ", size: " + list1.size());
        System.out.println();
        
        System.out.println("push(2): ");
        list1.push(2);
        System.out.println(list1.toString());
        System.out.println("peek: " + list1.peek() + ", size: " + list1.size());
        System.out.println();
        
        System.out.println("push(1): ");
        list1.push(1);
        System.out.println(list1.toString());
        System.out.println("peek: " + list1.peek() + ", size: " + list1.size());
        System.out.println();
        
        //check if empty
        System.out.println("isEmpty: " + list1.isEmpty());
        System.out.println();
        
        //pop elements off the stack
        System.out.println("pop(): " + list1.pop());
        System.out.println(list1.toString());
        System.out.println("peek: " + list1.peek() + ", size: " + list1.size());
        System.out.println();
    
        System.out.println("pop(): " + list1.pop());
        System.out.println(list1.toString());
        System.out.println("peek: " + list1.peek() + ", size: " + list1.size());
        System.out.println();
    
        System.out.println("pop(): " + list1.pop());
        System.out.println(list1.toString());
        System.out.println("peek: " + list1.peek() + ", size: " + list1.size());
        System.out.println();
    
        System.out.println("pop(): " + list1.pop());
        System.out.println(list1.toString());
        System.out.println("peek: " + list1.peek() + ", size: " + list1.size());
        System.out.println();
    
        System.out.println("pop(): " + list1.pop());
        System.out.println(list1.toString());
        System.out.println();
    
        System.out.println("pop(): " + list1.pop());
        System.out.println(list1.toString());
        System.out.println();
        
        //check if empty once again when the stack is actually empty
        System.out.println("isEmpty: " + list1.isEmpty());
        System.out.println();
        
        System.out.println("\n||--------------Implementing a stack using an Array List--------------||" + "\n");
        StackUsingArrayList<Integer> list2 = new StackUsingArrayList<>();
    
        //push elements onto the stack
        System.out.println("push(5): ");
        list2.push(5);
        System.out.println(list2.toString());
        System.out.println("peek: " + list2.peek() + ", size: " + list2.size());
        System.out.println();
    
        System.out.println("push(4): ");
        list2.push(4);
        System.out.println(list2.toString());
        System.out.println("peek: " + list2.peek() + ", size: " + list2.size());
        System.out.println();
    
        System.out.println("push(3): ");
        list2.push(3);
        System.out.println(list2.toString());
        System.out.println("peek: " + list2.peek() + ", size: " + list2.size());
        System.out.println();
    
        System.out.println("push(2): ");
        list2.push(2);
        System.out.println(list2.toString());
        System.out.println("peek: " + list2.peek() + ", size: " + list2.size());
        System.out.println();
    
        System.out.println("push(1): ");
        list2.push(1);
        System.out.println(list2.toString());
        System.out.println("peek: " + list2.peek() + ", size: " + list2.size());
        System.out.println();
    
        //check if empty when stack has elements
        System.out.println("isEmpty: " + list2.isEmpty());
        System.out.println();
    
        //pop elements off stack
        System.out.println("pop(): " + list2.pop());
        System.out.println(list2.toString());
        System.out.println("peek: " + list2.peek() + ", size: " + list2.size());
        System.out.println();
    
        System.out.println("pop(): " + list2.pop());
        System.out.println(list2.toString());
        System.out.println("peek: " + list2.peek() + ", size: " + list2.size());
        System.out.println();
    
        System.out.println("pop(): " + list2.pop());
        System.out.println(list2.toString());
        System.out.println("peek: " + list2.peek() + ", size: " + list2.size());
        System.out.println();
    
        System.out.println("pop(): " + list2.pop());
        System.out.println(list2.toString());
        System.out.println("peek: " + list2.peek() + ", size: " + list2.size());
        System.out.println();
    
        System.out.println("pop(): " + list2.pop());
        System.out.println(list2.toString());
        System.out.println();
    
        System.out.println("pop(): " + list2.pop());
        System.out.println(list2.toString());
        System.out.println();
    
        //check if empty when the stack is actually empty
        System.out.println("isEmpty: " + list2.isEmpty());
        System.out.println();
        
        
        System.out.println("\n||--------------Implementing a queue using a Linked List--------------||" + "\n");
        QueueUsingLinkedList<Integer> list3 = new QueueUsingLinkedList<>();
    
        //enqueue elements onto the queue
        System.out.println("enqueue(1): ");
        list3.enqueue(1);
        System.out.println(list3.toString());
        System.out.println("front: " + list3.first() + ", rear: " + list3.last() + ", size: " + list3.size());
        System.out.println();
    
        System.out.println("enqueue(2): ");
        list3.enqueue(2);
        System.out.println(list3.toString());
        System.out.println("front: " + list3.first() + ", rear: " + list3.last() + ", size: " + list3.size());
        System.out.println();
    
        System.out.println("enqueue(3): ");
        list3.enqueue(3);
        System.out.println(list3.toString());
        System.out.println("front: " + list3.first() + ", rear: " + list3.last() + ", size: " + list3.size());
        System.out.println();
    
        System.out.println("enqueue(4): ");
        list3.enqueue(4);
        System.out.println(list3.toString());
        System.out.println("front: " + list3.first() + ", rear: " + list3.last() + ", size: " + list3.size());
        System.out.println();
    
        System.out.println("enqueue(5): ");
        list3.enqueue(5);
        System.out.println(list3.toString());
        System.out.println("front: " + list3.first() + ", rear: " + list3.last() + ", size: " + list3.size());
        System.out.println();
    
        //check isEmpty with elements in queue
        System.out.println("isEmpty: " + list3.isEmpty());
        System.out.println();
    
        //dequeue elements off the queue
        System.out.println("dequeue(): " + list3.dequeue());
        System.out.println(list3.toString());
        System.out.println("front: " + list3.first() + ", rear: " + list3.last() + ", size: " + list3.size());
        System.out.println();
    
        System.out.println("dequeue(): " + list3.dequeue());
        System.out.println(list3.toString());
        System.out.println("front: " + list3.first() + ", rear: " + list3.last() + ", size: " + list3.size());
        System.out.println();
    
        System.out.println("dequeue(): " + list3.dequeue());
        System.out.println(list3.toString());
        System.out.println("front: " + list3.first() + ", rear: " + list3.last() + ", size: " + list3.size());
        System.out.println();
    
        System.out.println("dequeue(): " + list3.dequeue());
        System.out.println(list3.toString());
        System.out.println("front: " + list3.first() + ", rear: " + list3.last() + ", size: " + list3.size());
        System.out.println();
    
        System.out.println("dequeue(): " + list3.dequeue());
        System.out.println(list3.toString());
        System.out.println( "size: " + list3.size());
        System.out.println();
    
        //check isEmpty when theres no elements in the queue
        System.out.println("isEmpty: " + list3.isEmpty());
        System.out.println();
        
        System.out.println("\n||--------------Implementing a queue using an Array List--------------||" + "\n");
        QueueUsingArrayList<Integer> list4 = new QueueUsingArrayList<Integer>();
    
        //enqueue elements onto the queue
        System.out.println("enqueue(1): ");
        list4.enqueue(1);
        System.out.println(list4.toString());
        System.out.println("front: " + list4.first() + ", rear: " + list4.last() + ", size: " + list4.size());
        System.out.println();
    
        System.out.println("enqueue(2): ");
        list4.enqueue(2);
        System.out.println(list4.toString());
        System.out.println("front: " + list4.first() + ", rear: " + list4.last() + ", size: " + list4.size());
        System.out.println();
    
        System.out.println("enqueue(3): ");
        list4.enqueue(3);
        System.out.println(list4.toString());
        System.out.println("front: " + list4.first() + ", rear: " + list4.last() + ", size: " + list4.size());
        System.out.println();
    
        System.out.println("enqueue(4): ");
        list4.enqueue(4);
        System.out.println(list4.toString());
        System.out.println("front: " + list4.first() + ", rear: " + list4.last() + ", size: " + list4.size());
        System.out.println();
    
        System.out.println("enqueue(5): ");
        list4.enqueue(5);
        System.out.println(list4.toString());
        System.out.println("front: " + list4.first() + ", rear: " + list4.last() + ", size: " + list4.size());
        System.out.println();
    
        //check if queue is emtpy with elements in queue
        System.out.println("isEmpty: " + list4.isEmpty());
        System.out.println();
    
        System.out.println("dequeue(): " + list4.dequeue());
        System.out.println(list4.toString());
        System.out.println("front: " + list4.first() + ", rear: " + list4.last() + ", size: " + list4.size());
        System.out.println();
    
        System.out.println("dequeue(): " + list4.dequeue());
        System.out.println(list4.toString());
        System.out.println("front: " + list4.first() + ", rear: " + list4.last() + ", size: " + list4.size());
        System.out.println();
    
        System.out.println("dequeue(): " + list4.dequeue());
        System.out.println(list4.toString());
        System.out.println("front: " + list4.first() + ", rear: " + list4.last() + ", size: " + list4.size());
        System.out.println();
    
        System.out.println("dequeue(): " + list4.dequeue());
        System.out.println(list4.toString());
        System.out.println("front: " + list4.first() + ", rear: " + list4.last() + ", size: " + list4.size());
        System.out.println();
    
        System.out.println("dequeue(): " + list4.dequeue());
        System.out.println(list4.toString());
        System.out.println("size: " + list4.size());
        System.out.println();
    
        //check if queue is empty with no elements in queue
        System.out.println("isEmpty: " + list4.isEmpty());
        System.out.println();
        System.out.println();
        
        System.out.println("||--------------End of Program!--------------||");
        System.out.println("\nThank you for viewing, have a nice day!");
        
    }
}
