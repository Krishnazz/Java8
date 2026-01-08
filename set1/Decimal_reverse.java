package set1;

import java.util.Arrays;
import java.util.*;

public class Decimal_reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Double> al=Arrays.asList(2.3,3.32,5.2,5.32,21.3,5.32,1.43);
		al.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

	}

}
