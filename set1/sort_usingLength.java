package set1;
import java.util.*;
import java.util.stream.Collectors;
public class sort_usingLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al=new ArrayList<>();
		
		al.add("sam");
		
		al.add("Kaira Advani");
		al.add("Kayadu Lohar");
		al.add("Pooja hegde");
		al.add("Rukmini vasanth");
		
		List<String> newlist=al.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
		System.out.println(newlist);
	}

}
