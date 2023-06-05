package com.morningcoffee.baliktanaw.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.morningcoffee.baliktanaw.models.Book;

@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {


//	Page<Book> findAll(Pageable pageable);
	
	List<Book> findTop10ByOrderByNameDesc();
	
	List<Book> findByName(@Param("name") String name, @Param("page") Pageable pageable);
	
}
