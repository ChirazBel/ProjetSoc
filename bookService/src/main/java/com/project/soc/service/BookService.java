package com.project.soc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.soc.model.Book;
import com.project.soc.repository.BookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	 public void addBook(Book book) {
	        Book livre = Book.builder()
	                .isbn(book.getIsbn())
	                .titre(book.getTitre())
	                .auteur(book.getAuteur())
	                .etat(book.getEtat())
	                .build();

	        bookRepository.save(livre);
	        log.info("Book {} is saved", livre.getId());
	    }
	 
	 public List<Book> getAllBooks() {
	       return(List<Book>) bookRepository.findAll();
	  }
	public ResponseEntity<?> deleteBook(Long id) {
		return bookRepository.findById(id).map(book -> {
				bookRepository.delete(book);
				return ResponseEntity.ok().build();
			}).orElseThrow(() -> new IllegalArgumentException("book not found with id " + id));
		}
}
