package controller;

import business.ApplicationContext;
import business.customer.Customer;
import business.order.Order;
import business.order.OrderDetails;
import business.order.OrderService;
import viewmodel.ConfirmationViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Confirmation",
        urlPatterns = {"/confirmation"})

/**
 * Handles the HTTP <code>GET</code> method.
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */

public class ConfirmationServlet extends BookstoreServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.setAttribute("p", new ConfirmationViewModel(request));
        forwardToJsp(request, response, "/confirmation");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect(request.getContextPath() + "/cart");



    }
}
