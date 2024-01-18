package functional_programming.streams.hw.books;

public class BookServiceWithoutStream {

	public Book[] filterBooksByAuthor(Author author, Book[] books) {
		if (author == null || books == null) {
			return new Book[0];
		}
		int matchBooksAmount = 0;
		for (Book book : books) {
			if (book.hasAuthor(author)) {
				matchBooksAmount++;
			}
		}
		Book[] filteredBooks = new Book[matchBooksAmount];
		int index =0;
		for (Book book : books) {
			if(book.hasAuthor(author)) {
				filteredBooks[index++] = book;
			}
		}
		return filteredBooks;
	}

public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
	if ( publisher == null || books == null ) {
		return new Book[0];
		
	}
	int matchBooksAmount = 0;
	for (Book book : books) {
		if (book.getPublisher().equals(publisher)) {
			matchBooksAmount++;
		}
	}
	Book[] filteredBooks = new Book[matchBooksAmount];
	int index = 0;
	for (Book book : books) {
		if (book.getPublisher().equals(publisher)) {
			filteredBooks[index++] = book;
		}
	}
	return filteredBooks;
}

public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
	if (books == null ) {
		return new Book[0];
	}
	
	int matchBooksAmount = 0;
	for (Book book : books) {
		if (book.getPublishingYear() >= yearFromInclusively) {
			matchBooksAmount++;
		}
	}
	Book[] filteredBooks = new Book[matchBooksAmount];
	int index = 0;
	for (Book book : books) {
		if (book.getPublishingYear() >= yearFromInclusively) {
			filteredBooks[index++] = book;
		}
	}
	return filteredBooks;
}

}
