
/*
 * class MinHeap implements a concept of min-heap which is a tree structure
 * with any node in the tree, it has a value that is less than 
 * all the nodes in either the left or right sub-heaps of the node. 
 */

public class MinHeap implements HeapStrategy {
	public int size;
	public int getSize() {
		return size;
	}

	MinHeap()
	{
		size = 0;
	}

	// add method compares current value in heap and the new value
	// and inserts it into heap accordingly
	public Node add(Node root,String value) {
		if (root==null) {
			root = new Node(value);	
		} else {// comparing current value in heap and the new value
			int compare = (root.getData()).compareToIgnoreCase(value);
			// if the new value is greater than current value then
			// compareToIgnoreCase function will return negative value
			// calling insertLargerValue method
			// Node newNode = new Node(value);
			if (compare < 0) {
				root.addLargerValue(value);
			}
			// if the new value is less than current value then
			// compareToIgnoreCase function will return positive value
			// calling insertSmallerValue method
			else if (compare > 0) {
				root.addSmallerValue(value);
			}			
		}
		size++;
		root.computeHeight();
		return root;
	}
}
