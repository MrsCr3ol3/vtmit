package controller;

import business.ApplicationContext;
import business.book.Book;
import business.book.BookDao;
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

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        categoryName = "fictions";
    }
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



        if (categoryName == null) {categoryName = "fictions";}

        if (!(categoryName.equals("fictions") || categoryName.equals("business")
                || categoryName.equals("children") || categoryName.equals("textbook")))
        {
            categoryName = "fictions";
        }

        request.setAttribute("selectedCategoryName", categoryName);

        Long categoryId = categoryDao.findByName(categoryName).getCategoryId();


        BookDao bookDao = ApplicationContext.INSTANCE.getBookDao();

        List <Book> books = bookDao.findByCategoryId(categoryId);

        request.setAttribute("bookList", books);
        request.setAttribute("categoryList", categoryDao);




        request.getRequestDispatcher(url).forward(request, response);










    }
}
