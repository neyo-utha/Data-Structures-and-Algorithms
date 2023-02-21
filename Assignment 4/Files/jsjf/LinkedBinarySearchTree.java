package jsjf;
import java.util.Arrays;
import jsjf.exceptions.*;

/**
 * @author Neyoshaan Uthayakumaran TRU : T00665922
 */

/**
 * LinkedBinarySearchTree implements the BinarySearchTreeADT interface
 * with links.
 *
 * @author Java Foundations
 * @version 4.0
 */

/**
 * LinkedBinarySearchTree implements the BinarySearchTreeADT interface
 * with links.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T>
        implements BinarySearchTreeADT<T>
{
    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTree()
    {
        super();
    }
    
    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will be the root of the new binary
     *        search tree
     */
    public LinkedBinarySearchTree(T element)
    {
        super(element);
        
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("LinkedBinarySearchTree");
    }
    
    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its natural order.  Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    public void addElement(T element)
    {
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("LinkedBinarySearchTree");
        
        Comparable<T> comparableElement = (Comparable<T>)element;
        
        if (isEmpty())
            root = new BinaryTreeNode<T>(element);
        else
        {
            if (comparableElement.compareTo(root.getElement()) < 0)
            {
                if (root.getLeft() == null)
                    this.getRootNode().setLeft(new BinaryTreeNode<T>(element));
                else
                    addElement(element, root.getLeft());
            }
            else
            {
                if (root.getRight() == null)
                    this.getRootNode().setRight(new BinaryTreeNode<T>(element));
                else
                    addElement(element, root.getRight());
            }
        }
        modCount++;
    }
    
    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its natural order.  Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    private void addElement(T element, BinaryTreeNode<T> node)
    {
        Comparable<T> comparableElement = (Comparable<T>)element;
        
        if (comparableElement.compareTo(node.getElement()) < 0)
        {
            if (node.getLeft() == null)
                node.setLeft(new BinaryTreeNode<T>(element));
            else
                addElement(element, node.getLeft());
        }
        else
        {
            if (node.getRight() == null)
                node.setRight(new BinaryTreeNode<T>(element));
            else
                addElement(element, node.getRight());
        }
    }
    
    
    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @throws ElementNotFoundException if the target element is not found
     */
    public T removeElement(T targetElement) throws ElementNotFoundException
    {
        T result = null;
        
        if (isEmpty())
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        else
        {
            BinaryTreeNode<T> parent = null;
            if (((Comparable<T>)targetElement).equals(root.element))
            {
                result =  root.element;
                BinaryTreeNode<T> temp = replacement(root);
                if (temp == null)
                    root = null;
                else
                {
                    root.element = temp.element;
                    root.setRight(temp.right);
                    root.setLeft(temp.left);
                }
                
                modCount--;
            }
            else
            {
                parent = root;
                if (((Comparable)targetElement).compareTo(root.element) < 0)
                    result = removeElement(targetElement, root.getLeft(), parent);
                else
                    result = removeElement(targetElement, root.getRight(), parent);
            }
        }
        
        return result;
    }
    
    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @param node the node from which to search
     * @param parent the parent of the node from which to search
     * @throws ElementNotFoundException if the target element is not found
     */
    private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent)
            throws ElementNotFoundException
    {
        T result = null;
        
        if (node == null)
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        else
        {
            if (((Comparable<T>)targetElement).equals(node.element))
            {
                result =  node.element;
                BinaryTreeNode<T> temp = replacement(node);
                if (parent.right == node)
                    parent.right = temp;
                else
                    parent.left = temp;
                
                modCount--;
            }
            else
            {
                parent = node;
                if (((Comparable)targetElement).compareTo(node.element) < 0)
                    result = removeElement(targetElement, node.getLeft(), parent);
                else
                    result = removeElement(targetElement, node.getRight(), parent);
            }
        }
        
        return result;
    }
    
    /**
     * Returns a reference to a node that will replace the one
     * specified for removal. In the case where the removed node has
     * two children, the inorder successor is used as its replacement.
     *
     * @param node the node to be removed
     * @return a reference to the replacing node
     */
    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node)
    {
        BinaryTreeNode<T> result = null;
        
        if ((node.left == null) && (node.right == null))
            result = null;
        
        else if ((node.left != null) && (node.right == null))
            result = node.left;
        
        else if ((node.left == null) && (node.right != null))
            result = node.right;
        
        else
        {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            
            while (current.left != null)
            {
                parent = current;
                current = current.left;
            }
            
            current.left = node.left;
            if (node.right != current)
            {
                parent.left = current.right;
                current.right = node.right;
            }
            
            result = current;
        }
        
        return result;
    }
    
    /**
     * Removes elements that match the specified target element from
     * the binary search tree. Throws a ElementNotFoundException if
     * the specified target element is not found in this tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @throws ElementNotFoundException if the target element is not found
     */
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException
    {
        removeElement(targetElement);
        
        try
        {
            while (contains((T)targetElement))
                removeElement(targetElement);
        }
        
        catch (Exception ElementNotFoundException)
        {
        }
    }
    
    /**
     * Removes the node with the least value from the binary search
     * tree and returns a reference to its element.  Throws an
     * EmptyCollectionException if this tree is empty.
     *
     * @return a reference to the node with the least value
     * @throws EmptyCollectionException if the tree is empty
     */
    public T removeMin() throws EmptyCollectionException
    {
        T result = null;
        
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else
        {
            if (root.left == null)
            {
                result = root.element;
                root = root.right;
            }
            else
            {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;
                while (current.left != null)
                {
                    parent = current;
                    current = current.left;
                }
                result =  current.element;
                parent.left = current.right;
            }
            
            modCount--;
        }
        
        return result;
    }
    
    /**
     * Removes the node with the highest value from the binary
     * search tree and returns a reference to its element.  Throws an
     * EmptyCollectionException if this tree is empty.
     *
     * @return a reference to the node with the highest value
     * @throws EmptyCollectionException if the tree is empty
     */
    public T removeMax() throws EmptyCollectionException
    {
        
        T result = null;
        
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else
        {
            if (root.right == null) //checks if the right child is null (we want to go right to get max)
            {
                result = root.element;
                root = root.left;
            }
            else //enter the right subtree -> keep going right to get the max element
            {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;
                while (current.right != null) //keep going right until you're at a null point or leaf which will be the rightmost leaf
                {
                    parent = current;
                    current = current.right;
                }
                result =  current.element; //store the element at current which would be the rightmost leaf
                parent.right = current.left;//relink so as to remove
            }
            modCount--; //decrement accordingly
        }
        return result;
    }
    
    /**
     * Returns the element with the least value in the binary search
     * tree. It does not remove the node from the binary search tree.
     * Throws an EmptyCollectionException if this tree is empty.
     *
     * @return the element with the least value
     * @throws EmptyCollectionException if the tree is empty
     */
    public T findMin() throws EmptyCollectionException
    {
        T result = null;
        
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else
        {
            BinaryTreeNode<T> current = root; //start at the root
            
            while (current.left != null) //enter the left subtree and keep going until you reach a leaf
                current = current.left;
            
            result = current.element; // return the leftmost leaf which will be min value in bst
        }
        
        return result;
    }
    
    /**
     * Returns the element with the highest value in the binary
     * search tree.  It does not remove the node from the binary
     * search tree.  Throws an EmptyCollectionException if this
     * tree is empty.
     *
     * @return the element with the highest value
     * @throws EmptyCollectionException if the tree is empty
     */
    public T findMax() throws EmptyCollectionException
    {
        T result = null;
        
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else
        {
            BinaryTreeNode<T> current = root;//start at the root
            
            while (current.right != null)//enter the right subtree keep going until you reach a leaf
                current = current.right;
            
            result = current.element;//return the rightmost leaf which is max element in bst
        }
        
        return result;
    }
    
    /**
     * Returns the left subtree of the root of this tree.
     *
     * @return a link to the left subtree fo the tree
     */
    public LinkedBinarySearchTree<T> getLeft()
    {
        if (root == null)
            throw new EmptyCollectionException("getLeft() failed. The tree is empty.");
        
        LinkedBinarySearchTree<T> result = new LinkedBinarySearchTree<T>();
        result.root = root.getLeft(); //make use of the getLeft method of BinaryTreeNode to accomplish this method
        
        return result;
    }
    
    /**
     * Returns the right subtree of the root of this tree.
     *
     * @return a link to the right subtree of the tree
     */
    public LinkedBinarySearchTree<T> getRight()
    {
        if (root == null)
            throw new EmptyCollectionException("getRight() failed. The tree is empty.");
        
        LinkedBinarySearchTree<T> result = new LinkedBinarySearchTree<T>();
        result.root = root.getRight();//make use of the getRight method of BinaryTreeNode to accomplish this method
        
        return result;
    }
    
    
    /**
     * Returns a balanced tree from the input tree.
     * The input tree is converted to an array list and is then partitioned
     * and balanced recursively using the recursive balance method
     * @return a link to a balanced tree object
     */
    public LinkedBinarySearchTree<T> balanceTree()
    {
        //convert the tree to an arraylist with the toArray method
        T[] tempList = (T[])(new Object[size()]);
        tempList = toArray();
        
        LinkedBinarySearchTree balancedTree = new LinkedBinarySearchTree<>();
        balancedTree.recursiveBalance(tempList); //balance via the recursive method below
        
        return balancedTree;
    }
    
    /**
     * Balances an input array list of objects which is a representation of a tree
     * Takes in an array representation of the tree
     * @param list
     */
    private void recursiveBalance(T[] list)
    {
        //If the array or tree is empty do not execute
        if (list != null)
        {
            //case where tree only has a root element or list only has one entry, simply add to the list
            if (list.length == 1)
            {
                addElement(list[0]);
            }
            else //Add the middle value of the list to the tree, then half the lists and add the middle value of each list, repeat recursively
            {
                int mid = list.length/2;
                addElement(list[mid]); //middle element is added to tree
                recursiveBalance(rangeBetween(list, 0, mid-1)); //first half goes to mid-1
                recursiveBalance(rangeBetween(list, mid+1, list.length-1)); //second half starts at mid+1
            }
        }
    }
    
    /**
     * Returns a sublist which contains part of a given list from the input start point to end point
     * @param list
     * @param startPoint
     * @param endPoint
     * @return a list containing the values from the start point to the end point of an input list
     */
    private T[] rangeBetween(T[] list, int startPoint, int endPoint)
    {
        if (startPoint > endPoint) //ensures that the range is valid
        {
            return null;
        }
        T[] tempList = (T[])(new Object[(endPoint-startPoint)]);
        tempList = Arrays.copyOfRange(list, startPoint, endPoint+1); //makes a copy of the input from start to end point given using arrays util method
        return tempList;
    }
    
}
