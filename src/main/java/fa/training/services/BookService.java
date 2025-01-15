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

    public BookService() {
    }

    /**
     * Add a new book to list of publication
     *
     * @param publications List of publication
     */
    public void addNewBook(List<Publication> publications) {
        Book book = createNewBook(publications);
        publications.add(book);
        System.out.println("Add a new book successfully.");
    }

    /**
     * Add an author to book
     *
     * @param publications List of publication
     */
    public void addAnAuthorToBook(List<Publication> publications) {

        if (!this.isExistedBook(publications)) {
            System.out.println("Not existed book.");
            return;
        }

        Book book = findBookByIsbn(publications);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        String author = inputter.inputString("Enter New Author Name: ");
        if (book.getAuthor().add(author)) {
            System.out.println("Add successfully");
        } else {
            System.out.println("Author existed");
        }
    }

    /**
     * Create a new book
     *
     * @param publications List of publication
     * @return a book
     */
    public Book createNewBook(List<Publication> publications) {
        Book book = new Book();
        book.setIsbn(this.inputDistinctIsbn(publications));
        book.setAuthor(this.inputAuthor());
        book.setPublicationPlace(this.inputPublicationPlace());
        book.setPublicationYear(publicationService.inputPublicationYear());
        book.setPublisher(publicationService.inputPublisher());
        book.setPublicationDate(publicationService.inputPublicationDate());
        return book;
    }

    /**
     * Input isbn
     *
     * @return an isbn
     */
    public String inputIsbn() {
        String isbn = "";
        boolean isContinue = true;
        while (isContinue) {
            isbn = inputter.inputString("Enter ISBN: ");
            if (!validator.isValidIsbn(isbn)) {
                System.out.println("Invalid ISBN.");
            } else {
                isContinue = false;
            }
        }
        return isbn;
    }

    /**
     * Input an isbn which not existed in list of publication
     *
     * @param publications List of publication
     * @return a distinct isbn
     */
    public String inputDistinctIsbn(List<Publication> publications) {
        String isbn = "";
        boolean isContinue = true;
        while (isContinue) {
            isbn = this.inputIsbn();
            if (isDuplicateIsbn(isbn, publications)) {
                System.out.println("ISBN already exists.");
            } else {
                isContinue = false;
            }
        }
        return isbn;
    }

    /**
     * Check if an isbn existed in list of publication
     *
     * @param isbn         an isbn
     * @param publications List of publication
     * @return true if an isbn existed in list of publication
     */
    public boolean isDuplicateIsbn(String isbn, List<Publication> publications) {
        for (Publication publication : publications) {
            if (((Book) publication).getIsbn().equalsIgnoreCase(isbn)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Input an author
     *
     * @return a set of author
     */
    public Set<String> inputAuthor() {
        Set<String> author = new HashSet<>();
        author.add(inputter.inputString("Enter Author Name: "));
        return author;
    }

    /**
     * Input a publication place
     *
     * @return a publication place
     */
    public String inputPublicationPlace() {
        return inputter.inputString("Enter Publication Place: ");
    }

    /**
     * Check if any book existed in list of publication
     *
     * @param publications List of publication
     * @return true if any book existed in list of publication
     */
    public boolean isExistedBook(List<Publication> publications) {
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find a book by inputted isbn
     *
     * @param publications List of publication
     * @return a found book, or else return null
     */
    private Book findBookByIsbn(List<Publication> publications) {
        String isbn = inputIsbn();
        for (Publication publication : publications) {
            if (((Book) publication).getIsbn().contains(isbn)) {
                return (Book) publication;
            }
        }
        return null;
    }
}
