package set1;

import java.util.*;

class Employee{
	String name;
	int age;
	 double salary;
	Employee(String name, int age, double salary){
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
}
public class Employee_avg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> e=Arrays.asList(new Employee("paari",24,100000),new Employee("Ruku",23,50000),new Employee("Micheal",24,25000));
		double average=e.stream().filter(i->i.age>24).mapToDouble(i->i.salary).average().orElse(0.0);
		System.out.println((int)average);

	}

}
