
public class Word implements Comparable<Word> {
	String data;

	// one argument constructor

	public Word(String word) {
		if (!(word.matches("[a-zA-Z]+"))) {

			throw new IllegalWordException();
		}

		this.data = word;
	}

	public String toString() { // toString so that the data is returned as a string.
		return this.data;
	}

	public int compareTo(Word other) {
		return (this.data.compareTo(other.data));
	}

}
