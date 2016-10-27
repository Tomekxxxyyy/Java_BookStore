/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Author;
import model.Book;
import model.Category;

/**
 *
 * @author tomek
 */
public class BookDAOImpl implements BookDAO{
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            
        }
    }
    
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/ksiazki", "tomek", "");
    }
    
    private void closeConnection(Connection connection){
        if(connection == null){
            return;
        }
        try{
            connection.close();
        }catch(SQLException ex){
            
        }
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> result = new ArrayList<Book>();
        List<Author> authorList = new ArrayList<Author>();
        
        String sql = "SELECT * FROM ksiazka INNER JOIN autor ON ksiazka.id = autor.id_ksiazki";
        
        Connection connection = null;
        
        try{
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("id"));
                book.setBookTitle(resultSet.getString("tytul_ksiazki"));
                book.setCategoryId(resultSet.getLong("id_kategorii"));
                author.setBookId(resultSet.getLong("id_ksiazki"));
                author.setFirstName(resultSet.getString("imie"));
                author.setLastName(resultSet.getString("nazwisko"));
                authorList.add(author);
                book.setAuthors(authorList);
                book.setPublisherName(resultSet.getString("wydawca"));
                result.add(book);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Book> searchBooksByKeyword(String keyWord) {
        List<Book> result = new ArrayList<Book>();
        List<Author> authorList = new ArrayList<Author>();
        
        String sql = "SELECT * FROM ksiazka INNER JOIN autor ON ksiazka.id = autor.id_ksiazki"
                + " WHERE tytul_ksiazki LIKE '%" + keyWord.trim() + "%' OR imie LIKE '%" + keyWord.trim() + "%'"
                + " OR nazwisko LIKE '%" + keyWord.trim() + "%'";
        
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("id"));
                book.setBookTitle(resultSet.getString("tytul_ksiazki"));
                book.setPublisherName(resultSet.getString("wydawca"));
                author.setBookId(resultSet.getLong("id_ksiazki"));
                author.setFirstName(resultSet.getString("imie"));
                author.setLastName(resultSet.getString("nazwisko"));
                authorList.add(author);
                book.setAuthors(authorList);
                result.add(book);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> result = new ArrayList<Category>();
        String sql = "SELECT * FROM category";
        
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setCategoryDescription(resultSet.getString("opis_kategorii"));
                result.add(category);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public void insert(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long bookId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

