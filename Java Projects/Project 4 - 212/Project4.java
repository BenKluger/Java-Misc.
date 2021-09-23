import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * 
 * @author Ben Kluger
 * @date 12/08/2020
 * @description Allows the user to select an input text file. After that, a GUI
 *              displays the text file in two columns: First column: All the
 *              words in the file. Second Column: all the input file words,
 *              except sorted via a tree map data structure. Users can also
 *              select the Edit tab, then Search, to search if a certain key is
 *              in the tree map. Furthermore, users can hit File > Quit, or "x
 *              out" to exit the program.
 *
 */

public class Project4 {
	static WordGUI wordGUI;
	public static ArrayList<Word> unsortedWordList = new ArrayList<Word>();
	public static TreeMap<Word, String> wordMap = new TreeMap<Word, String>(); // not a valid Word

	public static void main(String[] args) {
		wordGUI = new WordGUI("My Word GUI", 500, 300);
//      for (int i = 0; i < unsortedWordList.size(); i++) { //this was a test
//    	  System.out.println(unsortedWordList);
	}
}
