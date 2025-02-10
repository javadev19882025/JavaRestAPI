package com.jpa.dynamicdb.restapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.dynamicdb.restapi.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findById(int id);

}
