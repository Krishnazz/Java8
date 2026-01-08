package set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;

public class KeyString_ValueLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al=new ArrayList<>();
		
		al.add("Sam");
		al.add("Kaira");
		al.add("Kayadu");
		al.add("Pooja");
		al.add("Rukmini");
		
		Map<String ,Integer>map=al.stream().collect(Collectors.toMap(i->i, i->i.length()));
		System.out.print(map);
	}

}
