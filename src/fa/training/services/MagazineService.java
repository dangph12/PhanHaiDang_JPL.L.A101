package fa.training.services;

import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import fa.training.utils.Inputter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MagazineService {

    private final Inputter inputter = new Inputter();
    private final PublicationService publicationService = new PublicationService();

    public void addNewMagazine(List<Publication> publications) {
        Magazine magazine = createNewMagazine();
        publications.add(magazine);

        publications.sort(Comparator.comparing(Publication::getPublicationDate));

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
