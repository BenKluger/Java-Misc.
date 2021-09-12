import java.util.ArrayList;

/**
 * 
 * @author Ben Kluger
 * @date 11/20/2020
 * @description Allows the user to select an input text file. After that, a GUI
 *              displays the text file in three columns: First column: All the
 *              words in the file (excluding erroneous words). Second Column:
 *              Displays the first column in a sorted format. Third column:
 *              Displays the erroneous words. Select "Quit" to exit
 *
 */

public class Project3 {
	static WordGUI wordGUI;
	public static ArrayList<Word> unsortedWordList = new ArrayList<Word>();
	public static ArrayList<Word> sortedWordList = new ArrayList<Word>();
	public static ArrayList<String> erroneousWordList = new ArrayList<String>(); // change Word to String because it's
																					// not a valid Word

	public static void main(String[] args) {
		wordGUI = new WordGUI("My Word GUI", 500, 300);
//      for (int i = 0; i < unsortedWordList.size(); i++) { //this was a test
//    	  System.out.println(unsortedWordList);
	}
}
