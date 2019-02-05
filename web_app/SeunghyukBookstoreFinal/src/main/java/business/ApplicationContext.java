
package business;

import business.book.Book;
import business.book.BookDao;
import business.book.BookDaoJdbc;
import business.category.CategoryDao;
import business.category.CategoryDaoJdbc;
import business.customer.CustomerDao;
import business.customer.CustomerDaoJdbc;
import business.order.*;

import java.util.List;

public class ApplicationContext {

    private CategoryDao categoryDao;
    private BookDao bookDao;
    private CustomerDao customerDao;
    private LineItemDao lineItemDao;
    private OrderDao orderDao;
    private OrderService orderService;

    public static ApplicationContext INSTANCE = new ApplicationContext();

    private ApplicationContext() {
        categoryDao = new CategoryDaoJdbc();
        bookDao = new BookDaoJdbc();
        customerDao = new CustomerDaoJdbc();
        lineItemDao = new LineItemDaoJdbc();
        orderDao = new OrderDaoJdbc();


        orderService = new DefaultOrderService();
        DefaultOrderService service = (DefaultOrderService) orderService;
        service.setBookDao(bookDao);
        service.setCustomerDao(customerDao);
        service.setOrderDao(orderDao);
        service.setLineItemDao(lineItemDao);
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }
    public BookDao getBookDao() {return bookDao;}
    public CustomerDao getCustomerDao() {return customerDao;}
    public OrderDao getOrderDao() {return orderDao;}
    public LineItemDao getLineItemDao() {return lineItemDao;}
    public OrderService getOrderService() {return orderService;}


}
