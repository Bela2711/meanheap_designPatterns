import java.util.Iterator;
import java.util.PriorityQueue;

public class Heap extends PriorityQueue<Object> {

	// pointer to a root of a hepa
	private Node root;
	// strategy to be implemented (min or max)
	private HeapStrategy strategy;

	Heap() {
		root = null;
		strategy = null;
	}

	Heap(HeapStrategy strategyType) {
		root = null;
		strategy = strategyType;
	}

	public int size() {
		return strategy.getSize();
	}

	public HeapIterator<?> iterator() {
		return new HeapIterator<Object>(root);
	}

	
	// this method prints the values in minheap in preorder and also returns
	// concatenated string of the preorder of a minheap
	// first prints value in a root
	// then recursively traverses left subtree and then right subtree
	public String toString() {
		String preorderString = "";
		if (root != null)
			return (root.preorder(preorderString));
		else
			return preorderString;
	}


	// converts heap to an array
	public <T> T[] toArray(T[] array) {
		int i = 0;
		Iterator<?> iter = iterator();
		while (iter.hasNext()) {
			array[i] = (T) iter.next();
			i++;
		}
		return array;
	}

	// add method compares current value in heap and the new value
	// and inserts it into heap accordingly
	public void add(String value) {
		root = strategy.add(root, value);
	}
}
