package controller;

import business.ApplicationContext;
import business.book.Book;
import business.cart.ShoppingCart;
import business.category.Category;
import viewmodel.CartViewModel;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cart", urlPatterns={"/cart"})
public class CartServlet extends BookstoreServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
            String bookIdString = request.getParameter("bookId");
            Long bookId = Long.parseLong(bookIdString);
            Book book = ApplicationContext.INSTANCE.getBookDao().findByBookId(bookId);

            cart.addItem(book);
        }

        if ("out".equals(action)){
            System.out.println("decrease book");
            ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
            String bookIdString = request.getParameter("bookId");
            Long bookId = Long.parseLong(bookIdString);
            Book book = ApplicationContext.INSTANCE.getBookDao().findByBookId(bookId);

            cart.decrement(book);

        }
        response.sendRedirect(request.getContextPath() + "/cart");

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Category selectedCategory = (Category) session.getAttribute("selectedCategory");
        String selectedCategoryString = selectedCategory.getName();

        request.setAttribute("selectedCategoryString",selectedCategoryString);

        request.setAttribute("p", new CartViewModel(request));

        forwardToJsp(request, response, "/cart");
    }
}

