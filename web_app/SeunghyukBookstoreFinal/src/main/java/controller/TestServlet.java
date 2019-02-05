package controller;

import business.ApplicationContext;
import business.book.Book;
import business.book.BookDao;
import business.category.Category;
import business.category.CategoryDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Test", urlPatterns={"/test"})


public class TestServlet extends HttpServlet {

    private String categoryName;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = "/test";
        String url = "/WEB-INF/jsp" + userPath + ".jsp";

        categoryName = request.getParameter("category");

        CategoryDao categoryDao = ApplicationContext.INSTANCE.getCategoryDao();
        BookDao bookDao = ApplicationContext.INSTANCE.getBookDao();

        String categoryName = request.getParameter("category");

        Category category = (categoryName == null) ? categoryDao.findByCategoryId(1) :
                categoryDao.findByName(categoryName);

        categoryName = category.getName();
        Long categoryId = category.getCategoryId();

        List<Book> bookList = bookDao.findByCategoryId(categoryId);
        List<Category> categoryList = categoryDao.findAll();

        request.setAttribute("categoryList", categoryList);
        request.setAttribute("selectedCategoryName", categoryName);
        request.setAttribute("bookList", bookList);

        request.getRequestDispatcher(url).forward(request, response);










    }
}
