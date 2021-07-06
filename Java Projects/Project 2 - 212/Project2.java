import java.util.StringTokenizer;

/**
 * 
 * @author Ben Kluger
 * @date 11/01/2020
 * @description This class turns an input text file into seperate tokens and
 *              sets them as word objects. Then, it adds the words to an
 *              unsorted word list, and then uses a compareTo method to add each
 *              word to the correct node placement in a sorted word list. Then,
 *              it displays both of those lists in a GUI
 *
 */

public class Project2 {
	public static TextFileInput myFile;
	public static StringTokenizer myTokens;
	public static String line;
	public static UnsortedWordList uwl;
	public static SortedWordList swl;

	public static void main(String[] args) {
		myFile = new TextFileInput(args[0]);
		line = myFile.readLine();

		String paragraph = "";

		while (line != null) {
			paragraph += line + " ";
			line = myFile.readLine();
		}

		uwl = new UnsortedWordList();
		swl = new SortedWordList();

		myTokens = new StringTokenizer(paragraph); // the delimeter is space //is that automatic?
		while (myTokens.hasMoreTokens()) {
			String word = myTokens.nextToken();
			Word w = new Word(word);
			uwl.add(w);
			swl.add(w);

		}

		 //System.out.println(swl.toString()); //my test before I implemented the GUI

		// WordGUI gui = new WordGUI(); NOT NEEDED BECAUSE GUI IS STATIC METHOD. If you
		// don't
		// put in static, you must create an object first, bc it's an instance method
		WordGUI.display(uwl, swl);

	}

}
