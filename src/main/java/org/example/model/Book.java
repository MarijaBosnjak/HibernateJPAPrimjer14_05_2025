package org.example.model;

import java.util.HashSet;
import java.util.Set;

public class Book {
    private long id;
    private String title;
    private Set<Author> authors=new HashSet<>();
    public Book() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Book(long id, String title, Set<Author> authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }
}
