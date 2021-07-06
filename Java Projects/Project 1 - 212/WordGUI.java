
import java.awt.GridLayout;
import javax.swing.*;

public class WordGUI {

	public static void createAndShowGUI(String[] a1, String[] a2, String[] a3) {
		// Create and set up the window.
		JFrame frame = new JFrame("Paragraph of sorted words");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);// width, height);
		frame.setLocation(200, 200);// x, y);
		frame.setLayout(new GridLayout(1, 3));

		// setting the three text areas
		JTextArea textArea1 = new JTextArea(15, 20);
		textArea1.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		frame.getContentPane().add(scrollPane1);

		JTextArea textArea2 = new JTextArea(15, 20);
		textArea2.setEditable(false);
		JScrollPane scrollPane2 = new JScrollPane(textArea2);
		frame.getContentPane().add(scrollPane2);

		JTextArea textArea3 = new JTextArea(15, 20);
		textArea3.setEditable(false);
		JScrollPane scrollPane3 = new JScrollPane(textArea3);
		frame.getContentPane().add(scrollPane3);

		// Giving the titles of each column

		textArea1.setText("All the words will print here: \n");
		textArea2.setText("All the valid words will print here: \n");
		textArea3.setText("All the nonvalid words will print here: \n");

		// now appending all the arrays to the text areas
		for (int v = 0; v < a1.length; v++) {
			textArea1.append(a1[v] + "\n");
		}

		for (int v = 0; a2[v] != null; v++) {
			textArea2.append(a2[v] + "\n");
		}

		for (int v = 0; a3[v] != null; v++) {
			textArea3.append(a3[v] + "\n");
		}

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

}
