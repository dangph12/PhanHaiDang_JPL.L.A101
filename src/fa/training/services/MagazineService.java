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

    /**
     * Add a new magazine to list of publication
     * @param publications List of publication
     */
    public void addNewMagazine(List<Publication> publications) {
        Magazine magazine = createNewMagazine();
        publications.add(magazine);

        publications.sort(Comparator.comparing(Publication::getPublicationDate));

        System.out.println("Add a new magazine successfully.");
    }

    /**
     * List top ten largest volume magazines
     * @param publications List of publication
     */
    public void listTopTenLargestVolumeMagazines(List<Publication> publications) {
        List<Publication> magazines = publications.stream().filter(p -> p instanceof Magazine).sorted((o1, o2) -> ((Magazine) o2).getVolume() - ((Magazine) o1).getVolume()).collect(Collectors.toList());

        if (magazines.isEmpty()) {
            System.out.println("No magazines found.");
            return;
        }
        System.out.println("Top 10 magazines found.");
        int i = 0;
        while (i < 10 && i < magazines.size()) {
            magazines.get(i).display();
            i++;
        }
    }

    /**
     * Create a new magazine
     * @return a magazine
     */
    public Magazine createNewMagazine() {
        Magazine magazine = new Magazine();
        magazine.setAuthor(this.inputAuthor());
        magazine.setVolume(this.inputVolume());
        magazine.setEdition(this.inputEdition());
        magazine.setPublicationYear(publicationService.inputPublicationYear());
        magazine.setPublisher(publicationService.inputPublisher());
        magazine.setPublicationDate(publicationService.inputPublicationDate());
        return magazine;
    }

    /**
     * Input author
     * @return a author
     */
    public String inputAuthor() {
        return inputter.inputString("Enter Author: ");
    }

    /**
     * Input volume
     * @return a volume
     */
    public int inputVolume() {
        return inputter.inputInteger("Enter Volume: ");
    }

    /**
     * Input edition
     * @return a edition
     */
    public int inputEdition() {
        return inputter.inputInteger("Enter Edition: ");
    }
}
