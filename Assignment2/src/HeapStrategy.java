//Decides strategy for heap
//MinHeap and MaxHeap implement this interface
public interface HeapStrategy {
	public Node add(Node root, String value);
	public int getSize();
}
