import java.awt.GridLayout;
import javax.swing.*;

public class WordGUI {

	public static void display(UnsortedWordList uwl, SortedWordList swl) { // , SortedWordList swl
		// Create and set up the window.
		JFrame frame = new JFrame("Paragraph of input.txt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);// width, height);
		frame.setLocation(200, 200);// x, y);
		frame.setLayout(new GridLayout(1, 2));

		// setting the two text areas
		JTextArea textArea1 = new JTextArea(15, 20);
		textArea1.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		frame.getContentPane().add(scrollPane1);

		JTextArea textArea2 = new JTextArea(15, 20);
		textArea2.setEditable(false);
		JScrollPane scrollPane2 = new JScrollPane(textArea2);
		frame.getContentPane().add(scrollPane2);

		// Giving the titles of each column

		textArea1.setText("Unsorted List: \n");
		textArea2.setText("Sorted List: \n");

		// call the uwl.toString()
		textArea1.append(uwl.toString());
		textArea2.append(swl.toString());

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

}

//	public WordGUI() {
//	//setup GUI
//	//layout, gridlayout (1,2);	
//	}
//	
//
//	public void display(UnsortedWordList uwl, SortedWordList swl) {
//		TextArea t1 = new TextArea();
//		//call the uwl.toString()
//		t1.append(uwl.toString());
//		
//		//do the same for swl
//	}
//		
//	}
