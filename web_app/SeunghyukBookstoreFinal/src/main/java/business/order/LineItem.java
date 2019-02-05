package business.order;

public class LineItem {

    private long bookId;
    private long customerOrderId;
    private int quantity;

    public LineItem(long customerOrderId, long bookId, int quantity) {
        this.customerOrderId = customerOrderId;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public long getBookId() {
        return bookId;
    }

    public long getCustomerOrderId() {
        return customerOrderId;
    }

    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "LineItem{" + "customerOrderId=" + customerOrderId + ", bookId=" + bookId +", quantity=" + quantity +
                '}';
    }
}