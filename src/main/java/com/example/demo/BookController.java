package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookController {
  private final BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @PostMapping("/saveBook")
  @CrossOrigin(origins = "*")
  public String saveBook(@RequestBody Book book) {
    if (book == null) {
      return "The book is invalid";
    }
    this.bookRepository.save(book);
    return "success";
  }

  @GetMapping("/findByAuthor")
  @ResponseBody
  @CrossOrigin(origins = "*")
  public List<Book> findByAuthor(@RequestParam String author) {
    Iterable<Book> books = this.bookRepository.findByAuthor(author);
    List<Book> bookList = new ArrayList<>();
    books.forEach(bookList::add);
    return bookList;
  }

  @GetMapping("/findAllBooks")
  @ResponseBody
  @CrossOrigin(origins = "*")
  public List<Book> findAllBooks() {
    Iterable<Book> books = this.bookRepository.findAll();
    List<Book> bookList = new ArrayList<>();
    books.forEach(bookList::add);
    return bookList;
  }

  @GetMapping("/findByUserId")
  @ResponseBody
  @CrossOrigin(origins = "*")
  public List<Book> findByUserId(@RequestParam String userId) {
    Iterable<Book> books = this.bookRepository.findByUserId(userId);
    List<Book> bookList = new ArrayList<>();
    books.forEach(bookList::add);
    return bookList;
  }

  @GetMapping("/findByYear")
  @ResponseBody
  @CrossOrigin(origins = "*")
  public List<Book> findByYear(@RequestParam int year) {
    Iterable<Book> books = this.bookRepository.findByYearGreaterThan(year);
    List<Book> bookList = new ArrayList<>();
    books.forEach(bookList::add);
    return bookList;
  }
}
