package project;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.*;


class Student{
	String name,group,attendance;
	int id;
	public Student(String name,int id ,String group, String attendance) {
		super();
		this.name = name;
		this.group = group;
		this.attendance = attendance;
		this.id = id;
	}
	public long presentCount() {
		return attendance.chars().filter(ch->ch=='p').count();
	}
	
}
public class SummerCamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("Enter the start date :");
		LocalDate start=LocalDate.parse(s.nextLine(),formatter);
		System.out.println("Enter the end date :");
		LocalDate end=LocalDate.parse(s.nextLine(),formatter);
		
		// long numberOfDays=ChronoUnit.DAYS.between(start, end);
		//System.out.println(sdate.format(formatter)+" "+edate+" "+numberOfDays);
		System.out.println("Enter the no of Students");
		int n=s.nextInt();s.nextLine();
		
		Student[] student = new Student[n];
		for(int i=0;i<n;i++) {
			String name=s.nextLine();
			int id=s.nextInt();s.nextLine();
			String group=s.nextLine();
			String attendance=s.nextLine();
			
			student[i]=new Student(name, id, group, attendance);
		}
		
//		for(int i=0;i<n;i++) {
//			System.out.println(student[i].name+" "+student[i].id+" "+student[i].group+" "+student[i].attendance);
		
		List<LocalDate> workingDays=start.datesUntil(end.plusDays(1))
				.filter(d->!(d.getDayOfWeek()==DayOfWeek.SATURDAY ||d.getDayOfWeek()==DayOfWeek.SUNDAY))
				.collect(Collectors.toList());
		
		Map<DayOfWeek, List<String>> daySubjects = new HashMap<>();
        daySubjects.put(DayOfWeek.MONDAY, Arrays.asList("Hindi", "Music", "Sports"));
        daySubjects.put(DayOfWeek.TUESDAY, Arrays.asList("Music", "Arts", "Science"));
        daySubjects.put(DayOfWeek.WEDNESDAY, Arrays.asList("Science", "Hindi", "Arts"));
        daySubjects.put(DayOfWeek.THURSDAY, Arrays.asList("Arts", "Music", "Sports"));
        daySubjects.put(DayOfWeek.FRIDAY, Arrays.asList("Sports", "Science", "Hindi"));
		
//		}
        Arrays.stream(student).forEach(st->{
        	Map<String, Integer> subjectCount = new HashMap<>();
            Arrays.asList("Hindi", "Music", "Sports", "Arts", "Science").forEach(sub -> subjectCount.put(sub, 0));
        	
        	IntStream.range(0,workingDays.size()).filter(i->st.attendance.charAt(i)=='P')
			.forEach(i->{
				DayOfWeek day=workingDays.get(i).getDayOfWeek();
				List<String> subjects=daySubjects.get(day);
				List<String> rotated=rotate(subjects,st.group);
				rotated.forEach(sub->subjectCount.put(sub,subjectCount.get(sub)+1));
			});
        	
        	System.out.println("\nStudent: " + st.name + " (ID: " + st.id + ", Group: " + st.group + ")");
            subjectCount.forEach((sub, count) -> System.out.println(sub + " → " + count + " classes attended"));
        	
        });
        
       Arrays.stream(student).forEach(i->{
    	  // Long count=Arrays.stream(i.attendance.split("")).filter(ch->ch=="p").count();
    	   Long count=i.presentCount();
    	   System.out.println(count>=30? i.name+" is Eligible":i.name+" is Not Eligible");
       });
      
     Map<String,Long> FailedGroup=Arrays.stream(student).filter(i->i.presentCount()<30)
    		 .collect(Collectors.groupingBy(i->i.group,Collectors.counting()));
     
     FailedGroup.forEach((key,value)-> System.out.println(key+"="+value));
     
     //5. noOf class missed by particular student
     System.out.println("Enter the student id:");
     int findid=s.nextInt();s.nextLine();
     System.out.println("Enter the subject name:");
 	String findclass=s.nextLine();
 	
 	Student stu=Arrays.stream(student).filter(i->i.id==findid).findFirst().orElse(null);
 	Long missedCount=IntStream.range(0, workingDays.size()).filter(i->stu.attendance.charAt(i)!='P').mapToObj(i->{
 		DayOfWeek day=workingDays.get(i).getDayOfWeek();
 		List<String> subjects=daySubjects.get(day);
 		return rotate(subjects,stu.group);
 	}).filter(rotated->rotated.contains(findclass)).count();
    System.out.println(stu.name+" missed "+findclass+" count :"+missedCount);
	
	//sort the student on class wise attendance and print the result;
    List<String> subjectList=Arrays.asList("Hindi","Music","Arts","Science","Sports");
    subjectList.forEach(subject->{
      System.out.println("\n Sorted by attendance in :"+subject);
      
      Arrays.stream(student).sorted((a,b)->Long.compare(getSubjectAttendance(b, workingDays, daySubjects, subject),
    		  getSubjectAttendance(a, workingDays, daySubjects, subject)))
    		  .forEach(st->{
    			  long count=getSubjectAttendance(st, workingDays, daySubjects, subject);
    			   System.out.println(st.name+" attended "+subject+": "+count);});
             });  
   //percentage
    subjectList.forEach(subject->{
        System.out.println("\n Attendance Percentage for subject :"+subject);
        
        Arrays.stream(student).sorted((a,b)->Double.compare(getattendancePercentage(b, workingDays, daySubjects, subject),
        		getattendancePercentage(a, workingDays, daySubjects, subject)))
      		  .forEach(st->{
      			  double percentage=getattendancePercentage(st, workingDays, daySubjects, subject);
      			   System.out.printf(st.name+" attended "+subject+": "+"%.2f%%",percentage);
      			   System.out.println();});
               });  
    
    
    //failed students subject wise
    subjectList.forEach(subject->{
        System.out.println("\nFailed students for the subject :"+subject);
        
       List<String> FailedStudents= Arrays.stream(student).filter(st->getattendancePercentage(st, workingDays, daySubjects, subject)<75.0).map(st->st.name).collect(Collectors.toList());
       if(FailedStudents.isEmpty())System.out.println("No failed students");
       else FailedStudents.forEach(System.out::println);
    });
    
    
    
    

}
	
	
	
	
	public static List<String> rotate(List<String> list,String group){
		if(group.equals("II")) return Arrays.asList(list.get(1),list.get(2),list.get(0));
		if(group.equals("II")) return Arrays.asList(list.get(2),list.get(0),list.get(1));
		
		return list;
	}
	public static long getSubjectAttendance(Student st, List<LocalDate> workingDays,Map<DayOfWeek,List<String>> daySubjects,String subject) {
		return IntStream.range(0, workingDays.size()).filter(i->st.attendance.charAt(i)=='P').mapToObj(i ->{
			DayOfWeek day=workingDays.get(i).getDayOfWeek();
			List<String> subjects=daySubjects.get(day);
			return rotate(subjects,st.group);
		}).filter(list->list.contains(subject)).count();
	}
	public static long getSubjecttotal(Student st, List<LocalDate> workingDays,Map<DayOfWeek,List<String>> daySubjects,String subject) {
		return IntStream.range(0, workingDays.size()).mapToObj(i ->{
			DayOfWeek day=workingDays.get(i).getDayOfWeek();
			List<String> subjects=daySubjects.get(day);
			return rotate(subjects,st.group);
		}).filter(list->list.contains(subject)).count();
	}
	public static double getattendancePercentage(Student st, List<LocalDate> workingDays,Map<DayOfWeek,List<String>> daySubjects,String subject) {
		long total=getSubjecttotal(st, workingDays, daySubjects, subject);
		long attended=getSubjectAttendance(st, workingDays, daySubjects, subject);
		if(total==0) return 0.0;
		return (attended*100.0)/total;
	}
	

}
//Vijay
//1
//II
//PPABPPPPABPPPPPABPPPPABPPPABPPPPABP
//2
//Krishna
//1
//I
//PPABPPPPABPPPPPABPPPPABPPPABPPPPABP
//Vijay
//2
//II
//PPPPPPPABPPPPPABPPPPABPPPABPPPPPP