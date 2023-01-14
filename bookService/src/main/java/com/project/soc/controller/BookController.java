package com.project.soc.controller;

import org.springframework.web.bind.annotation.*;

import com.project.soc.model.Book;
import com.project.soc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path="/api/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addBook(@RequestBody Book book) {
		 bookService.addBook(book);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Book> getAllBooks() {
	       return bookService.getAllBooks();
	  }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long id) {
		return bookService.deleteBook(id);
	}
	
}
