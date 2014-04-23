import java.util.Iterator;


public class myTest {

	public static void main(String[] args) {
		
		Heap tree = new Heap(new MinHeap());
		
		tree.add("cc");
		//System.out.println(tree.toString());
		tree.add("dd");
		//System.out.println(tree.toString());
		tree.add("aa");
		//System.out.println(tree.toString());
		tree.add("pp");
		//System.out.println(tree.toString());
		tree.add("bb");
		//System.out.println(tree.toString());
		tree.add("ee");		
		//System.out.println(tree.toString());
		tree.add("ff");
		//System.out.println(tree.toString());
		tree.add("rr");
		//System.out.println(tree.toString());
		//MinHeapIterator i = new MinHeapIterator();
		Iterator<?> iter = tree.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
