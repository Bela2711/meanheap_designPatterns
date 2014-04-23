import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

//test class for class MinHeap
public class TestHeap {

	// Heap created by passing MaxHeap as strategy
	// implementation of strategy pattern
	@Test
	public void testAddAscending() {
		Heap tree = new Heap(new MaxHeap());
		tree.add("aa");
		tree.add("bb");
		tree.add("cc");
		tree.add("dd");
		tree.add("ee");
		assertEquals("eeccaaddbb", tree.toString());
	}

	// Heap created by passing MinHeap as strategy
	// implementation of strategy pattern
	@Test
	public void testAddDescending() {
		Heap tree = new Heap(new MinHeap());
		tree.add("ee");
		tree.add("dd");
		tree.add("cc");
		tree.add("bb");
		tree.add("aa");
		assertEquals("aacceebbdd", tree.toString());
	}

	// values inserted in random order
	// tests toString method of a Heap
	@Test
	public void testAdd() {
		Heap tree = new Heap(new MinHeap());
		tree.add("cc");
		tree.add("dd");
		tree.add("aa");
		tree.add("pp");
		tree.add("bb");
		tree.add("ee");
		tree.add("ff");
		tree.add("rr");
		assertEquals("aaddffppeebbccrr", tree.toString());
	}

	// iterator pattern and toArray method of Heap class
	@Test
	public void iterator() {
		Heap tree = new Heap(new MinHeap());
		String[] arrayOfValues = { "running", "dog", "trying", "cat",
				"beating", "hat", "zebra", "nothing" };
		for (String value : arrayOfValues) {
			tree.add(value);
		}
		String[] array = tree.toArray(new String[tree.size()]);
		int index = 0;
		Iterator<?> iterator = tree.iterator();
		while (iterator.hasNext()) {
			assertEquals(array[index], iterator.next());
			index++;
		}
	}
}