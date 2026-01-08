package set1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class count_Occuarnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Krishnaa";
		Map<String,Long> map=Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);

	}

}
