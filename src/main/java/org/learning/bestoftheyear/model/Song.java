package org.learning.bestoftheyear.model;

public class Song {

  // attributi
  private int id;
  private String title;
  private String author;

  // costruttore con parametri

  public Song(int id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }

  // costruttore vuoto

  public Song() {
  }

  // getter e setter

  public int getId() {
    return id;
  }

  public void setId(int id) {
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
}
