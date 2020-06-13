package com.example.rest.webservices.restfulwebservices.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	private static List<Book> books = new ArrayList<Book>();
	private static int idCount = 0;

	static {
		books.add(new Book(++idCount, "The Jungle Book", "Rudyard Kipling", "9788379030651", "01/11/1985",
				"Macmillan Publisher", 195, "Adventure", "Ebook"));
		books.add(new Book(++idCount, "The Selfish Giant", "Oscar Wilde", "8793890730659", "01/11/1995",
				"Independent Publishers", 320, "Action", "Hard Cover"));
	}

	public List<Book> getAllBooks() {
		return books;
	}

	public Book save(Book book) {
		if(book.getId() == -1) {
			book.setId(idCount);
			books.add(book);
		} else {
			deleteBook(book.getId());
			books.add(book);
		}
		return book;
	}
	
	public Book deleteBook(long id) {
		Book book = findById(id);
		if (book == null)
			return null;
		if (books.remove(book)) {
			return book;
		}
		return null;
	}

	private Book findById(long id) {
		for (Book book : books) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	public Book getBook(long id) {
		Book book = findById(id);
		if(book == null) return null;
		return book;
	}
}
