package set1;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="Silent";
		String str2="listen";
		List<String>  a=Arrays.stream(str1.split("")).sorted().collect(Collectors.toList());
		List<String>  b=Arrays.stream(str1.split("")).sorted().collect(Collectors.toList());
		if(a.equals(b))
			System.out.println("YEs");
		else
			System.out.println("NO");
	}

}
