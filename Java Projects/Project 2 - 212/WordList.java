
public abstract class WordList {
	protected WordNode first;
	protected WordNode last;
	protected int length;

	public WordList() {

		/** First node in linked list - dummy node */
		// private WordNode
		first = new WordNode(null);

		/** Last node in linked list */
		// private WordNode
		last = first;

		/** Number of data items in the list. */
		// private int
		length = 0;
	} // default constructor to create new WordList with dummy node

	public void append(Word d) {
		// TODO Code here for append
		// Step 1: Create the new node with data d
		WordNode newNode = new WordNode(d); // use the constructor to create a new node
		// Step 2: make last point to new node
		last.next = newNode; // no need to say newNode.next = null bc the constructor already does that
		// Step 3: Check the update
		last = newNode; // setting the "tag" of the link list, the "last", to newNode
		length++;
		// Step4: check if this works for an empty linked list
		// if you test it, it does work for an empty linked list

	} // method append(String)

	public String toString() {
		WordNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data + "\n"; // i created a toString in Word, but otherwise I could just write p.data.data
											// and it'll convert it to a String type
			p = p.next;
		}
		return returnString;
	} // toString method

}
