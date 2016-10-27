/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dao.BookDAO;
import dao.BookDAOImpl;
import java.util.List;
import model.Book;

/**
 *
 * @author tomek
 */
public class BookApp {

    /**
     * @param args the command line arguments
     */
    private static BookDAO bookDao = new BookDAOImpl();
    
    public static void main(String[] args) {
        System.out.println("Lista wszystkich książek:");
        findAllBooks();
        System.out.println("\n" + "Wyszukiwanie książek ze słowem kluczowym 'GROOVY' w tytule:");
        searchBooks("Groovy");
        System.out.println("\n" + "Wyszukiwanie książek ze słowem kluczowym 'Josh' dla imienia autora");
        searchBooks("Josh");
    }
    
    private static void findAllBooks(){
        List<Book> books = bookDao.findAllBooks();
        for(Book book : books){
            System.out.println(book);
        }
    }
    
    private static void searchBooks(String keyWord){
        List<Book> books = bookDao.searchBooksByKeyword(keyWord);
        for(Book book : books){
            System.out.println(book);
        }
    }
}
