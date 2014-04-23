import java.util.Iterator;
import java.util.Stack;

//iterator class to iterate through the heap
//uses preorder traversal
public class HeapIterator<E> implements Iterator<Object> {

	//stores nodes to traverse
	private Stack<Node> collection;

	HeapIterator(Node root) {
		collection = new Stack<Node>();
		root.pushNode(collection);
	}

	//returns if there is next element or not
	@Override
	public boolean hasNext() {
		return !collection.isEmpty();
	}

	//returns next value in the heap
	@Override
	public String next() {
		if (this.hasNext()) {
			Node poppedNode = collection.pop();
			poppedNode.getRight().pushNode(collection);
			poppedNode.getLeft().pushNode(collection);
			return poppedNode.getData();
		}

		return null;
	}

	@Override
	public void remove() {

	}

}
