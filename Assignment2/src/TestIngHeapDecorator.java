import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class TestIngHeapDecorator {
	
//this test case tests 
	// 1. create IngHeapDecorator object
	// 2. adding values to that object
	// 3. converting that object into an array
	// 4. creating iterator for Heap
	// 5. creating IngFilter by passing iterator to it
	// 6. hasNext and next methods of IngFilter

@Test
public void add()
{
	Heap tree = new Heap(new MinHeap());
	int index = 0;
	String[] arrayOfValues = { "running", "dog", "trying", "cat",
			"beating", "hat", "zebra" ,"nothing"};
	for (String value : arrayOfValues) {
		tree.add(value);
	}
	IngHeapDecorator object = new IngHeapDecorator(tree);
	object.add("nothing");
	String[] array =object.toArray(new String[object.getSize()]);
	Iterator<?> iterator = tree.iterator();
	IngFilter ingFilterObject = new IngFilter(iterator);
	while (ingFilterObject.hasNext()) {
		assertEquals(array[index], ingFilterObject.next());
		index++;
	}
}

}
