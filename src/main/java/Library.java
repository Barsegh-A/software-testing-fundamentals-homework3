import java.util.ArrayList;
import java.util.List;

/**
 * Simple Library to handle personal books
 */

public class Library {
    private final List<Book> books;

    /**
     * Creates an empty library
     */
    public Library() {
        books = new ArrayList<>();
    }

    /**
     * Creates a library with given list of books
     * @param books
     */
    public Library(List<Book> books){
        this.books = books;
    }

    /**
     *
     * @return all books
     */
    public List<Book> getAllBooks() {
        return books;
    }

    /**
     *
     * @param author
     * @return a list of books in the library whose author is the given one
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();

        for (Book book : books) {
            if(book.getAuthor().equals(author)){
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    /**
     *
     * @param title
     * @return the Book by the given title, if there is no such book, return null
     */
    public Book getBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    /**
     * Add a new book to library
     * For the sake of having conditions, I assume a single copy of book can be kept
     * @param book
     * @return false if there is already such book and true if book is successfully added
     */
    public boolean addBook(Book book) {
        if(books.contains(book)) {
            return false;
        }
        books.add(book);
        return true;
    }

    /**
     * Removes a book from library
     * @param title
     * @return false if there is no such book and true if book is successfully removed
     */
    public boolean removeBook(String title) {
        Book book = getBook(title);
        if(book == null){
            return false;
        }
        return books.remove(book);
    }
}
