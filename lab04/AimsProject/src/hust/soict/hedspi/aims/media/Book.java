package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(String title, String category, float cost, String author) {
        super(title, category, cost);
        this.addAuthor(author);
    }
    
    public Book(String title, String category, float cost) {
    	super(title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            System.out.println("Already Exist!");
        } else {
            this.authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (!this.authors.contains(authorName)) {
            System.out.println("Do not Exist!");
        } else {
            this.authors.remove(authorName);
        }
    }
    @Override
    public String toString() {
        return "Book - " + super.toString() + " | Authors: " + String.join(", ", authors);
    }

}