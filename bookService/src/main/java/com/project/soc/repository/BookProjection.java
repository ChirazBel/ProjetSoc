package com.project.soc.repository;

import org.springframework.data.rest.core.config.Projection;

import com.project.soc.model.Book;

@Projection(name = "bookProjection", types = { Book.class })
public interface BookProjection {
	Long getIsbn();
    String getTitre();
    String getEtat();
}
