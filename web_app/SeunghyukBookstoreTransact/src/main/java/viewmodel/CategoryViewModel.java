package viewmodel;

import business.ApplicationContext;
import business.book.Book;
import business.book.BookDao;
import business.category.Category;
import business.category.CategoryDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CategoryViewModel extends BaseViewModel {

    private Category selectedCategory;
    private List<Book> selectedCategoryBooks;

    BookDao bookDao = ApplicationContext.INSTANCE.getBookDao();
    CategoryDao categoryDao = ApplicationContext.INSTANCE.getCategoryDao();

    public CategoryViewModel(HttpServletRequest request) {
        super(request);

        String categoryName = request.getParameter("category");
        selectedCategory = (isValidName(categoryName)) ? categoryDao.findByName(categoryName) :
                categoryDao.findByCategoryId(1);

        selectedCategoryBooks = bookDao.findByCategoryId(selectedCategory.getCategoryId());
        rememberSelectedCategory(session, selectedCategory);

    }

    private boolean isValidName(String s) {
        if(s == null) {
            System.out.println("input null");
            return false;}
        for (Category item : categoryDao.findAll()) {

            String itemName = item.getName();
            if (itemName.equals(s)) {
                return true;
            }
        }

        return false;
    }

    private void rememberSelectedCategory(HttpSession session, Category selectedCategory) {
        session.setAttribute("selectedCategory", selectedCategory);
    }



    public Category getSelectedCategory() { return selectedCategory; }
    public List<Book> getSelectedCategoryBooks() { return selectedCategoryBooks; }

}
