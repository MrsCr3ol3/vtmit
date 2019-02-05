package business.book;

public class Book {

	/*
	 * TODO: Create private fields corresponding to the fields in the
	 * book table of your database. Generate a constructor that
	 * uses those fields. Generate getter methods for those fields,
	 * and generate a toString method that uses those fields.
	 */

	private Long categoryId;
	private Long bookId;
	private String title;
	private String author;
	private Integer price;
	private boolean isPublic;

    public Book(Long bookId, String title, String author, Integer
            price, boolean isPublic, Long categoryId) {
        this.categoryId = categoryId;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isPublic = isPublic;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPrice() {
        return price;
    }

    public boolean getIsPublic() {
        return isPublic;
    }

    @Override
    public String toString() {
        return "Book{" +
                "categoryId=" + categoryId +
                ", bookId=" + bookId +
                ", title='" + title +
                ", author='" + author +
                ", price=" + price +
                ", isPublic=" + isPublic +
                '}';
    }
}
