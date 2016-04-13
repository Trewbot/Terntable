package pc4;
import java.io.*;
import java.util.Scanner;

public class FastGrowing {
	public static long[] solved;
	public static void main(String[] args) throws FileNotFoundException{
		Scanner read = new Scanner(new FileInputStream("fast.dat"));
		PrintWriter write = new PrintWriter(new FileOutputStream("fast-output.dat"));
		int in;
		while(read.hasNext() && (in = read.nextInt()) > 0){
			solved = new long[in + 1];
			for(int i = 0; i < solved.length; i++) solved[i] = -1;
			write.println("Fast(" + in + ") = " + fast(in));
		}
		read.close();
		write.close();
	}
	public static long fast(int n){
		if(solved[n] > 0) return solved[n];
		long ret;
		if(n >= 0 && n <= 2) ret = n;
		else ret = fast(n-3) + fast(n-2) + fast(n-1) + fast(n/2) + fast(n/3) + fast(n/4);
		solved[n] = ret;
		return ret;
	}
}
