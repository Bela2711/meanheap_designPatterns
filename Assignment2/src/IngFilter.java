import java.util.Iterator;
import java.util.Stack;

//filter for words ending with "ing" for any collection
//iterates through the heap, uses preorder traversal
public class IngFilter {
	Iterator<?> iterator;
	private Stack<String> collection;
	//private LinkedList<String> collection;

	IngFilter(Iterator<?> iteratorObject) {
		iterator = (HeapIterator<?>) iteratorObject;
		collection = new Stack<String>();
		while (iterator.hasNext()) {
			String data = (String) iterator.next();
			if (data.endsWith("ing")) {
				collection.push(data);
				break;
			}
		}
	}

	//returns if there is next element or not in the collection which ends with "ing"
	public boolean hasNext() {
		return !collection.isEmpty();
	}

	//returns next value in the collection
	public String next() {
		String value = "";
		if (hasNext()) {
			value = collection.pop();
			while (iterator.hasNext()) {
				String data = (String) iterator.next();
				if (data.endsWith("ing")) {
					collection.push(data);
					break;
				}
			}
		}
		return value;
	}

	public void remove() {

	}

}
