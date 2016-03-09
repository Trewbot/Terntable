package pc1;
import java.io.*;
import java.util.*;
public class Shoemaker{
	public static void main(String args[]) throws FileNotFoundException{
		Scanner in = new Scanner(new FileInputStream("prob2.dat"));
		PrintWriter out = new PrintWriter(new FileOutputStream("prob2-output.dat"));
		int n = in.nextInt();
		in.nextLine();
		for(int i = 0; i < n; i++)
			jobBatchHandler(in,out);
		in.close();
		out.close();
	}
	public static void jobBatchHandler(Scanner in, PrintWriter out){
		int n = in.nextInt();
		int[][] jobs = new int[n][2];
		for(int i = 0; i < n; i++)
			jobs[i] = new int[]{in.nextInt(),in.nextInt()};
		
	}
}
