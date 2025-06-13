package Dao;

import Model.Student;

public interface StudentDaoI {
	
	void saveData(Student s);
	void removeByRoll(int rno);
	void updateStudentByRollNo(int rno,String name,double marks);
	void searchByRoll(int rno);
	void ShowData();
	void searchByNameHQL(String name);
	void searchByMarks(double marks);
	void updateStudentNameByRollHQL(int roll, String newName);

}
