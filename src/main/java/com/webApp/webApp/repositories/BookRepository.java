package com.webApp.webApp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.webApp.webApp.model.Book;


public interface BookRepository extends CrudRepository<Book, Long>{
}
