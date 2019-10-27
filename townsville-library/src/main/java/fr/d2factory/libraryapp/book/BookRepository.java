package fr.d2factory.libraryapp.book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

/**
 * The book repository emulates a database via 2 HashMaps.
 */
public class BookRepository implements IBookRepository{
	
    /** The available books. */
    private Map<ISBN, Book> availableBooks = new HashMap<>();
    
    /** The borrowed books. */
    private Map<Book, LocalDate> borrowedBooks = new HashMap<>();

    /* (non-Javadoc)
     * @see fr.d2factory.libraryapp.book.IBookRepository#addBooks(java.util.List)
     */
    @Override
    public void addBooks(List<Book> books){
    	books.forEach(book -> availableBooks.put(book.getIsbn(),book));
    }

    /* (non-Javadoc)
     * @see fr.d2factory.libraryapp.book.IBookRepository#findBook(long)
     */
    @Override
    public Book findBook(long isbnCode) {
    	Optional<Entry<ISBN, Book>> book = availableBooks.entrySet().stream().filter(bookEntry -> bookEntry.getKey().getIsbnCode() == isbnCode).findFirst();
    	if (book.isPresent()) {
    		return book.get().getValue();
		}
    	return null;
    }

    /* (non-Javadoc)
     * @see fr.d2factory.libraryapp.book.IBookRepository#saveBookBorrow(fr.d2factory.libraryapp.book.Book, java.time.LocalDate)
     */
    @Override
    public void saveBookBorrow(Book book, LocalDate borrowedAt){
    	borrowedBooks.put(book, borrowedAt);
    }

    /* (non-Javadoc)
     * @see fr.d2factory.libraryapp.book.IBookRepository#findBorrowedBookDate(fr.d2factory.libraryapp.book.Book)
     */
    @Override
    public LocalDate findBorrowedBookDate(Book book) {
    	if(book!= null) {
			long isbn = book.getIsbn().getIsbnCode();
			Optional<Entry<Book, LocalDate>> resultBook = borrowedBooks.entrySet().stream().filter( bookEntry -> bookEntry.getKey().getIsbn().getIsbnCode() == isbn).findFirst();
			return resultBook.get().getValue();
		}
		return null;
    }
    
    /* (non-Javadoc)
     * @see fr.d2factory.libraryapp.book.IBookRepository#removeBook(long)
     */
    @Override
	public Book removeBook(long isbnCode) {		
		Optional<Entry<ISBN, Book>> resultBook = availableBooks.entrySet().stream().filter(bookEntry -> bookEntry.getKey().getIsbnCode() == isbnCode ).findFirst();
		availableBooks.remove(resultBook.get().getKey());
		return resultBook.get().getValue();
	}

    /* (non-Javadoc)
     * @see fr.d2factory.libraryapp.book.IBookRepository#getAvailableBooks()
     */
    @Override
	public Map<ISBN, Book> getAvailableBooks() {
		return availableBooks;
	}

    /* (non-Javadoc)
     * @see fr.d2factory.libraryapp.book.IBookRepository#setAvailableBooks(java.util.Map)
     */
    @Override
	public void setAvailableBooks(Map<ISBN, Book> availableBooks) {
		this.availableBooks = availableBooks;
	}

    /* (non-Javadoc)
     * @see fr.d2factory.libraryapp.book.IBookRepository#getBorrowedBooks()
     */
    @Override
	public Map<Book, LocalDate> getBorrowedBooks() {
		return borrowedBooks;
	}

    /* (non-Javadoc)
     * @see fr.d2factory.libraryapp.book.IBookRepository#setBorrowedBooks(java.util.Map)
     */
    @Override
	public void setBorrowedBooks(Map<Book, LocalDate> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
}
