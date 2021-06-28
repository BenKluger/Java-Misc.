import javax.swing.JOptionPane;

/**
 * 
 * @author Ben Kluger
 * @since 09/16/2020
 * @version 1
 * @description program that counts the amount of upper and lowerCase e's in a
 *              sentence
 *
 */
public class Project0 {
	public static void main(String[] arges) {
		while (true) { // true: keep going until user inputs "stop"
			int capital = 0, notCapital = 0; // initialize counters
			String inputWord = JOptionPane.showInputDialog(null, "Type in a sentence: ");
			for (int i = 0; i < inputWord.length(); i++) {

				if (inputWord.charAt(i) == 'e') // checks for e, then E to increment counter values
					notCapital += 1;
				if (inputWord.charAt(i) == 'E')
					capital += 1;
				if (inputWord.equalsIgnoreCase("STOP")) // exit code
					System.exit(0);
			}
			JOptionPane.showMessageDialog(null,
					"Number of lower case e's: " + notCapital + "\n" + "Number of upper case E's: " + capital);
		}

	}

}
