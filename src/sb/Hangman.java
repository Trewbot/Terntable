package sb;
import java.io.*;
import java.util.*;
public class Hangman {
	public static void main(String args[]) throws FileNotFoundException{
		Scanner in = new Scanner(new FileInputStream("hangman-in.dat"));
		PrintWriter out = new PrintWriter(new FileOutputStream("hangman-out.dat"));
		String word;
		int[] letterCount = new int[26];
		int longestWordLength = 0;
		Map<Integer,String> words = new HashMap<Integer,String>();
		for(int i : letterCount) letterCount[i] = 0;
		while(in.hasNext() && !(word = in.nextLine().toLowerCase()).equals('*')){
			longestWordLength = Math.max(longestWordLength, word.length());
			words.put(word.length(), word);
			for(int i = 0; i < word.length(); i++)
				letterCount[word.charAt(i)]++;
		}
		for(int i = 0; i < longestWordLength; i++)
			
		in.close();
		out.close();
	}
}