import java.util.Stack;
import java.util.Vector;

//import java.util.Vector;


public class NullNode extends Node{
	NullNode()
	{
	}
	public void computeHeight()
	{		
	}
	public int height() {
		return 0;
	}
	public String preorder(String returnPreorder) {
		return returnPreorder;
	}
	public String preorderOfIngStrings(String endsWithValue,String returnPreorder)
	{
		return returnPreorder;
	}
	public int inorder(Vector<Node> collection, int size) {
		return size;
	}
	public boolean isNull() {
		return true;
	}
	void pushNode(Stack<Node> collection)
	{
	}
}
