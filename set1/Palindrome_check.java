package set1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Palindrome_check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="madam";
		
		if(IntStream.range(0, str.length()/2).allMatch(i->str.charAt(i)==str.charAt(str.length()-i-1)))
			System.out.println("Palindrome");
		else
			System.out.println("Not a Palindrome");

	}

}
