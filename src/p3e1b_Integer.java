/******************************************************************************
* Compilation: javac p3e1b_Integer.java
* Execution: java p3e1b_Integer < in-p3e1b_integer.txt
* Dependencies: StdIn.java StdOut.java StackWithMinMax.java 
* Data files: in-p3e1b_integer.txt
*Aikaterini Kentroti
******************************************************************************/

public class p3e1b_Integer {
	
	public static void main(String[] args) {
		
		//a StackWithMinMax of integers
        StackWithMinMax<Integer> myStack = new StackWithMinMax<Integer>();
        
        while (!StdIn.isEmpty()) {
            Integer item = StdIn.readInt();
                myStack.push(item);
                StdOut.print("\nTop element: "  + item+" ");                
                StdOut.print("min: " + myStack.min()+" ");
                StdOut.print("max: " + myStack.max()+" ");
                StdOut.print("size=" + myStack.size()+" ");               
        }
        
        StdOut.println("\n"+"\nPopping each element of the stack");
        
        while (!myStack.isEmpty()) {
        	
        	StdOut.print("\nTop element: "  + myStack.peek()+ " ");
            StdOut.print("min: " + myStack.min()+" ");
            StdOut.print("max: " + myStack.max()+" ");
            StdOut.print("size=" + myStack.size()+" ");    
        	StdOut.print("\nPoped element: "+myStack.pop() + " ");        	
        }
        //StdOut.println("\nmyStack size: " + myStack.size());
    }

}
