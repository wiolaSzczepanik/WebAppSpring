package com.webApp.webApp.bootstrap;

import com.webApp.webApp.model.Author;
import com.webApp.webApp.model.Book;
import com.webApp.webApp.model.Publisher;
import com.webApp.webApp.repositories.AuthorRepository;
import com.webApp.webApp.repositories.BookRepository;
import com.webApp.webApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("New publisher");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book1);
        Publisher publisher1 = new Publisher("New", "123 Street");
        Author sb = new Author("Someone", "Else");
        Book book2 = new Book("New Book", "3456", publisher1);
        sb.getBooks().add(book2);

        publisherRepository.save(publisher1);
        authorRepository.save(sb);
        bookRepository.save(book2);
    }


}
