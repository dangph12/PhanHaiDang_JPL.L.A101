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

    public int inputPublicationYear() {
        int publicationYear = 0;
        boolean isContinue = true;
        while (isContinue) {
            publicationYear = inputter.inputInteger("Enter publication year (year >= 1900): ");
            if (!validator.isValidYear(publicationYear)) {
                System.out.println("Enter year after 1900");
            } else {
                isContinue = false;
            }
        }
        return publicationYear;
    }

    public String inputPublisher() {
        String publisher = inputter.inputString("Enter publisher: ");
        return publisher;
    }

    public Date inputPublicationDate() {
        Date publicationDate = inputter.inputDate("Enter publication date (dd-MM-yyyy): ");
        return publicationDate;
    }
}
