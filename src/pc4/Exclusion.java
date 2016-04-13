package pc4;
import java.io.*;
import java.util.Scanner;
public class Exclusion {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner read = new Scanner(new FileInputStream("exclusion.dat"));
		PrintWriter write = new PrintWriter(new FileOutputStream("exclusion-output.dat"));
		int len, it = 1;
		while(read.hasNext() && (len = read.nextInt()) > 0){
			String[] words = new String[len];
			for(int i = 0; i < len; i++) words[i] = read.next();
			write.println("Case " + it + ": You only need to remove " + leastExcludedSort(words) + " words(s)!");
			it++;
		}
		read.close();
		write.close();
	}
	public static int leastExcludedSort(String[] words){
		if(words.length <= 1 || isSorted(words)) return 0;
		int[] lens = new int[words.length];
		for(int i = 0; i < words.length; i++){
			String[] words2 = new String[words.length-1];
			for(int j = 0; j < words.length; j++) if(j != i) words2[j < i ? j : j - 1] = words[j];
			lens[i] = leastExcludedSort(words2);
		}
		int ret = words.length;
		for(int i = 0; i < lens.length; i++) ret = Math.min(ret, lens[i]);
		return ++ret;
	}
	public static boolean isSorted(String[] words){
		int c = 0;
		for(int i = 0; i < words.length; i++)
			if(Character.valueOf(words[i].charAt(0)) > c) c = Character.valueOf(words[i].charAt(0));
			else return false;
		return true;
	}
}
