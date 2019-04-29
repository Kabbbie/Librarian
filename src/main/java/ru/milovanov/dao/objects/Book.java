package ru.milovanov.dao.objects;

public class Book {
    private String isbn,author,title,username;
    public Book(String isbn,String author,String title,String username){
        this.isbn=isbn;
        this.author=author;
        this.title=title;
        this.username=null;
    }
    @Override
    public String toString(){
        return author+" "+title+" "+isbn+" "+username;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
