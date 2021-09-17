import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class WordGUI extends JFrame {
      
   public WordGUI(String title, int height, int width) {
	    setTitle(title);
	    setSize(height,width);
       setLocation  (400,200);
	    createFileMenu();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
   } //SSNGUI

   private void createFileMenu( ) {
      JMenuItem   item;
      JMenuBar    menuBar  = new JMenuBar();
      JMenu       fileMenu = new JMenu("File");
      FileMenuHandler fmh  = new FileMenuHandler(this); //this refers to sampleGUI

      
      item = new JMenuItem("Open");    //Open...
      item.addActionListener( fmh ); //this is used to listen to the actions
      fileMenu.add( item );

      fileMenu.addSeparator();           //add a horizontal separator line
    
      item = new JMenuItem("Quit");       //Quit
      item.addActionListener( fmh );
      fileMenu.add( item );
      

      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
      
      
    
   } //createMenu
   
   public void display(ArrayList<Word> uwl, ArrayList<Word> swl, ArrayList<String> ewl) { // , SortedWordList swl
//		// Create and set up the window.
//		JFrame frame = new JFrame("Project 3");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(100, 100);// width, height);
//		frame.setLocation(200, 200);// x, y);
		//frame.
		setLayout(new GridLayout(1, 3));

		// setting the three text areas
		JTextArea textArea1 = new JTextArea(15, 20);
		textArea1.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		getContentPane().add(scrollPane1);

		JTextArea textArea2 = new JTextArea(15, 20);
		textArea2.setEditable(false);
		JScrollPane scrollPane2 = new JScrollPane(textArea2);
		getContentPane().add(scrollPane2);
		
		JTextArea textArea3 = new JTextArea(15, 20);
		textArea1.setEditable(false);
		JScrollPane scrollPane3 = new JScrollPane(textArea3);
		getContentPane().add(scrollPane3);

		// Giving the titles of each column

		textArea1.setText("Unsorted List: \n");
		textArea2.setText("Sorted List: \n");
		textArea3.setText("Erroneous List: \n");

		// call the uwl.toString()
		for (int i = 0; i < uwl.size(); i++)
			textArea1.append(uwl.get(i).toString() + "\n");
		for (int i = 0; i < swl.size(); i++)
			textArea2.append(swl.get(i).toString() + "\n");
		for (int i = 0; i < ewl.size(); i++)
			textArea3.append((ewl.get(i))+ "\n"); //System.lineSeparator());
		
		for (int i = 0; i < uwl.size(); i++)
			System.out.println(uwl.get(i).toString());
		for (int i = 0; i < swl.size(); i++)
			System.out.println(swl.get(i).toString());
		for (int i = 0; i < ewl.size(); i++)
			System.out.println(ewl.get(i) + System.lineSeparator());		
//		
//		for (int i = 0; i < uwl.size(); i++)
//			textArea1.append(uwl.get(i).data);
			//this.unsortedWordList.append(uwl.get(i).data);

		// Display the window.
		pack();
		setVisible(true);
	}
   
  //public void fillGUI()

} //SSNGUI
