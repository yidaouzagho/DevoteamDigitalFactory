package fr.d2factory.libraryapp.library;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.book.IBookRepository;
import fr.d2factory.libraryapp.member.Member;
import fr.d2factory.libraryapp.member.Resident;
import fr.d2factory.libraryapp.member.Student;

/**
 * The Class LibraryImpl.
 *
 * @author Kais Belhareth
 */
public class LibraryImpl implements Library{

    /** The Constant daysBeforeLateStudent. */
    private static final int daysBeforeLateStudent = 30;
    
    /** The Constant daysBeforeLateResident. */
    private static final int daysBeforeLateResident = 60;
    
	/** The book repository. */
	private IBookRepository bookRepository;
	
	/** The borrowers. */
	Map<Book, Member> borrowers = new HashMap<>();
	
	/**
	 * Instantiates a new library impl.
	 *
	 * @param bookRepository the book repository
	 */
	public LibraryImpl(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
		
	/* (non-Javadoc)
	 * @see fr.d2factory.libraryapp.library.Library#borrowBook(long, fr.d2factory.libraryapp.member.Member, java.time.LocalDate)
	 */
	@Override
	public Book borrowBook(long isbnCode, Member member, LocalDate borrowedAt) throws  HasLateBooksException {
		isMemberLate(member);		
		if(member.isLate()) {
			throw new HasLateBooksException();
		}
		Book bookToBorrow = bookRepository.findBook(isbnCode);
		if (bookToBorrow != null) {
			bookRepository.saveBookBorrow(bookToBorrow, borrowedAt);
			borrowers.put(bookRepository.removeBook(isbnCode), member);
		}
		return bookToBorrow;		
	}

	/* (non-Javadoc)
	 * @see fr.d2factory.libraryapp.library.Library#returnBook(fr.d2factory.libraryapp.book.Book, fr.d2factory.libraryapp.member.Member)
	 */
	@Override
	public void returnBook(Book book, Member member) {
		bookRepository.addBooks(Arrays.asList(book));
		bookRepository.getBorrowedBooks().remove(book);		
	}

	/* (non-Javadoc)
	 * @see fr.d2factory.libraryapp.library.Library#isMemberLate(fr.d2factory.libraryapp.member.Member)
	 */
	@Override
	public void isMemberLate(Member member) {
		LocalDate today = LocalDate.now();
		int amountOfDaysAllowed = 0;
		if (member instanceof Student)
			amountOfDaysAllowed = daysBeforeLateStudent;
		if (member instanceof Resident)
			amountOfDaysAllowed = daysBeforeLateResident;
		
		Iterator<Map.Entry<Book, Member>> iterator = borrowers.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Book, Member> entry = iterator.next();
			if (entry.getValue().equals(member)) {
				if (bookRepository.findBorrowedBookDate(entry.getKey()).plusDays(amountOfDaysAllowed).isBefore(today)) {
					entry.getValue().setLate(true);
				}
			}
		}
		
	}
}
