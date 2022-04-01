import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public Library(List<Book> books){
        this.books = books;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();

        for (Book book : books) {
            if(book.getAuthor().equals(author)){
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public Book getBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    public boolean addBook(Book book) {
        if(books.contains(book)) {
            return false;
        }
        books.add(book);
        return true;
    }

    public boolean removeBook(String title) {
        Book book = getBook(title);
        if(book == null){
            return false;
        }
        return books.remove(book);
    }
}
