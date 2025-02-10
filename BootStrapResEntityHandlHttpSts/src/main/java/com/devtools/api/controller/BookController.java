package com.devtools.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devtools.api.entities.Book;
import com.devtools.api.services.BookStaticService;

@RestController
public class BookController {

	@Autowired(required = true)
	private BookStaticService bookStaticService;

	// Get All Books Handler

	@GetMapping("api/v2/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = bookStaticService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	// Get Single Books Handler

	@GetMapping("/api/v2/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = bookStaticService.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	// Add Book

	@PostMapping("/api/v2/addbook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		try {
			b = this.bookStaticService.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// Remove Book
	@DeleteMapping("/api/v2/removebook/{id}")
	public ResponseEntity<Void> removeBook(@PathVariable("id") int id) {

		try {
			this.bookStaticService.removeBook(id);
			System.out.println("Book remove successfully");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		// return bookStaticService.getBookById(id);
	}

	// Update Book
	@PutMapping("/api/v2/modifybook/{id}")
	public ResponseEntity<Book> modifyBook(@RequestBody Book book, @PathVariable("id") int id) {

		try {
			this.bookStaticService.modifyBook(book, id);
			System.out.println("Book Data Update Successfully..!");
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
