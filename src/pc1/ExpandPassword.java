package pc1;
import java.io.*;
import java.util.*;
public class ExpandPassword{
	public static void main(String args[]) throws FileNotFoundException{
		Scanner in = new Scanner(new FileInputStream("prob1.dat"));
		PrintWriter out = new PrintWriter(new FileOutputStream("prob1-output.dat"));
		while(in.hasNext()){
			String original = in.next(),
				   newPassword = original;
			int length = in.nextInt(),
				base = 9;
			 while(newPassword.length() < length){
				newPassword = "";
				for(int i = 0; i < original.length(); i++){
					if(Character.isDigit(original.charAt(i))){
						newPassword += Integer.toString(Character.digit(original.charAt(i),10),base);
					}
					else newPassword += original.charAt(i);
				}
				if(base == 2) break;
				else base--;
			}
			int newLen = newPassword.length();
			if(base == 2)
				for(int i = 0; i < length - newLen; i++)
					newPassword += "@";
			out.println("Old password " + original + " expanded to length " + length + " is " + newPassword);
		}
		in.close();
		out.close();
	}
}