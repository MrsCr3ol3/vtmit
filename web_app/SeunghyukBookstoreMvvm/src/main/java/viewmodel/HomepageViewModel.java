package viewmodel;



import business.ApplicationContext;
import business.book.Book;
import business.book.BookDao;
import business.category.Category;
import business.category.CategoryDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class HomepageViewModel extends BaseViewModel {

    BookDao bookDao = ApplicationContext.INSTANCE.getBookDao();
    CategoryDao categoryDao = ApplicationContext.INSTANCE.getCategoryDao();

    private Category selectedCategory;
    private List<Book> selectedCategoryBooks;

    public HomepageViewModel (HttpServletRequest request){
        super(request);

        List<Category> categories = super.getCategories();
        Long randomCategoryId = Math.round(Math.random()*10) % 5;

        selectedCategoryBooks = bookDao.findByCategoryId(randomCategoryId);
    }



}
