package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "books")
public class Book {
  @Id
  Long id;

  String title;

  String author;

  int year;

  String userId;

  public Book() {}

  public Book(String title, String author, int year, String userId) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.userId = userId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "{" +
        "id:" + id +
        ", title:'" + title + '\'' +
        ", author:'" + author + '\'' +
        ", year:" + year +
        ", userId:" + userId +
        '}';
  }
}
