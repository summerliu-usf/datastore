package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private static BookRepository bookRepository;

    @Autowired
    private ChapterService chapterService; // Use ChapterService here

    public static Book addBook(String title, String coverImageUrl, String chapterList) {
        // Create and save the book instance
        Book book = new Book();
        book.setId(title);
        book.setTitle(title);
        book.setCoverImageUrl(coverImageUrl);
        book.addAllChapters(chapterList);
        return bookRepository.save(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    // Get a specific book by ID
    public Book getBookById(String id) {
        return bookRepository.findById(id);
    }

    // Get chapters for a specific book
    public List<String> getChaptersForBook(String bookId) {
        return bookRepository.getChapterList();
    }

    // Add or update a book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public ArrayList<Chapter> getChapterList(String bookId) {
        Book book = getBookById(bookId);
        return book.getChapterList();
    }
}