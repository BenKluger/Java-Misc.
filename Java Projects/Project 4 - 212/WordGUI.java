import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class WordGUI extends JFrame {

	public WordGUI(String title, int height, int width) {
		setTitle(title);
		setSize(height, width);
		setLocation(400, 200);
		createFileMenu();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	} // SSNGUI

	private void createFileMenu() {
		JMenuItem item;
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		FileMenuHandler fmh = new FileMenuHandler(this); // this refers to sampleGUI
		EditMenuHandler emh = new EditMenuHandler(this);

		item = new JMenuItem("Open"); // Open...
		item.addActionListener(fmh); // this is used to listen to the actions
		fileMenu.add(item);

		fileMenu.addSeparator(); // add a horizontal separator line

		item = new JMenuItem("Quit"); // Quit
		item.addActionListener(fmh);
		fileMenu.add(item);

		item = new JMenuItem("Search"); // Search...
		item.addActionListener(emh); // this is used to listen to the actions
		editMenu.add(item);

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

	} // createMenu

	public void display(ArrayList<Word> uwl, TreeMap<Word, String> wordMap) { // , SortedWordList swl
//		// Create and set up the window.
//		JFrame frame = new JFrame("Project 3");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(100, 100);// width, height);
//		frame.setLocation(200, 200);// x, y);
		// frame.
		setLayout(new GridLayout(1, 2));

		// setting the three text areas
		JTextArea textArea1 = new JTextArea(15, 20);
		textArea1.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		getContentPane().add(scrollPane1);

		JTextArea textArea2 = new JTextArea(15, 20);
		textArea2.setEditable(false);
		JScrollPane scrollPane2 = new JScrollPane(textArea2);
		getContentPane().add(scrollPane2);

		// Giving the titles of each column

		textArea1.setText("Unsorted List: \n");
		textArea2.setText("Word Map: \n");

		// call the uwl.toString()
		for (int i = 0; i < uwl.size(); i++)
			textArea1.append(uwl.get(i).toString() + "\n");
//		for (int i = 0; i < uwl.size(); i++)
//			System.out.println(uwl.get(i).toString());

		Iterator itr;
		itr = wordMap.keySet().iterator();
		while (itr.hasNext()) {
			textArea2.append(itr.next().toString() + "\n");
		}

		// Display the window.
		pack();
		setVisible(true);
	}

	// public void fillGUI()

} // SSNGUI
