
public class Word {
	String data;

	// one argument constructor

	public Word(String word) {
		this.data = word;
	}

	public String toString() { // toString so that the data is returned as a string.
		return this.data;
	}

	 int compareTo(Word other) {
		return (this.data.compareTo(other.data));
	}

}
