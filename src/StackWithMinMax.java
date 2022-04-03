/******************************************************************************
* Compilation: javac StackWithMinMax.java
* Aikaterini Kentroti
******************************************************************************/

/**
 *  The implementation of this data type is an extension of the class Stack.java, which represents a classic last-in-first-out (LIFO) stack 
 *  of generic items, presented in the book Algorithms by the authors Robert Sedgewick and Kevin Wyne. StackWithMinMax supports the stack operations (pop and push) and 
 *  also returns the maximum element and minimum element.
 *  
 *  @param <Item> the generic type of an item in StackWithMinMax
 */
import java.util.NoSuchElementException;


public class StackWithMinMax<Item extends Comparable<Item>> {
	    private Node<Item> first;     // top of stack
	    private int n;                // size of the stack

	    // helper linked list class
	    private static class Node<Item> {
	        private Item item;
	        private Item max;
	        private Item min;
	        private Node<Item> next;
	    }

	    /**
	     * Initializes an empty stack.
	     */
	    public StackWithMinMax() {
	        first = null;
	        n = 0;
	    }
	    
	    /**
	     * Returns true if this stack is empty.
	     *
	     * @return true if this stack is empty; false otherwise
	     */
	    public boolean isEmpty() {
	    	return n==0;
	    }
	    
	    /**
	     * Returns the number of items in this stack.
	     *
	     * @return the number of items in this stack
	     */
	    public int size() {
	        return n;
	    }

	    /**
	     * Adds the item to this stack.
	     *
	     * @param  item the item to add
	     */
	    public void push(Item item) {
	        Node<Item> oldfirst = first;
	        first = new Node<Item>();
	        first.item = item;
	        first.next = oldfirst;
	        if (isEmpty()) {
	        	
	        	first.min=item;
	        	first.max=item;
	        }else {
	        	
	        	if (first.item.compareTo(oldfirst.min)<=0) {  //if the item of the new node is less or equal to the minimum of the previous node, it is the new minimum 
	        		first.min=first.item;
	        	} else {
	        		first.min=oldfirst.min;                   //otherwise the new minimum item is the minimum of the previous node
	        	}
	        	
	        	if (first.item.compareTo(oldfirst.max)>=0) {  //same logic applies for the maximum item
	        		first.max=first.item;
	        	} else {
	        		first.max=oldfirst.max;	        		
	        	}
	        }
	        
	        n++;
	    }
	    
	    /**
	     * Removes and returns the item most recently added to this stack.
	     *
	     * @return the item most recently added
	     * @throws NoSuchElementException if this stack is empty
	     */
	    public Item pop() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	        Item item = first.item;// save item to return
	        first = first.next;            // delete first node
	        n--;
	        return item;                   // return the saved item
	    }


	
	    public Item peek() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow"); //Returns (but does not remove) the item most recently added to this stack.
	        return first.item;
	    }
	    
	    public Item min() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");   //Returns (but does not remove) the minimum item of this stack.
	        return first.min;
	    }
	    
	    public Item max() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");   //Returns (but does not remove) the maximum item of this stack
	        return first.max;
	    }
	    
	    
	    
	    


}
