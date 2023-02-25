import jsjf.ArrayStack;
import jsjf.DropOutStack;
import jsjf.LinkedDeque;
import java.util.Scanner;

/**
 * author Neyoshaan Uthayakumaran TRU : T00665922
 */

public class Assignment2
{
    
    public static void main(String[] args)
    {
        /**
         * QUESTION 1
         */
        System.out.println("\n|-----------------QUESTION 1-----------------|\n");
        int temp = 0;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
       
        //pushing entries onto the stack
        System.out.println("push(): 1");
        arrayStack.push(1);
        System.out.println(arrayStack.toString());
        
        System.out.println("push(): 2");
        arrayStack.push(2);
        System.out.println(arrayStack.toString());
        
        System.out.println("push(): 3");
        arrayStack.push(3);
        System.out.println(arrayStack.toString());
        
        System.out.println("push(): 4");
        arrayStack.push(4);
        System.out.println(arrayStack.toString());
        
        System.out.println("push(): 5");
        arrayStack.push(5);
        System.out.println(arrayStack.toString());
        
        //check isEmpty() functionality
        System.out.println();
        ArrayStack.emptyStatus(arrayStack.isEmpty());
        System.out.println(arrayStack.toString());
        
        System.out.print("The size is: ");
        System.out.println(arrayStack.size());
        
        //Remove all elements displaying pop and peek
        System.out.println("\npop(): ");
        System.out.println("Before: " + arrayStack.toString());
        temp = arrayStack.pop();
        System.out.println("After:  " + arrayStack.toString());
        System.out.println("Value of pop() is " + temp);
    
        System.out.print("peek(): ");
        System.out.println(arrayStack.peek());
        System.out.print("The size is: ");
        System.out.println(arrayStack.size());
    
        System.out.println("\npop(): ");
        System.out.println("Before: " + arrayStack.toString());
        temp = arrayStack.pop();
        System.out.println("After:  " + arrayStack.toString());
        System.out.println("Value of pop() is " + temp);
    
        System.out.print("peek(): ");
        System.out.println(arrayStack.peek());
        System.out.print("The size is: ");
        System.out.println(arrayStack.size());
    
        System.out.println("\npop(): ");
        System.out.println("Before: " + arrayStack.toString());
        temp = arrayStack.pop();
        System.out.println("After:  " + arrayStack.toString());
        System.out.println("Value of pop() is " + temp);
    
      
    
        System.out.print("peek(): ");
        System.out.println(arrayStack.peek());
        System.out.print("The size is: ");
        System.out.println(arrayStack.size());
    
        System.out.println("\npop(): ");
        System.out.println("Before: " + arrayStack.toString());
        temp = arrayStack.pop();
        System.out.println("After:  " + arrayStack.toString());
        System.out.println("Value of pop() is " + temp);
    
        System.out.print("peek(): ");
        System.out.println(arrayStack.peek());
        System.out.print("The size is: ");
        System.out.println(arrayStack.size());
    
        System.out.println("\npop(): ");
        System.out.println("Before: " + arrayStack.toString());
        temp = arrayStack.pop();
        System.out.println("After:  " + arrayStack.toString());
        System.out.println("Value of pop() is " + temp);
    
        System.out.println();
        ArrayStack.emptyStatus(arrayStack.isEmpty());
        System.out.println(arrayStack.toString());
    
        System.out.print("The size is: ");
        System.out.println(arrayStack.size());
        
        //exception tester: uncomment either of the below tests if you wish to see if the exception class is working properly
        //arrayStack.pop();
        //arrayStack.peek();
    
        System.out.println("\nTherefore, our stack is fully functional.");
        
        /**
         * QUESTION 2
         */
        System.out.println("\n|-----------------QUESTION 2-----------------|");
        
        DropOutStack<String> dropOutStack = new DropOutStack<>();
        
        //Test isEmpty()
        System.out.println("\n-Let's start off testing isEmpty(): ");
        System.out.println("Is the stack empty? (T/F): " + dropOutStack.isEmpty());
        System.out.println("We will test isEmpty again after pushing elements, for now let's push names onto the stack. \n");
        
        //Push names onto the stack
        System.out.println("-Push \"Nami\" onto the stack: ");
        dropOutStack.push("Nami");
        System.out.print(dropOutStack.toString());
        System.out.println("size(): " + dropOutStack.size() + ", peek(): " + dropOutStack.peek());
    
        System.out.println("\n-Push \"Robin\" onto the stack: ");
        dropOutStack.push("Robin");
        System.out.println(dropOutStack.toString());
        System.out.println("size(): " + dropOutStack.size() + ", peek(): " + dropOutStack.peek());
        
        System.out.println("\n-Push \"Jinbei\" onto the stack: ");
        dropOutStack.push("Jinbei");
        System.out.println(dropOutStack.toString());
        System.out.println("size(): " + dropOutStack.size() + ", peek(): " + dropOutStack.peek());
        
        System.out.println("\n-Push \"Sanji\" onto the stack: ");
        dropOutStack.push("Sanji");
        System.out.println(dropOutStack.toString());
        System.out.println("size(): " + dropOutStack.size() + ", peek(): " + dropOutStack.peek());
        
        System.out.println("\n-Push \"Zoro\" onto the stack: ");
        dropOutStack.push("Zoro");
        System.out.println(dropOutStack.toString());
        System.out.println("size(): " + dropOutStack.size() + ", peek(): " + dropOutStack.peek());
        
        //Stack is now full of entries at capacity of n = 5
        System.out.println("\n-This is the full drop out stack at it's maximum capcity of 5: ");
        System.out.println( dropOutStack.toString());
        System.out.println("size is: " + dropOutStack.size() +", \npeek() yields: " + dropOutStack.peek());
        
        //Push 2 more names after stack is full
        System.out.println("\n-push() the name \"Luffy\" onto the stack: ");
        dropOutStack.push("Luffy");
        System.out.println(dropOutStack.toString());
        System.out.println("size is: " + dropOutStack.size() +", \npeek() yields: " + dropOutStack.peek());
        System.out.println("*note that \"Nami\" has now dropped out of the stack");
    
        System.out.println("\n-push() the name \"Neyo\" onto the stack: ");
        dropOutStack.push("Neyo");
        System.out.println(dropOutStack.toString());
        System.out.println("size is: " + dropOutStack.size() +", \npeek() yields: " + dropOutStack.peek());
        System.out.println("*note that \"Robin\" has now dropped out of the stack");
    
        //Test pop() functionality by removing all elements
        System.out.println("\n-Additionally, let's test pop(): \n");
        System.out.println("-pop() yields: " + dropOutStack.pop());
        System.out.println(dropOutStack.toString());
        System.out.println("size is: " + dropOutStack.size() +", \npeek() yields: " + dropOutStack.peek());
        System.out.println("Is the stack empty? (T/F): " + dropOutStack.isEmpty());
        
        System.out.println("\n-pop() yields: " + dropOutStack.pop() );
        System.out.println(dropOutStack.toString());
        System.out.println("size is: " + dropOutStack.size() +", \npeek() yields: " + dropOutStack.peek());
        System.out.println("Is the stack empty? (T/F): " + dropOutStack.isEmpty());
    
        System.out.println("\n-pop() yields: " + dropOutStack.pop() );
        System.out.println(dropOutStack.toString());
        System.out.println("size is: " + dropOutStack.size() +", \npeek() yields: " + dropOutStack.peek());
        System.out.println("Is the stack empty? (T/F): " + dropOutStack.isEmpty());
    
        System.out.println("\n-pop() yields: " + dropOutStack.pop() );
        System.out.print(dropOutStack.toString());
        System.out.println("size is: " + dropOutStack.size() +", \npeek() yields: " + dropOutStack.peek());
        System.out.println("Is the stack empty? (T/F): " + dropOutStack.isEmpty());
    
        System.out.println("\n-pop() yields: " + dropOutStack.pop());
        System.out.print(dropOutStack.toString()); //Here toString will read "The stack is empty"
        System.out.println("size is: " + dropOutStack.size() +", \npeek() yields: " + dropOutStack.peek());
        System.out.println("Is the stack empty? (T/F): " + dropOutStack.isEmpty());
        
        
        System.out.println("\nTherefore, our drop out stack is fully functional.");
    
        /**
         * Question 3
         */
        System.out.println("\n|-----------------QUESTION 3-----------------|\n");
    
        LinkedDeque<Integer> linkedDeque = new LinkedDeque<Integer>();
        
        //Adding integers to the front of the deque
        System.out.println("Adding the integers 3,2,1 to the front of the deque in that order: ");
        linkedDeque.addFront(3);
        System.out.println(linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() + ", First element: " + linkedDeque.viewFirst() + ", Last element: " + linkedDeque.viewLast() + "\n");
        
        linkedDeque.addFront(2);
        System.out.println(linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() +", First element: " + linkedDeque.viewFirst() + ", Last element: " + linkedDeque.viewLast() + "\n");
        
        linkedDeque.addFront(1);
        System.out.println(linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() +", First element: " + linkedDeque.viewFirst() + ", Last element: " + linkedDeque.viewLast() + "\n");
    
        //Adding integers to the rear of the deque
        System.out.println("\nAdding the numbers 4,5,6 to the rear of the deque in that order: ");
        linkedDeque.addRear(4);
        System.out.println(linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() +", First element: " + linkedDeque.viewFirst() + ", Last element: " + linkedDeque.viewLast() + "\n");
    
        linkedDeque.addRear(5);
        System.out.println(linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() +", First element: " + linkedDeque.viewFirst() + ", Last element: " + linkedDeque.viewLast() + "\n");
    
        linkedDeque.addRear(6);
        System.out.println(linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() +", First element: " + linkedDeque.viewFirst() + ", Last element: " + linkedDeque.viewLast() + "\n");
    
        //Checking isEmpty()
        System.out.println("\nChecking if the deque is empty:");
        LinkedDeque.emptyStatus(linkedDeque.isEmpty()); System.out.println();
        
        System.out.println("The elements in the deque are: ");
        System.out.println(linkedDeque.toString());
        System.out.println();
        
        //Printing out the elements using Next and Previous references for testing purposes
        //System.out.println("Print backwards: ");
        //System.out.println(linkedDeque.printBackwards());
        //System.out.println("Print forwards: ");
        //System.out.println(linkedDeque.printForwards());
        
        //Printing out all the nodes in the deque to check their addresses for next and previous checking
        //System.out.println("\nnode display");
        //linkedDeque.printNodes();
        
        //Testing removing the elements from the front and rear of deque
        System.out.println("\nI will now alternate removing elements from the front and then the rear until the deque is empty: \n");
        System.out.println("Removing from the front of the deque: ");
        System.out.println("Before: " + linkedDeque.toString());
        linkedDeque.removeFront();
        System.out.println("After:  " + linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() +", First element: " + linkedDeque.viewFirst() + ", Last element: " + linkedDeque.viewLast() + "\n");
    
        System.out.println("\nRemoving from the rear of the deque: ");
        System.out.println("Before: " + linkedDeque.toString());
        linkedDeque.removeRear();
        System.out.println("After:  " + linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() +", First element: " + linkedDeque.viewFirst() + ", Last element: " + linkedDeque.viewLast() + "\n");
    
        System.out.println("\nRemoving from the front of the deque: ");
        System.out.println("Before: " + linkedDeque.toString());
        linkedDeque.removeFront();
        System.out.println("After:  " + linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() +", First element: " + linkedDeque.viewFirst() + ", Last element: " + linkedDeque.viewLast() + "\n");
    
        System.out.println("\nRemoving from the rear of the deque: ");
        System.out.println("Before: " + linkedDeque.toString());
        linkedDeque.removeRear();
        System.out.println("After:  " + linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() +", First element: " + linkedDeque.viewFirst() + ", Last element: " + linkedDeque.viewLast() + "\n");
    
        System.out.println("\nRemoving from the front of the deque: ");
        System.out.println("Before: " + linkedDeque.toString());
        linkedDeque.removeFront();
        System.out.println("After:  " + linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() +", First element: " + linkedDeque.viewFirst() + ", Last element: " + linkedDeque.viewLast() + "\n");
    
        System.out.println("\nRemoving from the rear of the deque: ");
        System.out.println("Before: " + linkedDeque.toString());
        linkedDeque.removeRear();
        System.out.println("After:  " + linkedDeque.toString());
        System.out.print("Size: " + linkedDeque.size() + ", First element: null, Last element: null" ); //if you use viewfirst or viewlast here you get the exception thrown as expected
        
        System.out.println("\n\nTherefore our deque is fully functional.\n");
        
        System.out.println("|-----------------------END OF QUESTIONS-----------------------|\n\nThank you for viewing my assignment have a nice day." );
    
    
        /**Palindrome checker, this is a program I made for fun which accepts a string and checks if it's a palindrome using a stack
         ArrayStack<String> stringStack = new ArrayStack<>();
         Scanner getUserInput = new Scanner(System.in);
         System.out.print("\nPlease enter a word to check if it's a palindrome: ");
         String word = getUserInput.next();
     
         String reversedWord = "";
     
         for(int i = 0; i < word.length() ; i++)
         {
         stringStack.push(String.valueOf(word.charAt(i)));
         }
     
         for(int i = 0; i < word.length() ; i++)
         {
         reversedWord = reversedWord + stringStack.pop();
         }
     
         if(word.equalsIgnoreCase(reversedWord))
         {
         System.out.println("original word: " + word + " reversed word: " + reversedWord);
         System.out.println("Your word is a palindrome");
         }
         else
         {
         System.out.println("Your word is not a palindrome.");
         }
         */
    
    }
}

    
