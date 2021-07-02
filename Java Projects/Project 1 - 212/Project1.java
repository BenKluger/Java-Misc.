import java.util.StringTokenizer;

/**
 * 
 * @author Ben Kluger
 * @date 10/06/2020
 * @description This class takes a file name as an argument, then outputs stores
 *              the text in that file in an array. After that, it takes the
 *              valid words (words that contain only letters a-z or A-Z) and
 *              stores them in a second array, and stores the "nonvalid" words
 *              in a third array. Then, it calls the WordGUI class to output
 *              those three arrays in a readable format.
 *
 */
public class Project1 {

	public static TextFileInput myFile;
	public static StringTokenizer myTokens;
	public static String line;
	public static String[] allWords; // array with every token
	public static String[] goodWords; // array with only valid words
	public static String[] badWords; // array with non-valid words

	public static void main(String args[]) {

		myFile = new TextFileInput(args[0]);
		line = myFile.readLine();
		String s = "";

		while (line != null) {
			s += line + " ";
			line = myFile.readLine();
		}

		System.out.println("The input file text is: " + s);

		myTokens = new StringTokenizer(s, ", ."); // tests s and separates it into tokens
		System.out.println("There are " + myTokens.countTokens() + " tokens in the input file.");

		// section to initialize a1, a2, a3

		allWords = new String[myTokens.countTokens()]; // makes the array1 size = to the amount of tokens in myTokens.
														// Do the same for a2 & a3, and then cut off the for loop in the
														// GUI when it hits null/the end of the array
		goodWords = new String[myTokens.countTokens()];// initializing the sizes
		badWords = new String[myTokens.countTokens()];

		int i = 0; // setting up the array index counters for the arrays
		int g = 0;
		int b = 0;

		String k; // my string to input the tokens to the arrays
		while (myTokens.hasMoreTokens()) {
			k = myTokens.nextToken();
			allWords[i++] = k; // filling up a1

			if (k.matches("[a-zA-Z]+"))
				goodWords[g++] = k;
			else
				badWords[b++] = k;
		}

		System.out.print("The array a1 contains the tokens as follows: ");
		for (int j = 0; j < allWords.length; j++)
			System.out.print(allWords[j] + " ");

		System.out.println("\na2: ");
		for (int j = 0; j < g; j++)
			System.out.print(goodWords[j] + " ");
		System.out.println("\na3: ");
		for (int j = 0; j < b; j++)
			System.out.print(badWords[j] + " ");

		System.out.println("\nThe sorted a2 is: ");
		selectionSort(goodWords, g);
		for (int j = 0; j < g; j++)
			System.out.print(goodWords[j] + " ");

		WordGUI.createAndShowGUI(allWords, goodWords, badWords);

	} // main

	// Found this code online. The rest is written by me
	// Sorts an array of strings
	static void selectionSort(String arr[], int length) {
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < length - 1; i++) {

			// Find the minimum element in unsorted array
			int min_index = i;
			String minStr = arr[i];
			for (int j = i + 1; j < length; j++) {

				/*
				 * compareTo() will return a -ve value, if string1 (arr[j]) is smaller than
				 * string2 (minStr)
				 */
				// If arr[j] is smaller than minStr

				if (arr[j].compareTo(minStr) < 0) {
					// Make arr[j] as minStr and update min_idx
					minStr = arr[j];
					min_index = j;
				}
			}

			// Swapping the minimum element
			// found with the first element.
			if (min_index != i) {
				String temp = arr[min_index];
				arr[min_index] = arr[i];
				arr[i] = temp;
			}
		}
	}

}
