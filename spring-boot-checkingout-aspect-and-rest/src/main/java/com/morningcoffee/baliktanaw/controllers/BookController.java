package com.morningcoffee.baliktanaw.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morningcoffee.baliktanaw.models.Book;
import com.morningcoffee.baliktanaw.repositories.BookRepository;

@RestController
@RequestMapping("books-rest")
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET,   produces = { "application/json" })
	public Optional<Book> getBookById(@PathVariable(value = "id") Long id) {
		return Optional.of(bookRepository.findById(id).orElse(new Book()));
	}
}
