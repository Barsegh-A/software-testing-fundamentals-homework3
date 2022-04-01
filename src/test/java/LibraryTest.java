import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeMethod
    public void setLibrary(){
        book1 = new Book("The Brothers Karamazov", "Fyodor Dostoevsky");
        book2 = new Book("The Idiot", "Fyodor Dostoevsky");
        book3 = new Book("Hamlet", "William Shakespeare");
        List<Book> books = new ArrayList<>(3);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        library = new Library(books);
    }

    @Test
    public void getBookValidInput(){
        assertEquals(library.getBook("Hamlet"), book3, "Incorrect book is returned for a valid input.");
    }

    @Test
    public void getBookInvalidInput(){
        assertEquals(library.getBook("Hamlett"), null, "Incorrect return value for an invalid input.");
    }

    @Test
    public void getBooksByAuthorValidAuthor(){
        List<Book> books = library.getBooksByAuthor("Fyodor Dostoevsky");
        assertEquals(books, List.of(book1, book2), "Wrong list of books is returned");
    }

    @Test
    public void getBooksByAuthorInvalidAuthor(){
        List<Book> books = library.getBooksByAuthor("Hovhannes Tumanyan");
        assertTrue(books.isEmpty(), "Not empty list is returned for an author there is no book for");
    }

    @Test
    public void removeBookValidInput(){
        assertTrue(library.removeBook("The Idiot"), "Incorrect return value for a valid input");
    }

    @Test
    public void removeBookInvalidInput(){
        assertFalse(library.removeBook("The idiot"), "Incorrect return value for an invalid input");
    }

    @Test
    public void getAllBooks(){
        assertEquals(library.getAllBooks(), List.of(book1, book2, book3), "Wrong list of all books is returned");
    }

    @Test
    public void addNewBook(){
        Book book = new Book("Giqor", "Hovhannes Tumanyan");
        assertTrue(library.addBook(book), "New book is not added");
    }

    @Test
    public void addExistingBook(){
        assertFalse(library.addBook(book1), "Existing book is added again");
    }

    @Test
    public void createEmptyLibrary(){
        library = new Library();
        assertTrue(library.getAllBooks().isEmpty(), "New library is not empty");
    }
}
