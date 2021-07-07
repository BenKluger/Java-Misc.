
public class SortedWordList extends WordList {

	// default constructor
	public SortedWordList() { //has super(); inside automatically
	}

	void add(Word w) { // insert
		WordNode newNode = new WordNode(w);
		WordNode p = first;

		while (p.next != null && ((newNode.data.compareTo(p.next.data)) > 0)) {

			p = p.next; // this doesn't actually add anything new to the linked list, it just
			// iterates THROUGH the list, so that when you arrive at the right spot, the
			// code
			// outside the loop executes, and adds the new node in
		}

		newNode.next = p.next;
		p.next = newNode;

		// Word.compareTo(w); //method 1
		// Word.toString().compareTo(); method 2
		// if newNode is bigger than p.next then move to the next. p = p.next
		// if newNode is smaller than p.next, then newNode.next = p.next; then p.next =
		// newNode
		// newNode.data < p.next.data ?
	}

}
