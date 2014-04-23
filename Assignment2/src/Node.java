import java.util.Stack;
import java.util.Vector;

/*
 * This class defines a node of a tree which contains a 
 * string data and pointers to the left and right subtrees
 */

public class Node {
	private String data;
	private Node left;
	private Node right;
	private int height;

	Node() {
	}

	Node(String value) {
		left = new NullNode();
		right = new NullNode();
		data = value;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getLeft() {
		if (left == null) {
			return Node.newNull();
		} else {
			return left;
		}
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		if (right == null) {
			return Node.newNull();
		} else {
			return right;
		}
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isNull() {
		return false;
	}

	public static Node newNull() {
		return new NullNode();
	}

	// exchanges data between two nodes
	// exchanges data between two nodes
	private String exchangeData(String value) {

		String data = this.getData();
		this.setData(value);
		return data;
	}

	private void insert(String value) {
		int compare = (getData()).compareToIgnoreCase(value);
		// if the new value is greater than current value then
		// compareToIgnoreCase function will return negative value
		// calling insertLargerValue method
		if (compare < 0) {
			addLargerValue(value);
		}
		// if the new value is less than current value then
		// compareToIgnoreCase function will return positive value
		// calling insertSmallerValue method
		else if (compare > 0) {
			addSmallerValue(value);
		}

	}

	private void insertForMax(String value) {
		int compare = (getData()).compareToIgnoreCase(value);
		// if the new value is greater than current value then
		// compareToIgnoreCase function will return negative value
		// calling insertLargerValue method
		if (compare < 0) {
			addLargerValueForMax(value);
		}
		// if the new value is less than current value then
		// compareToIgnoreCase function will return positive value
		// calling insertSmallerValue method
		else if (compare > 0) {
			addSmallerValueForMax(value);
		}

	}

	// addToLeft inserts into min-heap if newNode data is smaller than
	// current data
	public void addSmallerValue(String value) {
		// exchange the values of the new node and the current node as
		// newNode data is less than current node
		String newValue = exchangeData(value);
		// if both left and right of a current node(rootNode) are not null
		// then check the heights of a subtrees
		if (getLeft().isNull() && getRight().isNull()) {

			Node newNode = new Node(newValue);
			insertAfterALeafNode(newNode);
		}

		// if left or right or both of a current node are null
		else {
			int heightOfLeftSubHeap = getLeft().getHeight();
			int heightOfRightSubHeap = getRight().getHeight();
			// if height of a right subtree is less then insert the new node in
			// right subtree
			if (heightOfLeftSubHeap > heightOfRightSubHeap) {
				if (this.getRight().isNull()) {
					Node newNode = new Node(newValue);
					insertAfterALeafNode(newNode);
				} else
					this.getRight().insert(newValue);
			}
			// if height of a left subtree is less then insert the new node in
			// left subtree
			else {
				if (this.getLeft().isNull()) {
					Node newNode = new Node(value);
					insertAfterALeafNode(newNode);
				} else
					this.getLeft().insert(newValue);
			}
		}
	}

	// insertLargerValue inserts into min-heap if newNode data is greater than
	// current data
	public void addLargerValue(String value) {

		// if both left and right of a current node(rootNode) are not null
		// then check the heights of a subtrees
		if (getLeft().isNull() && getRight().isNull()) {
			Node newNode = new Node(value);
			insertAfterALeafNode(newNode);
		}
		// if left or right or both of a current node are null
		else {
			int heightOfLeftSubHeap = getLeft().getHeight();
			int heightOfRightSubHeap = getRight().getHeight();
			// if height of a right subtree is less then add the new node in
			// right subtree
			if (heightOfLeftSubHeap > heightOfRightSubHeap) {
				if (this.getRight().isNull()) {
					Node newNode = new Node(value);
					insertAfterALeafNode(newNode);
				} else
					this.getRight().insert(value);
			}

			// if height of a left subtree is less then add the new node in
			// left subtree
			else {
				if (this.getLeft().isNull()) {
					Node newNode = new Node(value);
					insertAfterALeafNode(newNode);
				} else
					this.getLeft().insert(value);
			}

		}
	}

	// addToLeft inserts into max-heap if newNode data is smaller than
	// current data
	public void addSmallerValueForMax(String value) {
		// if both left and right of a current node(rootNode) are not null
		// then check the heights of a subtrees
		if (getLeft().isNull() && getRight().isNull()) {
			Node newNode = new Node(value);
			insertAfterALeafNode(newNode);
		}
		// if left or right or both of a current node are null
		else {
			int heightOfLeftSubHeap = getLeft().getHeight();
			int heightOfRightSubHeap = getRight().getHeight();
			// if height of a right subtree is less then add the new node in
			// right subtree
			if (heightOfLeftSubHeap > heightOfRightSubHeap) {
				if (this.getRight().isNull()) {
					Node newNode = new Node(value);
					insertAfterALeafNode(newNode);
				} else
					this.getRight().insertForMax(value);
			}

			// if height of a left subtree is less then add the new node in
			// left subtree
			else {
				if (this.getLeft().isNull()) {
					Node newNode = new Node(value);
					insertAfterALeafNode(newNode);
				} else
					this.getLeft().insertForMax(value);
			}

		}
	}

	// insertLargerValue inserts into max-heap if newNode data is greater than
	// current data
	public void addLargerValueForMax(String value) {

		// exchange the values of the new node and the current node as
		// newNode data is less than current node
		String newValue = exchangeData(value);
		// if both left and right of a current node(rootNode) are not null
		// then check the heights of a subtrees
		if (getLeft().isNull() && getRight().isNull()) {

			Node newNode = new Node(newValue);
			insertAfterALeafNode(newNode);
		}

		// if left or right or both of a current node are null
		else {
			int heightOfLeftSubHeap = getLeft().getHeight();
			int heightOfRightSubHeap = getRight().getHeight();
			// if height of a right subtree is less then insert the new node in
			// right subtree
			if (heightOfLeftSubHeap > heightOfRightSubHeap) {
				if (this.getRight().isNull()) {
					Node newNode = new Node(newValue);
					insertAfterALeafNode(newNode);
				} else
					this.getRight().insertForMax(newValue);
			}
			// if height of a left subtree is less then insert the new node in
			// left subtree
			else {
				if (this.getLeft().isNull()) {
					Node newNode = new Node(value);
					insertAfterALeafNode(newNode);
				} else
					this.getLeft().insertForMax(newValue);
			}
		}

	}

	public void insertAfterALeafNode(Node newNode) {
		// if left not null make right as a newNode
		if (this.getLeft().isNull()) {
			this.setLeft(newNode);
		}
		// else make left as a newNode
		else {
			this.setRight(newNode);
		}
	}

	// use of null object pattern
	public void computeHeight() {
		this.setHeight(height());
		// if (!this.getLeft().isNull())
		this.getLeft().computeHeight();
		// if (!this.getRight().isNull())
		this.getRight().computeHeight();

	}

	// finds height of a node in min-heap
	// use of null object pattern
	public int height() {
		int leftHeight = 0, rightHeight = 0;
		// if (!this.getLeft().isNull())
		leftHeight = this.getLeft().height();
		// if (!this.getRight().isNull())
		rightHeight = this.getRight().height();
		return 1 + Math.max(leftHeight, rightHeight);
		// }
	}

	// use of null object pattern
	public String preorder(String returnPreorder) {
		returnPreorder = returnPreorder.concat(this.getData());
		returnPreorder = this.getLeft().preorder(returnPreorder);
		returnPreorder = this.getRight().preorder(returnPreorder);

		return returnPreorder;
	}

	// use of null object pattern
	public int inorder(Vector<Node> collection, int size) {
		size = size + 1;
		size = this.getLeft().inorder(collection, size);
		collection.addElement(this);
		size = this.getRight().inorder(collection, size);
		return size;
	}

	void pushNode(Stack<Node> collection) {
		collection.push(this);
	}

}