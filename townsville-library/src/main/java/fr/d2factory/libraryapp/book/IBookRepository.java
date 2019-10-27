package fr.d2factory.libraryapp.book;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * The Interface IBookRepository.
 */
public interface IBookRepository {

	/**
	 * Adds the books.
	 *
	 * @param books the books
	 */
	public void addBooks(List<Book> books);
	
	/**
	 * Find book.
	 *
	 * @param isbnCode the isbn code
	 * @return the book
	 */
	public Book findBook(long isbnCode);
	
	/**
	 * Save book borrow.
	 *
	 * @param book the book
	 * @param borrowedAt the borrowed at
	 */
	public void saveBookBorrow(Book book, LocalDate borrowedAt);
	
	/**
	 * Find borrowed book date.
	 *
	 * @param book the book
	 * @return the local date
	 */
	public LocalDate findBorrowedBookDate(Book book);
	
	/**
	 * Removes the book.
	 *
	 * @param isbnCode the isbn code
	 * @return the book
	 */
	public Book removeBook(long isbnCode);
	
	/**
	 * Gets the available books.
	 *
	 * @return the available books
	 */
	public Map<ISBN, Book> getAvailableBooks();
	
	/**
	 * Sets the available books.
	 *
	 * @param availableBooks the available books
	 */
	public void setAvailableBooks(Map<ISBN, Book> availableBooks);
	
	/**
	 * Gets the borrowed books.
	 *
	 * @return the borrowed books
	 */
	public Map<Book, LocalDate> getBorrowedBooks();
	
	/**
	 * Sets the borrowed books.
	 *
	 * @param borrowedBooks the borrowed books
	 */
	public void setBorrowedBooks(Map<Book, LocalDate> borrowedBooks);
	
}
