# Stacks and Queues 

This assignment focuses on creating stacks and queues using varying methods of implementation such as using arrays and linked lists. Also the stacks and queues required to be implemented are real world use applications such as Drop-out stacks, and Deques. These implementations are created by creating unique interfaces for each and then implementing said interfaces, ie: DequeADT. 

Detailed Requirements Description:

1. The ArrayStack implementation in Chapter 12 uses the top variable to point to the next array position available in the stack i.e. above the actual top of the stack. Modify the array implementation such that stack[top] is the actual top of the stack. Do not introduce any other counter variables. Make sure your driver demonstrates any method that you modify. (Adapted from PP 12.4.)

2. There is a data structure called a drop-out stack that behaves like a stack in every respect except that the size is fixed. If the stack size is n, the bottom element is lost when the n+1 element is pushed onto the top. Implement a drop-out stack using links, by modifying the LinkedStack code that you completed as part of Lab 3.

  The driver should create a stack of moderate size (say five) and push on that many String elements consisting of people’s names (include your own). Output the contents   of the stack and the results of the size() and peek() operations. Push two more elements onto the stack, outputting the contents and the results of the size() an   peek() operations for each. (Adapted from PP 13.8.)

3. A double-ended queue, or deque (pronounced like “deck”), is introduced in Section 14.8. With a deque you can add, remove, or view elements from both ends of the queue. Rather than use the Deque interface supplied by the Java API, design your own DequeADT interface (patterned after QueueADT). Then, implement a deque using links.

  The driver should create a deque of moderate size (say five or six). It should repetitively add elements to the front, and then the rear. For each addition, output the   contents of the deque as well as the size, front element, and last element. Then, repetitively remove elements from the deque. For each removal, output the contents of   the deque as well as the size, front element, and last element. (Adapted from PP 14.6 and PP 14.7.)
