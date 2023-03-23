package jsjf;
import jsjf.exceptions.*;
import java.util.*;

/**
 * @author Neyoshaan Uthayakumaran TRU : T00665922
 */

/**
 * Graph represents an adjacency matrix implementation of a graph.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class Graph<T> implements GraphADT<T>
{
    protected final int DEFAULT_CAPACITY = 5;
    protected int numVertices;    // number of vertices in the graph
    protected boolean[][] adjMatrix;    // adjacency matrix
    protected T[] vertices;    // values of vertices
    protected int modCount;
    
    /**
     * Creates an empty graph.
     */
    public Graph()
    {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }
    
    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param vertex1  the first vertex
     * @param vertex2  the second vertex
     */
    public void addEdge(T vertex1, T vertex2)
    {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }
    
    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param index1  the first index
     * @param index2  the second index
     */
    public void addEdge(int index1, int index2)
    {
        if (indexIsValid(index1) && indexIsValid(index2))
        {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
            modCount++;
        }
        else//Display that the index is invalid
        {
            System.out.println("The index is invalid");
        }
    }
    
    /**
     * Removes an edge between two vertices of the graph.
     *
     * @param vertex1  the first vertex
     * @param vertex2  the second vertex
     */
    public void removeEdge(T vertex1, T vertex2)
    {
        removeEdge(getIndex(vertex1), getIndex(vertex2)); //similar to the addEdge method, needs to get the index' which makes up the edge first and pass that to overloaded method
    }
    
    /**
     * Removes an edge between two vertices of the graph.
     *
     * @param index1  the first index
     * @param index2  the second index
     */
    public void removeEdge(int index1, int index2)//similar to the addEdge method but connections set to false
    {
        //determine if each index is valid so as to allow removal
        if (indexIsValid(index1) && indexIsValid(index2))
        {
            //The adjacency table is updated to reflect that the edge between index 1 and 2 is removed
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
            modCount++;
        }
        else
        {
            System.out.println("The index is invalid");
        }
    }
    
    /**
     * Adds a vertex to the graph, expanding the capacity of the graph
     * if necessary.
     */
    public void addVertex()//this method is similar to the overloaded method
    {
        //the new vertex is initially null as it doesnt have a value yet
        T newVertex = null;
        //If the number of vertices plus 1 in the graph is equal to the graph lenght then expand the graph
        if ((numVertices+1) == adjMatrix.length)
            expandCapacity();
        //add the new vertex at the last index given by numVertices
        vertices[numVertices] = newVertex;
        //all connections in the graph in relation to the new vertex are set to false as it's not connected yet
        for (int i = 0; i < numVertices; i++)
        {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        //increase the number of vertices and mod count accordingly
        numVertices++;
        modCount++;
    }
    
    /**
     * Adds a vertex to the graph, expanding the capacity of the graph
     * if necessary.  It also associates an object with the vertex.
     *
     * @param vertex  the vertex to add to the graph
     */
    public void addVertex(T vertex)
    {
        if ((numVertices + 1) == adjMatrix.length)
            expandCapacity();
        
        vertices[numVertices] = vertex;
        for (int i = 0; i < numVertices; i++)
        {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
        modCount++;
    }
    
    /**
     * Removes the first occurrence of a vertex with the given value from the graph.
     *
     * @param vertex  the vertex to be removed from the graph
     */
    public void removeVertex(T vertex)
    {
        // Check if the graph is empty. If it is, error is thrown accordingly
        if (!(isEmpty()))
        {
            // if not empty, the index of the element is found and used to remove the vertex
            removeVertex(getIndex(vertex));
        }
        else
        {
            throw new EmptyCollectionException("Graph");
        }
    }
    
    /**
     * Removes a vertex at the given index from the graph.  Note that
     * this may affect the index values of other vertices.
     *
     * @param index  the index at which the vertex is to be removed from
     */
    public void removeVertex(int index)
    {
        if (!(isEmpty()))//make sure the graph is not empty
        {
            if (indexIsValid(index)) //if the index is invalid
            {
                for (int i = 0; i < numVertices; i++)//iterate through rows
                {
                    for (int j = 0; j < numVertices; j++)//iterate through each element in a given row
                    {
                        if (i < index && j > index)
                        {
                            adjMatrix[i][j-1] = adjMatrix[i][j];
                        }
                        else if (i > index && j < index)
                        {
                            adjMatrix[i-1][j] = adjMatrix[i][j];
                        }
                        else if (i > index && j > index)
                        {
                            adjMatrix[i-1][j-1] = adjMatrix[i][j];
                        }
                    }
        
                    // decrement after reaching the last element in the matrix
                    if (i > index)
                    {
                        vertices[i-1] = vertices[i];
                    }
                }
                //decrement the vertices since one is removed and increment mod count
                numVertices--;
                modCount++;
            }
            else // if the index is invalid
            {
                System.out.println("The index is invalid");
            }
            
        }
        else//The graph is empty
        {
            throw new EmptyCollectionException("graph");
        }
    }
    
    /**
     * Creates new arrays to store the contents of the graph with
     * twice the capacity.
     */
    protected void expandCapacity()
    {
        T[] largerVertices = (T[])(new Object[vertices.length * 2]);
        boolean[][] largerAdjMatrix =
                new boolean[vertices.length * 2][vertices.length * 2];
        
        for (int i = 0; i < numVertices; i++)
        {
            for (int j = 0; j < numVertices; j++)
            {
                largerAdjMatrix[i][j] = adjMatrix[i][j];
            }
            largerVertices[i] = vertices[i];
        }
        
        vertices = largerVertices;
        adjMatrix = largerAdjMatrix;
    }
    
    /**
     * Returns the number of vertices in the graph.
     *
     * @return the integer number of vertices in the graph
     */
    public int size()
    {
        //numVertices would be the size of the graph
        return numVertices;
    }
    
    /**
     * Returns true if the graph is empty and false otherwise.
     *
     * @return true if the graph is empty
     */
    public boolean isEmpty()
    {
        //When the number of vertices is 0 the graph is empty
        return (numVertices == 0);
    }
    
    /**
     * Returns true if the graph is connected and false otherwise.
     *
     * @return true if the graph is connected
     */
    public boolean isConnected()
    {
        //Connectivity is defined as the condition when in a graph containing n vertices, the size of the Breadth first search at each vertex v is equal to n
        //therefore the number of connections should be equal to the number of vertices at each node for every breadth first search
        for (int index = 0; index < numVertices; index++)
        {
            Iterator<T> iterator = iteratorBFS(index);
            
            int numConnections = 0;
            
            while (iterator.hasNext()) {
                iterator.next();
                numConnections++;
            }
            
            if (numConnections != numVertices) //breadth first at each vertice is checked against number of vertices to see if it fulfills the condition for connectivity
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns the index value of the first occurrence of the vertex.
     * Returns -1 if the key is not found.
     *
     * @param vertex the vertex whose index value is being sought
     * @return the index value of the given vertex
     */
    public int getIndex(T vertex)
    {
        int temp = -1;
        int i = 0;
        int nullIndex = -1;
        
        while((temp == -1) && (i < size()))//This ensures you return the first occurrence not the last occurrence as would happen with a for loop
        {
            if(this.vertices[i] != null)//EDGE CASE** ensures that if there is a null value while looking through the vertices[] array an error doesnt happen because of the Obejct class equals() function
            {
                if ((vertices[i]).equals(vertex))
                {
                    temp = i;//sets the vertex value to the temp storage value when its equal
                }
                i++;
            }
            else
            {
                nullIndex = i; //set the index that is null
                i++;
            }
        }
        
        if(vertex == null)// EDGE CASE** If you're searching for null vertices in the graph so getIndex(null) edge case
            temp = nullIndex;
        
        return temp;
    }
    
    /**
     * Returns a copy of the vertices array.
     *
     * @return a copy of the vertices array
     */
    public Object[] getVertices()
    {
        //create an array that's the same size as the graph using the graph size or number of vertices
        Object[] result = new Object[numVertices];
        
        //iterate through the graph array which is a instance variable of the class and copy it to the copy array created above
        for (int i=0; i<numVertices; i++) {
            result[i] = vertices[i];
        }
        
        return result; //return the copy array that was created
    }
    
    /**
     * Returns true if the given index is valid.
     *
     * @param index the index whose validity is being queried
     * @return true if the given index is valid
     */
    protected boolean indexIsValid(int index)
    {
        //checks if the index is within the bounds of the graph which is 0 < index < numVertices||size()
        return ((index >= 0) && (index < size()));
    }
    
    /**
     * Returns a string representation of the adjacency matrix.
     *
     * @return  a string representation of the adjacency matrix
     */
    public String toString() //made some minor QOL edits of my own to make it look better
    {
        if (isEmpty())
            return "Graph is empty";
        
        String result = "|--------------------------|\n" + "Adjacency Matrix\n";
        result += "----------------\n";
        result += "index\t";
        
        for (int i = 0; i < numVertices; i++)
        {
            result += "" + i;
            if (i < 10)
                result += " ";
        }
        result += "\n\n";
        
        for (int i = 0; i < numVertices; i++)
        {
            result += "" + i + "\t    ";  //added spaces so it lines up properly in console
            
            for (int j = 0; j < numVertices; j++)
            {
                if (adjMatrix[i][j])
                    result += "1 ";
                else
                    result += "0 ";
            }
            result += "\n";
        }
        
        result += "\nVertex Values";
        result += "\n-------------\n";
        result += "index\tvalue\n\n";
        
        for (int i = 0; i < numVertices; i++)
        {
            if(this.vertices[i] != null)//EDGE CASE if you try to use the toString method on a value that's null you will get an error, this code solves that edge case
            {
                result += "" + i + "\t    ";//added spaces again to line up in console
                result += vertices[i].toString() + "\n";
            }
            else
            {
                result += "" + i + "\t    ";//for the case where there's an empty vertex or null this.vertices[i] would be null and that causes an error when using toString() so simply add null to result instead
                result += "null" + "\n";
            }
        }
        result += "|--------------------------|\n";
        return result;
    }
    
    /**
     * Sets a null vertex or other vertex to a value indicated by input vertex value
     * @param vertex
     * @param index
     */
    public void setVertex(T vertex, int index)// I implemented this function just to see if I can
    {                                         //This is not a required test method
        if(indexIsValid(index))
        {
            vertices[index] = vertex;
        }
        else
            System.out.println("The index is invalid");
        
    }
    
    //Included methods not required to be tested below
    
    /**
     * Returns an iterator that performs a depth first traversal
     * starting at the given index.
     *
     * @param startIndex the index from which to begin the traversal
     * @return an iterator that performs a depth first traversal
     */
    public Iterator<T> iteratorDFS(int startIndex)
    {
        Integer x;
        boolean found;
        StackADT<Integer> traversalStack = new LinkedStack<Integer>();
        UnorderedListADT<T> resultList = new ArrayUnorderedList<T>();
        boolean[] visited = new boolean[numVertices];
        
        if (!indexIsValid(startIndex))
            return resultList.iterator();
        
        for (int i = 0; i < numVertices; i++)
            visited[i] = false;
        
        traversalStack.push(new Integer(startIndex));
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;
        
        while (!traversalStack.isEmpty())
        {
            x = traversalStack.peek();
            found = false;
            
            //  Find a vertex adjacent to x that has not been visited and push it on the stack
            for (int i = 0; (i < numVertices) && !found; i++)
            {
                if (adjMatrix[x.intValue()][i] && !visited[i])
                {
                    traversalStack.push(new Integer(i));
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty())
                traversalStack.pop();
        }
        return new GraphIterator(resultList.iterator());
    }
    
    /**
     * Returns an iterator that performs a depth first search
     * traversal starting at the given vertex.
     *
     * @param startVertex the vertex to begin the search from
     * @return an iterator that performs a depth first traversal
     */
    public Iterator<T> iteratorDFS(T startVertex)
    {
        return iteratorDFS(getIndex(startVertex));
    }
    
    /**
     * Returns an iterator that performs a breadth first
     * traversal starting at the given index.
     *
     * @param startIndex the index from which to begin the traversal
     * @return an iterator that performs a breadth first traversal
     */
    public Iterator<T> iteratorBFS(int startIndex)
    {
        Integer x;
        QueueADT<Integer> traversalQueue = new LinkedQueue<Integer>();
        UnorderedListADT<T> resultList = new ArrayUnorderedList<T>();
        
        if (!indexIsValid(startIndex))
            return resultList.iterator();
        
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++)
        {
            visited[i] = false;
        }
        
        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;
        
        while (!traversalQueue.isEmpty())
        {
            x = traversalQueue.dequeue();
            resultList.addToRear(vertices[x.intValue()]);
            //  Find all vertices adjacent to x that have not been visited
            //  and queue them up
            
            for (int i = 0; i < numVertices; i++)
            {
                if (adjMatrix[x.intValue()][i] && !visited[i])
                {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        return new GraphIterator(resultList.iterator());
    }
    
    /**
     * Returns an iterator that performs a breadth first search
     * traversal starting at the given vertex.
     *
     * @param startVertex the vertex to begin the search from
     * @return an iterator that performs a breadth first traversal
     */
    public Iterator<T> iteratorBFS(T startVertex)
    {
        return iteratorBFS(getIndex(startVertex));
    }
    
    /**
     * Returns an iterator that contains the indices of the vertices
     * that are in the shortest path between the two given vertices.
     *
     * @param startIndex the starting index
     * @param targetIndex the the target index
     * @return the an iterator containing the indices of the
     *               of the vertices making the shortest path between
     *               the given indices
     */
    protected Iterator<Integer> iteratorShortestPathIndices(int startIndex, int targetIndex)
    {
        int index = startIndex;
        int[] pathLength = new int[numVertices];
        int[] predecessor = new int[numVertices];
        QueueADT<Integer> traversalQueue = new LinkedQueue<Integer>();
        UnorderedListADT<Integer> resultList =
                new ArrayUnorderedList<Integer>();
        
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex) ||
                (startIndex == targetIndex))
            return resultList.iterator();
        
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++)
            visited[i] = false;
        
        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;
        pathLength[startIndex] = 0;
        predecessor[startIndex] = -1;
        
        while (!traversalQueue.isEmpty() && (index != targetIndex))
        {
            index = (traversalQueue.dequeue()).intValue();
            
            //Update the pathLength for each unvisited vertex adjacent
            //     to the vertex at the current index.
            for (int i = 0; i < numVertices; i++)
            {
                if (adjMatrix[index][i] && !visited[i])
                {
                    pathLength[i] = pathLength[index] + 1;
                    predecessor[i] = index;
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        if (index != targetIndex)  // no path must have been found
            return resultList.iterator();
        
        StackADT<Integer> stack = new LinkedStack<Integer>();
        index = targetIndex;
        stack.push(new Integer(index));
        do
        {
            index = predecessor[index];
            stack.push(new Integer(index));
        } while (index != startIndex);
        
        while (!stack.isEmpty())
            resultList.addToRear(((Integer)stack.pop()));
        
        return new GraphIndexIterator(resultList.iterator());
    }
    
    /**
     * Returns an iterator that contains the shortest path between
     * the two vertices.
     *
     * @param startIndex the starting index
     * @param targetIndex the target index
     * @return an iterator that contains the shortest path
     *           between the given vertices
     */
    public Iterator<T> iteratorShortestPath(int startIndex, int targetIndex)
    {
        UnorderedListADT<T> resultList = new ArrayUnorderedList<T>();
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
            return resultList.iterator();
        
        Iterator<Integer> it = iteratorShortestPathIndices(startIndex, targetIndex);
        while (it.hasNext())
            resultList.addToRear(vertices[((Integer)it.next()).intValue()]);
        return new GraphIterator(resultList.iterator());
    }
    
    /**
     * Returns an iterator that contains the shortest path between
     * the two vertices.
     *
     * @param startVertex the starting vertex
     * @param targetVertex the target vertex
     * @return an iterator that contains the shortest path between
     *         the given vertices
     */
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex)
    {
        return iteratorShortestPath(getIndex(startVertex), getIndex(targetVertex));
    }
    
    /**
     * Returns the weight of the least weight path in the network.
     * Returns positive infinity if no path is found.
     *
     * @param startIndex the starting index
     * @param targetIndex the target index
     * @return the integer weight of the least weight path
     *                in the network
     */
    public int shortestPathLength(int startIndex, int targetIndex)
    {
        int result = 0;
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
            return 0;
        
        int index1, index2;
        Iterator<Integer> it = iteratorShortestPathIndices(startIndex,
                targetIndex);
        
        if (it.hasNext())
            index1 = ((Integer)it.next()).intValue();
        else
            return 0;
        
        while (it.hasNext())
        {
            result++;
            it.next();
        }
        
        return result;
    }
    
    /**
     * Returns the weight of the least weight path in the network.
     * Returns positive infinity if no path is found.
     *
     * @param startVertex the starting vertex
     * @param targetVertex the target vertex
     * @return the integer weight of the least weight path
     *            in the network
     */
    public int shortestPathLength(T startVertex, T targetVertex)
    {
        return shortestPathLength(getIndex(startVertex), getIndex(targetVertex));
    }
    
    /**
     * Returns a minimum spanning tree of the graph.
     *
     * @return a minimum spanning tree of the graph
     */
    public Graph<T> getMST()
    {
        int x, y;
        int[] edge = new int[2];
        StackADT<int[]> vertexStack = new LinkedStack<int[]>();
        Graph<T> resultGraph = new Graph<T>();
        
        if (isEmpty() || !isConnected())
            return resultGraph;
        
        resultGraph.adjMatrix = new boolean[numVertices][numVertices];
        
        for (int i = 0; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
                resultGraph.adjMatrix[i][j] = false;
        
        resultGraph.vertices = (T[])(new Object[numVertices]);
        boolean[] visited = new boolean[numVertices];
        
        for (int i = 0; i < numVertices; i++)
            visited[i] = false;
        
        edge[0] = 0;
        resultGraph.vertices[0] = this.vertices[0];
        resultGraph.numVertices++;
        visited[0] = true;
        
        // Add all edges that are adjacent to vertex 0 to the stack.
        for (int i = 0; i < numVertices; i++)
        {
            if (!visited[i] && this.adjMatrix[0][i])
            {
                edge[1] = i;
                vertexStack.push(edge.clone());
                visited[i] = true;
            }
        }
        
        while ((resultGraph.size() < this.size()) && !vertexStack.isEmpty())
        {
            // Pop an edge off the stack and add it to the resultGraph.
            edge = vertexStack.pop();
            x = edge[0];
            y = edge[1];
            resultGraph.vertices[y] = this.vertices[y];
            resultGraph.numVertices++;
            resultGraph.adjMatrix[x][y] = true;
            resultGraph.adjMatrix[y][x] = true;
            visited[y] = true;
            
            // Add all unvisited edges that are adjacent to vertex y to the stack.
            for (int i = 0; i < numVertices; i++)
            {
                if (!visited[i] && this.adjMatrix[i][y])
                {
                    edge[0] = y;
                    edge[1] = i;
                    vertexStack.push(edge.clone());
                    visited[i] = true;
                }
            }
        }
        
        return resultGraph;
    }
    
    /**
     * Inner class to represent an iterator over the elements of this graph
     */
    protected class GraphIterator implements Iterator<T>
    {
        private int expectedModCount;
        private Iterator<T> iter;
        
        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param iter the list iterator created by a graph traversal
         */
        public GraphIterator(Iterator<T> iter)
        {
            this.iter = iter;
            expectedModCount = modCount;
        }
        
        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException
        {
            if (!(modCount == expectedModCount))
                throw new ConcurrentModificationException();
            return (iter.hasNext());
        }
        
        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next() throws NoSuchElementException
        {
            if (hasNext())
                return (iter.next());
            else
                throw new NoSuchElementException();
        }
        
        /**
         * The remove operation is not supported.
         *
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * Inner class to represent an iterator over the indexes of this graph
     */
    protected class GraphIndexIterator implements Iterator<Integer>
    {
        private int expectedModCount;
        private Iterator<Integer> iter;
        
        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param iter the list iterator created by a graph traversal
         */
        public GraphIndexIterator(Iterator<Integer> iter)
        {
            this.iter = iter;
            expectedModCount = modCount;
        }
        
        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException
        {
            if (!(modCount == expectedModCount))
                throw new ConcurrentModificationException();
            
            return (iter.hasNext());
        }
        
        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public Integer next() throws NoSuchElementException
        {
            if (hasNext())
                return (iter.next());
            else
                throw new NoSuchElementException();
        }
        
        /**
         * The remove operation is not supported.
         *
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}
