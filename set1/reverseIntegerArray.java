package set1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class reverseIntegerArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a= {5,3,1,6,7,2};
		Integer[] rev=IntStream.range(0, a.length).mapToObj(i->a[a.length-i-1]).toArray(Integer[]::new);
		for(int i:rev) {
			System.out.print(i);
		}
		

	}

}
