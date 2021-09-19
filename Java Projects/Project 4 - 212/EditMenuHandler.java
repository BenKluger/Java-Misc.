import javax.swing.*;
import javax.xml.crypto.Data;

import java.awt.event.*;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Iterator;

public class EditMenuHandler implements ActionListener {

	JFrame jframe;

	public EditMenuHandler(JFrame jf) {
		jframe = jf;
	}

	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Search")) {
			mapSearch();
		}
	}

	private void mapSearch() {
		String wordInput = JOptionPane.showInputDialog("Enter a word to search for: ");
		//Word word = new Word(wordInput);
		if (Project4.wordMap.containsKey(wordInput))
			JOptionPane.showMessageDialog(null, "The word \"" + wordInput + "\" is in the treemap");
		else
			JOptionPane.showMessageDialog(null, "The word \"" + wordInput + "\" is not in the treemap");
	}

}
