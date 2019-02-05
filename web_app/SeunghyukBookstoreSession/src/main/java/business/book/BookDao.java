package business.book;

import java.util.List;

public interface BookDao {

    public Book findByBookId(Long bookId);

    public List<Book> findByCategoryId(Long categoryId);

}
