package viewmodel;


import business.book.Book;
import business.customer.Customer;
import business.order.LineItem;
import business.order.Order;
import business.order.OrderDetails;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public class ConfirmationViewModel extends BaseViewModel{

    Customer customer;
    List<Book> books;
    Order order;
    List<LineItem> lineItem;



    public ConfirmationViewModel (HttpServletRequest request){
        super(request);

        HttpSession session = request.getSession();
        OrderDetails orderDetails = (OrderDetails) session.getAttribute("orderDetails");
        customer = orderDetails.getCustomer();
        books = orderDetails.getBooks();
        order = orderDetails.getOrder();
        lineItem = orderDetails.getLineItems();


    }

    public Customer getCustomer() { return customer; }

    public List<Book> getBooks() { return books; }

    public Order getOrder() { return order; }

    public List<LineItem> getLineItem() { return lineItem; }
}

