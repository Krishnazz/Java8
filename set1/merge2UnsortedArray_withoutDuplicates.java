package set1;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class merge2UnsortedArray_withoutDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] Array1= {4,3,6,2,7,1};
		Integer[] Array2= {5,3,1,6,3,2};
		Integer[] array=Stream.concat(Arrays.stream(Array1), Arrays.stream(Array2)).distinct().toArray(Integer[]::new);
		for(int a:array) {
			System.out.println(a);
		}

	}
 
}
