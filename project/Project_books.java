package project;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

 class Book{
    String name;
    int id;
    String author_name;
   
	int price;
    String rack_no;
    double rating;
    
    public Book(String name, int id, String author_name, int price, String rack_no, double rating) {
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
public class Project_books {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();s.nextLine();
	    Book[] book=new Book[n];
		for(int i=0;i<n;i++) {
		     String name=s.nextLine();
		     int id=s.nextInt();s.nextLine();
		     String author_name=s.nextLine();
		     int price=s.nextInt();s.nextLine();
		     String rack_no=s.nextLine();
		     double rating=s.nextDouble();s.nextLine();
		     
		     book[i]=new Book(name,id,author_name,price,rack_no,rating);
		}
		Optional<Book> maxPricedBook=Arrays.stream(book).max(Comparator.comparing(i->i.price));
		maxPricedBook.ifPresent(i->System.out.println("max Priced Book "+i.name));
		
		Optional<Book> highestRatedBook=Arrays.stream(book).max(Comparator.comparing(i->i.rating));
		highestRatedBook.ifPresent(i->System.out.println("Highest Rated Book "+i.name));
		
		Optional<Book> lowestRatedBook=Arrays.stream(book).min(Comparator.comparing(i->i.rating));
		lowestRatedBook.ifPresent(i->System.out.println("Lowest Rated Book "+i.name));
		
		Arrays.stream(book).sorted(Comparator.comparing(i->i.author_name)).forEach(System.out::println);
		Arrays.stream(book).sorted(Comparator.comparing(i->i.name)).forEach(System.out::println);
		
		Arrays.stream(book).sorted(Comparator.comparing((Book i)->i.rating).reversed()).forEach(System.out::println);
		System.out.println("Enter the Book ID or name :");
		String input=s.nextLine();
		//System.out.println("Enter the Book name :");
		
		Optional<Book> result;
		if(input.matches("\\d+")) {
			int bookid=Integer.parseInt(input);
			result=Arrays.stream(book).filter(i->i.id==bookid).findFirst();
		}
		else {
			result=Arrays.stream(book).filter(i->i.name.equalsIgnoreCase(input)).findFirst();
		}
		System.out.println(result.orElse(null)==null?"No Book found":result.get());
		
		System.out.println("Enter the Starting price range:");
		int start=s.nextInt();
		System.out.println("Enter the Starting price range:");
		int end=s.nextInt();
		//List<Book> priceRangedBooks=
				Arrays.stream(book).filter(i->i.price>=start && i.price<=end).forEach(System.out::println);
		//priceRangedBooks.;
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
//1
//Krishna
//45
//r1
//2.3
