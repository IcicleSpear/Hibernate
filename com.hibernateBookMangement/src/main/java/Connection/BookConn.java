package Connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Book;

public class BookConn {
	
private static SessionFactory sessionFactory;
	
	BookConn()
	{
		sessionFactory= new Configuration().configure("hiber.config.xml").addAnnotatedClass(Book.class).buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() 
	{
		BookConn bookConn= new BookConn();
		return sessionFactory;
	}
}
