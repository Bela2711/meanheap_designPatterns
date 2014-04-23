import java.util.Iterator;

//decorator for a Heap class
public class IngHeapDecorator {

	private Heap heap;
	public int size;

	public int getSize() {
		return size;
	}

	IngHeapDecorator(Heap heaObject) {
		heap = heaObject;
		size = 0;
		Iterator<?> iterator = heap.iterator();
		IngFilter ingFilterObject = new IngFilter(iterator);
		while (ingFilterObject.hasNext()) {	
			ingFilterObject.next();
			size++;
		}
	}

	public void add(String value) {
		heap.add(value);
		size++;
	}

	public String toString() {
		String preorder = "";
		return concatString(preorder);
	}
	
	public <T> T[] toArray(T[] array) {
		int i = 0;
		Iterator<?> iterator = heap.iterator();
		IngFilter ingFilterObject = new IngFilter(iterator);
		while (ingFilterObject.hasNext()) {	
			array[i] = (T) ingFilterObject.next();
			i++;
		}
		return array;
	}
	
	private String concatString(String preorder) {
		Iterator<?> iterator = heap.iterator();
		IngFilter ingFilterObject = new IngFilter(iterator);
		while (ingFilterObject.hasNext())
			preorder = preorder.concat(ingFilterObject.next());
		return preorder;
	}
}
