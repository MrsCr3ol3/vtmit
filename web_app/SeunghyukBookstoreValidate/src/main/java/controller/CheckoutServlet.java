package controller;

import business.cart.ShoppingCart;
import business.customer.CustomerForm;
import viewmodel.CheckoutViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "Checkout",
        urlPatterns = {"/checkout"})
public class CheckoutServlet extends BookstoreServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("p", new CheckoutViewModel(request));
        forwardToJsp(request, response, "/checkout");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String ccNumber = request.getParameter("ccNumber");
        String ccMonth = request.getParameter("ccMonth");
        String ccYear = request.getParameter("ccYear");

        CustomerForm customerForm = new CustomerForm(name, phone, email, ccNumber, ccMonth, ccYear);
        session.setAttribute("customerForm", customerForm);

        // this should never happen...
        if (cart.getItems().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/cart");
            return;
        }

        if (customerForm.getHasFieldError()) {
            session.setAttribute("validationError", Boolean.TRUE);
            response.sendRedirect(request.getContextPath() + "/checkout");
            return;
        }

        // if everything goes through...
        session.setAttribute("transactionError", Boolean.TRUE);
        response.sendRedirect(request.getContextPath() + "/checkout");
    }
}
