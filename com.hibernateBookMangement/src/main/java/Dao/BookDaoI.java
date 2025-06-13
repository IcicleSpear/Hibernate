package Dao;

import java.util.List;

import Model.Book;

public interface BookDaoI {
	
	void addBook(Book book);
	void updateBook(int bookId,double nprice);
	void deleteBook(int bookId);
	void searchById(int BookId);
	void genrateBill(int BookId,int qty);
	void searchByTitle(String title);
	
}
