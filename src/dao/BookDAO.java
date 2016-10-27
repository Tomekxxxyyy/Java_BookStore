/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Book;
import model.Category;

/**
 *
 * @author tomek
 */
public interface BookDAO {
    public List<Book> findAllBooks();
    public List<Book> searchBooksByKeyword(String keyWord);
    public List<Category> findAllCategories();
    public void insert(Book book);
    public void update(Book book);
    public void delete(Long bookId);
}
