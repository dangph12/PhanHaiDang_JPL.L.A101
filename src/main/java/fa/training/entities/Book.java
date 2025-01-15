package fa.training.entities;

import java.util.HashSet;
import java.util.Set;

public class Book extends Publication {
    private String isbn;
    private Set<String> author;
    private String publicationPlace;

    public Book() {
        this.author = new HashSet<>();
    }

    /**
     *
     */
    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Book: " +
                "isbn='" + isbn + '\'' +
                ", author=" + author +
                ", publicationPlace='" + publicationPlace + '\''
                + ", " + super.toString();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getAuthor() {
        return author;
    }

    public void setAuthor(Set<String> author) {
        this.author = author;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }
}
