package set1;

import java.util.*;

public class Map_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,List<String>>map=new HashMap<>();
		map.put("Fruits", Arrays.asList("Apple","Orange","Mango"));
		map.put("Vegetables", Arrays.asList("Carrot","potato","beetroot"));
		map.forEach((key,value)->{
			System.out.println("KEY "+key);
			value.forEach(i->System.out.println(i));
		});
		

	}

}
