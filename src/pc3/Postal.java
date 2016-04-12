package pc3;
import java.io.*;
import java.util.Scanner;
public class Postal {
	public static int[] solved, in;
	public static void main(String args[]) throws FileNotFoundException{
		Scanner read = new Scanner(new FileInputStream("postal.dat"));
		PrintWriter out = new PrintWriter(new FileOutputStream("postal-output.dat"));
		in = new int[read.nextInt()];
		for(int i = 0; i < in.length; i++) in[i] = read.nextInt();
		int i = 0;
		while(read.hasNext()){
			int to = read.nextInt();
			if(to == 0) break;
			solved = new int[to + 1];
			for(int j = 0; j < solved.length; j++) solved[j] = -1;
			out.println("Case " + (i+1) + ": The postage amount " + to + " can be made using " + minStamps(to) + " stamp(s).");
			i++;
		}
		read.close();
		out.close();
	}
	public static int minStamps(int n){
		if(n == 0) return 0;
		if(solved[n] >= 0) return solved[n];
		for(int i = 0; i < in.length; i++) if((double)n / (double)in[i] == 1) return 1;
		int[] arr = new int[in.length];
		for(int i = 0; i < arr.length; i++) arr[i] = n - in[i] > 0 ? minStamps(n - in[i]) + 1 : n;
		int min = n;
		for(int i = 0; i < arr.length; i++) min = arr[i] < min ? arr[i] : min;
		solved[n] = min;
		return min;
	}
}