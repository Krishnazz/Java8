package project;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;

class Books{
    String name;
    int id;
    String author_name;
   
	int price;
    String rack_no;
    double rating;
    
    public Books(String name, int id, String author_name, int price, String rack_no, double rating) {
		super();
		this.name = name;
		this.id = id;
		this.author_name = author_name;
		this.price = price;
		this.rack_no = rack_no;
		this.rating = rating;
	}
   public String toString() {
	   return "Book{"+
		   name+" "+id+" "+author_name+" "+price+" "+rack_no+" "+rating+
	   '}';
   }
    
} 
public class Project_books2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();s.nextLine();
	    Books[] book=new Books[n];
		for(int i=0;i<n;i++) {
		     String name=s.nextLine();
		     int id=s.nextInt();s.nextLine();
		     String author_name=s.nextLine();
		     int price=s.nextInt();s.nextLine();
		     String rack_no=s.nextLine();
		     double rating=s.nextDouble();s.nextLine();
		     
		     book[i]=new Books(name,id,author_name,price,rack_no,rating);
		}
		Map<String,List<Books>> groupByAuthor=Arrays.stream(book).collect(Collectors.groupingBy(i->i.author_name));
		groupByAuthor.forEach((author,list)->{
			System.out.println("Author :"+author);
			list.forEach(System.out::println);
		});
		Map<Integer,String> IDNamePair=Arrays.stream(book).collect(Collectors.toMap(i->i.id,i->i.name));
		IDNamePair.forEach((a,b)-> System.out.println(a+":"+b));
		
		//filter using id or name
		System.out.println("Enter Book id or name:");
		String input=s.nextLine();
		Optional<Books> result;
		if(input.matches("\\d+")) {
			int bookid=Integer.parseInt(input);
			result=Arrays.stream(book).filter(i->i.id==bookid).findFirst();
		}
		else {
			result=Arrays.stream(book).filter(i->i.name.equalsIgnoreCase(input)).findFirst();
		}
		System.out.println(result.orElse(null)==null ?"No Book Found":result.get());
		
		//sort books by price(descending), then by name;
		Arrays.stream(book).sorted(Comparator.comparing((Books i)->i.price).reversed()
				.thenComparing(i->i.name)).forEach(System.out::println);
		
		//find average Rating 
		Double avg=Arrays.stream(book).mapToDouble(i->i.rating).average().orElse(0.0);
		System.out.println(avg);
		
		//all distinct author
		
		Arrays.stream(book).map(i->i.author_name).distinct().forEach(System.out::println);
		System.out.println();
		//strictly remove duplicates
		
		List<String> authors=Arrays.stream(book).map(i->i.author_name).collect(Collectors.toList());
		Arrays.stream(book).filter(i->Collections.frequency(authors, i.author_name)==1).forEach(i->System.out.println(i.author_name));
		
		//Group by rack no
		Map<String,List<Books>> rackGrouping=Arrays.stream(book).collect(Collectors.groupingBy(i->i.rack_no));
		rackGrouping.forEach((a,b)->{
		System.out.println("Rack"+a);
		b.forEach(System.out::println);
		});
	}

}
//4
//Krishna
//1
//Krishna
//45
//r1
//2.3
//Suresh
//2
//suresh
//32
//r2
//7.5
//xDinesh
//3
//Dinesh
//21
//r3
//1.2
//Retro
//4
//Krishna
//45
//r1
//2.3
