package com.devtools.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtools.api.entities.Book;

@Component
public class BookStaticService {

	@Autowired
	// public BookRepository bookRepository;

	private static List<Book> list = new ArrayList<>();

	static {

		list.add(new Book(1, "The Hidden Truth", "Andrew BlackRoth"));
		list.add(new Book(2, "The Secret of Saving Capital", "Diana Johnlapison"));
		list.add(new Book(3, "The Rich Son Poor Dad", "Kristina Diamond"));
		list.add(new Book(4, "The Secret Recipe of Indian Foods", "Dhruvee Raichand"));
		list.add(new Book(5, "The Insider Trading Trap", "Mark Dagullasion"));

	}

	// List All Books

	public List<Book> getAllBooks() {
		return list;
	}

	// Book by Id

	// Book by Id

	public Book getBookById(int id) {

		Book book = null;
		// book = list.stream().filter(e -> e.getId() == id).findFirst().orElse(null);

		try {
			book = list.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
			
			// book = this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// Add Book

	public Book addBook(Book b) {
		list.add(b);
		System.out.println(b);
		return b;
	}

	// remove book service

	public void removeBook(int id) {

		list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
		return;
	}

	// update book service
	public void modifyBook(Book book, int id) {

		list = list.stream().map(b -> {
			if (b.getId() == id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}

}
