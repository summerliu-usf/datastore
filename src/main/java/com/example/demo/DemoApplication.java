package com.example.demo;

import java.util.List;

import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;


@ShellComponent
@SpringBootApplication
public class DemoApplication {
    @Autowired
    BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @ShellMethod("Saves a book to Cloud Datastore: ")
    public String saveBook(String title, String description, String coverImageUrl, String chapterList) {
        Book savedBook = BookService.addBook(title, coverImageUrl, chapterList);
        savedBook.setDescription(description);
        return savedBook.toString();
    }

    @ShellMethod("Loads all books")
    public String findAllBooks() {
        Iterable<Book> books = this.bookRepository.findAll();
        return Lists.newArrayList(books).toString();
    }


}

