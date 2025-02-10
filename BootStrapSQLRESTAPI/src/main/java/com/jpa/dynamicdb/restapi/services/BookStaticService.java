package com.jpa.dynamicdb.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.dynamicdb.restapi.dao.BookRepository;
import com.jpa.dynamicdb.restapi.entities.Book;

@Component
public class BookStaticService {

	@Autowired(required = true)
	public BookRepository bookRepository;

	// List All Books

	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	// Book by Id

	public Book getBookById(int id) {

		Book book = null;

		try {
			book = this.bookRepository.findById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// Add Book

	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}

	// remove book service

	public void removeBook(int id) {

		bookRepository.deleteById(id);
		return;
	}

	// update book service
	public void modifyBook(Book book, int id) {
		book.setId(id);
		bookRepository.save(book);

	}

}
