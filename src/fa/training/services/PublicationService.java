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
