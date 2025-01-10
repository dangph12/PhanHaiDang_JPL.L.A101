package fa.training.services;

import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import fa.training.utils.Inputter;
import fa.training.utils.Validator;

import java.util.Comparator;
import java.util.List;

public class MagazineService {

    private final Inputter inputter = new Inputter();
    private final Validator validator = new Validator();
    private final PublicationService publicationService = new PublicationService();

    public void addNewMagazine(List<Publication> publications) {
        Magazine magazine = createNewMagazine();
        publications.add(magazine);
        publications.sort(new Comparator<Publication>() {

            /**
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return
             */
            @Override
            public int compare(Publication o1, Publication o2) {
                return o1.getPublicationDate().compareTo(o2.getPublicationDate());
            }
        });
        System.out.println("Add a new magazine successfully.");
    }

    public Magazine createNewMagazine() {
        Magazine magazine = new Magazine();
        magazine.setAuthor(this.inputAuthor());
        magazine.setVolumn(this.inputVolumn());
        magazine.setEdition(this.inputEdition());
        magazine.setPublicationYear(publicationService.inputPublicationYear());
        magazine.setPublisher(publicationService.inputPublisher());
        magazine.setPublicationDate(publicationService.inputPublicationDate());
        return magazine;
    }

    public String inputAuthor() {
        return inputter.inputString("Enter Author: ");
    }

    public int inputVolumn() {
        return inputter.inputInteger("Enter Volumn: ");
    }

    public int inputEdition() {
        return inputter.inputInteger("Enter Edition: ");
    }
}
