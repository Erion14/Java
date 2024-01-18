package functional_programming.streams.hw.books;

import java.util.Arrays;
import java.util.Objects;

public class BookService {
	
	public Book[] filterBooksByAuthor(Author author, Book[] books) {
		return Arrays.stream(books)
				.filter(Objects::nonNull)
				.filter(book -> book.hasAuthor(author))
				.toArray(Book[]::new);
		
		
	}
	public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
		return Arrays.stream(books)
				.filter(Objects::nonNull)
				.filter(book -> book.getPublisher().equals(publisher))
				.toArray(Book[]::new);
	}
	
	
	public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
		return Arrays.stream(books)
				.filter(Objects::nonNull)
				.filter(book -> book.getPublishingYear() >= yearFromInclusively)
				.toArray(Book[]::new);	
	}

	
}
