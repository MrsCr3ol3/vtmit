
package business;

import business.book.Book;
import business.book.BookDao;
import business.book.BookDaoJdbc;
import business.category.CategoryDao;
import business.category.CategoryDaoJdbc;

import java.util.List;

// TODO: Add the appropriate code for the book DAO. 

public class ApplicationContext {

    private CategoryDao categoryDao;

    private BookDao bookDao;

    public static ApplicationContext INSTANCE = new ApplicationContext();

    private ApplicationContext() {
        categoryDao = new CategoryDaoJdbc();
        bookDao = new BookDaoJdbc();
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }
    public BookDao getBookDao() {return bookDao;}

}
