package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Connection.StudentConn;
import Model.Student;

public class StudentDaoImpl implements StudentDaoI{
	
	SessionFactory factory;
	
	public StudentDaoImpl()
	{
		factory=StudentConn.getSessionFactory();
	}
	
	@Override
	public void saveData(Student s)
	{
		Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
        System.out.println("Student saved successfully.");

	}

	@Override
	public void removeByRoll(int rno) {
		Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Student s=session.get(Student.class,rno);
        if(s==null)
        {
        	System.out.println("User Not Found");
        }
        else
        {
        	session.delete(s);
        	System.out.println("User Deleted Sucessfully");
        }
        tx.commit();
		
	}

	@Override
	public void updateStudentByRollNo(int rno, String name, double marks) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student rs=session.get(Student.class,rno);
		
		if(rs==null)
		{
			System.out.println("User not found");
		}
		else
		{
			rs.setName(name);
			rs.setMarks(marks);
			session.update(rs);
			tx.commit();
			System.out.println("Updated Sucessfully");
		}
	}

	@Override
	public void searchByRoll(int rno) {
		 Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        Student s = session.get(Student.class,rno);
	        if (s != null) {
	            System.out.println(s);
	        } else {
	            System.out.println("Student not found.");
	        }
	        tx.commit();
	        session.close();
	}
	
	@Override
	public void ShowData() {		
		Session session=factory.openSession();
		 Query<Student>  query= session.createQuery("from Student");
		
		 List<Student> students=	 query.list();
 
		 for(Student s : students )	
		 {
			 System.out.println(s.toString());
		
		 }
		
	}

	@Override
	public void searchByNameHQL(String rname) {
		
		Session session=factory.openSession();
		
		Query<Student> q=session.createQuery("from Student where name=:name",Student.class);
		q.setParameter("name",rname);
		
		List<Student> user=q.list();
		
		for(Student u:user)
		{
			System.out.println(u.toString());
		}
	}
	
	@Override
	public void searchByMarks(double marks) {
	    Session session = factory.openSession();

	    Query<Student> query = session.createQuery("from Student where marks > :marks", Student.class);
	    query.setParameter("marks", marks);
	    query.setFirstResult(1); // Pagination
		query.setMaxResults(4);

	    List<Student> students = query.list();

	    students.stream().forEach((i)->System.out.println(i));

	}
	
	@Override
	public void updateStudentNameByRollHQL(int roll, String newName) {
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();

	    Query<?> query = session.createQuery("update Student set name = :name where rollno = :roll");
	    query.setParameter("name", newName);
	    query.setParameter("roll", roll);

	    int count = query.executeUpdate();

	    tx.commit();
	    session.close();

	    System.out.println(count + " record(s) updated.");
	}



	

}
