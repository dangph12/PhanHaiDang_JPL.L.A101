package fa.training.controller;

import fa.training.common.MenuOption;
import fa.training.entities.Publication;
import fa.training.services.BookService;
import fa.training.services.MagazineService;
import fa.training.services.PublicationService;
import fa.training.utils.Inputter;
import fa.training.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public void handleSelectMenuOption() {
        View view = new View();
        Inputter inputter = new Inputter();
        BookService bookService = new BookService();
        MagazineService magazineService = new MagazineService();

        List<Publication> publications = new ArrayList<>();
        boolean isContinue = true;

        while (isContinue) {

            view.showMenuOptionExceptInvalidOption();

            int choice = inputter.inputInteger("Select an option: ");
            MenuOption menuChoice = this.getMenuOptionFromValue(choice);

            switch (menuChoice) {
                case ADD_NEW_BOOK:
                    bookService.addNewBook(publications);
                    showPublications(publications);
                    break;
                case ADD_NEW_MAGAZINE:
                    magazineService.addNewMagazine(publications);
                    showPublications(publications);
                    break;
                case LIST_SAME_PUBLICATION_YEAR_AND_PUBLISHER:
                    System.out.println("List all publications which have same publication's year and publisher successfully.");
                    break;
                case ADD_AN_AUTHOR_TO_BOOK:
                    System.out.println("Add an author to book successfully.");
                    break;
                case TOP_TEN_LARGEST_VOLUME_MAGAZINES:
                    System.out.println("List top ten largest volume magazines successfully.");
                    break;
                case COUNT_PUBLICATION_BY_PUBLICATION_YEAR:
                    System.out.println("Count Publication by publication's year.");
                    break;
                case SEARCH_BY_ISBN_OR_AUTHOR_OR_PUBLISHER:
                    System.out.println("Search by isbn or author or publisher successfully.");
                    break;
                case EXIT:
                    System.out.println("Exit program.");
                    isContinue = false;
                    break;
                case INVALID_OPTION:
                    System.out.println(menuChoice.getLabel());
                    break;
            }
        }
    }

    public void showPublications(List<Publication> publications) {
        for (Publication publication: publications) {
            System.out.println(publication.toString());
        }
    }

    public MenuOption getMenuOptionFromValue(int value) {
        for (MenuOption menuOption : MenuOption.values()) {
            if (menuOption.getValue() == value) {
                return menuOption;
            }
        }
        return MenuOption.INVALID_OPTION;
    }

    /**
     * Show all publications in list for debug
     * @param publications List of publications
     */
    public void showPublications(List<Publication> publications) {
        for (Publication publication: publications) {
            System.out.println(publication.toString());
        }
    }

    public Controller() {
    }
}
