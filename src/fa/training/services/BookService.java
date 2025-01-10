package fa.training.services;

import fa.training.entities.Book;
import fa.training.entities.Publication;
import fa.training.utils.Inputter;
import fa.training.utils.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookService {

    private final Inputter inputter = new Inputter();
    private final Validator validator = new Validator();
    private final PublicationService publicationService = new PublicationService();

    public void addNewBook(List<Publication> publications) {
        Book book = createNewBook(publications);
        publications.add(book);
        System.out.println("Add a new book successfully.");
    }

    public Book createNewBook(List<Publication> publications) {
        Book book = new Book();
        book.setIsbn(this.inputIsbn(publications));
        book.setAuthor(this.inputAuthor());
        book.setPublicationPlace(this.inputPublicationPlace());
        book.setPublicationYear(publicationService.inputPublicationYear());
        book.setPublisher(publicationService.inputPublisher());
        book.setPublicationDate(publicationService.inputPublicationDate());
        return book;
    }

    public String inputIsbn(List<Publication> publications) {
        String isbn = "";
        boolean isContinue = true;
        while (isContinue) {
            isbn = inputter.inputString("Enter ISBN: ");
            if (!validator.isValidIsbn(isbn)) {
                System.out.println("Invalid ISBN.");
            }
            else if (isDuplicateIsbn(isbn, publications)) {
                System.out.println("ISBN already exists.");
            }
            else {
                isContinue = false;
            }
        }
        return isbn;
    }

    public boolean isDuplicateIsbn(String isbn, List<Publication> publications) {
        for (Publication publication: publications) {
            if (((Book) publication).getIsbn().equalsIgnoreCase(isbn)) {
                return true;
            }
        }
        return false;
    }

    public Set<String> inputAuthor() {
        Set<String> author = new HashSet<>();
        author.add(inputter.inputString("Enter Author Name: "));
        return author;
    }

    public String inputPublicationPlace() {
        return inputter.inputString("Enter Publication Place: ");
    }

    public BookService() {
    }
}
