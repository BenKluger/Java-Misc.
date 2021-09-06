import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

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
			try {
				word = myTokens.nextToken();
				Word w = new Word(word);
				Project3.unsortedWordList.add(w);
				Project3.sortedWordList.add(w);
			} catch (IllegalWordException e) {
				Project3.erroneousWordList.add(word);
			}
		}
		Collections.sort(Project3.sortedWordList);
	}

	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Open")) {
			fileOpen();
//			for (int i = 0; i < Project3.unsortedWordList.size(); i++)
//	               System.out.println(Project3.unsortedWordList.get(i).toString() + "\n"); //testing area
			for (int i = 0; i < Project3.erroneousWordList.size(); i++)
				System.out.println(Project3.erroneousWordList.get(i).toString() + "\n");
			Project3.wordGUI.display(Project3.unsortedWordList, Project3.sortedWordList, Project3.erroneousWordList);

		} else if (menuName.equals("Quit"))
			System.exit(0);

	} // actionPerformed

}
