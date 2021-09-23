import javax.swing.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Iterator;

public class FileMenuHandler implements ActionListener {
	public static String line;
	public static StringTokenizer myTokens;
	public static TextFileInput myFile;

	JFrame jframe;

	public FileMenuHandler(JFrame jf) {
		jframe = jf;
	}

	public void fileOpen() { // the main code over here

		JFileChooser jfc = new JFileChooser("./");
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jfc.showOpenDialog(null);
		// File f = jfc.getSelectedFile(); //made f equal to the file, so that
		// TextFileInput can access it
		String input = jfc.getSelectedFile().getName();
		TextFileInput myFile = new TextFileInput(input);

		line = myFile.readLine();

		String paragraph = "";

		while (line != null) {
			paragraph += line + " ";
			line = myFile.readLine();
		}
		myTokens = new StringTokenizer(paragraph, ",. ");
		String word = "";
		while (myTokens.hasMoreTokens()) {
			word = myTokens.nextToken();
			Word w = new Word(word);
			Project4.unsortedWordList.add(w);
			Project4.wordMap.put(w, word);
		}
		// System.out.println("!!!"+Project4.wordMap);
	}

//	public void PrintTreeMap(TreeMap<Word, String> wordMap) { //DO I EVEN NEED THIS?
//		Iterator itr;
//		System.out.println("Retrieving all keys from the HashMap");
//
//		itr = Project4.wordMap.keySet().iterator();
//		while (itr.hasNext()) {
//			System.out.println(itr.next());
//		}
//
//		System.out.println("Retrieving all values from the HashMap");
//
//		itr = Project4.wordMap.entrySet().iterator();
//		while (itr.hasNext()) {
//			System.out.println(itr.next());
//		}
//	}

	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Open")) {
			fileOpen();
			// PrintTreeMap(Project4.wordMap);

			Project4.wordGUI.display(Project4.unsortedWordList, Project4.wordMap);

		} else if (menuName.equals("Quit"))
			System.exit(0);

	} // actionPerformed

}
