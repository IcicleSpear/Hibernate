package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Connection.BookConn;
import Model.Book;

public class BookDaoImpl implements BookDaoI {
	
	SessionFactory factory;
	
	public BookDaoImpl()
	{
		factory=BookConn.getSessionFactory();
	}

	@Override
	public void addBook(Book book) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(book);
		tx.commit();
		System.out.println("Book added Successfully");	
	}

	@Override
	public void updateBook(int bookId, double nprice) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query<?> query=session.createQuery("update Book set price = :price where bookId = :id");
		query.setParameter("price",nprice);
		query.setParameter("id",bookId);
		int status = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println(status > 0 ? "Price updated." : " Book not found.");
	}

	@Override
	public void deleteBook(int bookId) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query<?> query=session.createQuery("delete from Book where bookId = :id");
		query.setParameter("id",bookId);
		int status = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println(status > 0 ? "Book deleted." : " Book not found.");
	}

	@Override
	public void searchById(int bookId) {
		Session session=factory.openSession();
		
		Query<Book> query=session.createQuery("from Book where bookId = :id",Book.class);
		query.setParameter("id",bookId);
		Book b = session.get(Book.class,bookId);
		
        session.close();
        System.out.println(b!=null ? b.toString() : " Book not found.");

	}

	@Override
	public void genrateBill(int bookId, int qty) {
		Session session = factory.openSession();
        Query<Book> query = session.createQuery("from Book where bookId = :id", Book.class);
        query.setParameter("id", bookId);
        Book book = query.uniqueResult();

        if (book != null) {
            if (book.getQuantity() >= qty) {
                double total = book.getPrice() * qty;
                System.out.println("Title: " + book.getTitle());
                System.out.println("Each Book Price: " + book.getPrice());
                System.out.println("Total Amount: " + total);
            } else {
                System.out.println("Insufficient stock. Available: " + book.getQuantity());
            }
        } else {
            System.out.println("Book not found.");
        }
		
	}

	@Override
	public void searchByTitle(String title) {
		Session session=factory.openSession();
		Query<Book> query=session.createQuery("from Book where title=:title",Book.class);
		query.setParameter("title",title);
		List<Book> books = query.list();
        if (books.isEmpty()) {
            System.out.println("No book found with title: " + title);
        } else {
            books.forEach((i)->System.out.println(i));
        }
		
		
	}

}
