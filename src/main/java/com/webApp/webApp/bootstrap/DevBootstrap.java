package com.webApp.webApp.bootstrap;

import com.webApp.webApp.model.Author;
import com.webApp.webApp.model.Book;
import com.webApp.webApp.repositories.AuthorRepository;
import com.webApp.webApp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData(){

        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book1);

        Author sb = new Author("Someone", "Else");
        Book book2 = new Book("New Book", "3456", "New Publisher");
        sb.getBooks().add(book2);

        authorRepository.save(sb);
        bookRepository.save(book2);
    }


}
