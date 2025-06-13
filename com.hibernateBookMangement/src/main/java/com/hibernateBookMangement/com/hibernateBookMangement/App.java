package com.hibernateBookMangement.com.hibernateBookMangement;

import java.util.Scanner;

import Service.BookService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        BookService service = new BookService();

        int choice;
        do {
            System.out.println("Book Management System");
            System.out.println("1. Add a New Book");
            System.out.println("2. Update Book Price");
            System.out.println("3. Delete a Book");
            System.out.println("4. Generate Bill");
            System.out.println("5. Search Book by ID");
            System.out.println("6. Search Book by Title");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.addBookFromUser();
                    break;
                case 2:
                    service.updatePrice();
                    break;
                case 3:
                    service.deleteBook();
                    break;
                case 4:
                    service.generateBill();
                    break;
                case 5:
                    service.searchBookById();
                    break;
                case 6:
                    service.searchBookByTitle();
                    break;
                case 0:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
