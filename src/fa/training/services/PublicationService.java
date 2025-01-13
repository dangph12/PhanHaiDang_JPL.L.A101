package fa.training.services;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import fa.training.utils.Inputter;
import fa.training.utils.Validator;

import java.util.*;

public class PublicationService {

    private final Inputter inputter = new Inputter();
    private final Validator validator = new Validator();

    public void listSamePublicationYearAndPublisher(List<Publication> publications) {
        int publicationYear = inputPublicationYear();
        String publisher = inputPublisher();
        boolean isFound = false;
        for (Publication publication : publications) {
            boolean isEqual = (publication.getPublicationYear() == publicationYear) && (publication.getPublisher().equalsIgnoreCase(publisher));
            if (isEqual) {
                publication.display();
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Publication not found");
        } else {
            System.out.println("List all publications which have same publication's year and publisher successfully.");
        }
    }

    public void countPublicationByPublicationYear(List<Publication> publications) {
        Map<Integer,Integer> map = new HashMap<>();

        for (Publication publication: publications) {
            // if not found then put new
            // or else inc count by 1
            map.compute(publication.getPublicationYear(), (k, countOfPublicationYear) -> (countOfPublicationYear == null) ? 1 : countOfPublicationYear + 1);
        }

        if (map.isEmpty()) {
            System.out.println("Publication not found");
            return;
        }

        System.out.println("Year : Count");
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void searchPublicationByIsbnOrAuthorOrPublisher(List<Publication> publications) {
        String search = inputter.inputString("Enter search term: ");
        Set<Publication> foundPublications = new HashSet<>();
        for (Publication publication: publications) {
            if (publication.getPublisher().equalsIgnoreCase(search)) {
                foundPublications.add(publication);
            }

            if (publication instanceof Book) {
                Book book = (Book) publication;
                if (isMatchingBook(book, search)) {
                    foundPublications.add(publication);
                }
            }

            if (publication instanceof Magazine) {
                Magazine magazine = (Magazine) publication;
                if (isMatchingMagazine(magazine, search)) {
                    foundPublications.add(publication);
                }
            }
        }

        if (foundPublications.isEmpty()) {
            System.out.println("Publication not found");
            return;
        }

        for (Publication publication: foundPublications) {
            publication.display();
        }
        System.out.println("Search by isbn or author or publisher successfully.");
    }

    public int inputPublicationYear() {
        int publicationYear = 0;
        boolean isContinue = true;
        while (isContinue) {
            publicationYear = inputter.inputInteger("Enter publication year (year > 1752): ");
            if (!validator.isValidYear(publicationYear)) {
                System.out.println("Enter year after 1752");
            } else {
                isContinue = false;
            }
        }
        return publicationYear;
    }

    public String inputPublisher() {
        return inputter.inputString("Enter publisher: ");
    }

    public Date inputPublicationDate() {
        return inputter.inputDate("Enter publication date (dd-MM-yyyy): ");
    }

    public boolean isMatchingMagazine(Magazine magazine, String search) {
        return magazine.getAuthor().equalsIgnoreCase(search);
    }

    }
}
