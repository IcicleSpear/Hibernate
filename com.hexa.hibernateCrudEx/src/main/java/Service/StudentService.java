package Service;

import java.util.Scanner;

import Dao.StudentDaoImpl;
import Model.Student;

public class StudentService {
	
	StudentDaoImpl dao = new StudentDaoImpl();
    Scanner sc = new Scanner(System.in);

    public void addStudentFromUser() {
        System.out.print("Enter Roll No: ");
        int rollno = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(rollno, name, marks);
        dao.saveData(s);
        System.out.println("Student saved successfully!");
    }
    
    public void removeData()
    {
    	int rno;
    	System.out.println("Enter the RollNo");
    	rno=sc.nextInt();
    	dao.removeByRoll(rno);
    }
    public void updateStudentByRoll() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll No to update: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new marks: ");
        double marks = sc.nextDouble();

        dao.updateStudentByRollNo(roll, name, marks);
    }
    
    public void searchByRoll() {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt();
        dao.searchByRoll(roll);
    }
    public void showData() {
        
        dao.ShowData();
    }
    
    public void searchName()
    {
    	System.out.print("Enter name: ");
        String name = sc.nextLine();
    	dao.searchByNameHQL(name);
    }
    
    public void retrieveByMarks() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks: ");
        float marks = sc.nextFloat();
        sc.nextLine(); 

        dao.searchByMarks(marks);
    }
    
    public void updateNameByRollUsingHQL() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String newName = sc.nextLine();

        dao.updateStudentNameByRollHQL(roll, newName);
    }

    
}
