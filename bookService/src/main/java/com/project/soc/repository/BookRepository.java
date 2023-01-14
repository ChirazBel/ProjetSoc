package com.project.soc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.soc.model.Book;

@RepositoryRestResource(excerptProjection = BookProjection.class)
public interface BookRepository extends JpaRepository<Book,Long>{
	public Book findBookByIsbn(Long isbn);
	public Book findBookByTitre(String titre);
}
