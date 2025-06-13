package Service;

import java.util.Scanner;

import Dao.BookDaoImpl;
import Model.Book;

public class BookService {

    BookDaoImpl dao = new BookDaoImpl();
    Scanner sc = new Scanner(System.in);

    public void addBookFromUser() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        Book book = new Book(id, title, author, price, quantity);
        dao.addBook(book);
    }

    public void updatePrice() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        System.out.print("Enter new price: ");
        double price = sc.nextDouble();
        dao.updateBook(id, price);
    }

    public void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();
        dao.deleteBook(id);
    }

    public void generateBill() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        dao.genrateBill(id, qty);
    }

    public void searchBookById() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        dao.searchById(id);
    }

    public void searchBookByTitle() {
        sc.nextLine();
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        dao.searchByTitle(title);
    }
}