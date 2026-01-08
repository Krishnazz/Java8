package set1;

import java.util.Arrays;
import java.util.*;
public class Max3Min3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> al= Arrays.asList(1,2,5,3,8,6,3,7,9);
		al.stream().sorted().limit(3).forEach(System.out::println);
		System.out.println("---");
		al.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
	}

}
