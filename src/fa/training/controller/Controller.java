package fa.training.controller;

import fa.training.common.MenuOption;
import fa.training.utils.Inputter;
import fa.training.view.View;

public class Controller {
    private View view = new View();
    private Inputter inputter = new Inputter();

    public Controller() {
    }

    public void handleSelectMenuOption() {
        boolean isContinue = true;
        while (isContinue) {

            view.showMenuOptionExceptInvalidOption();

            int choice = inputter.inputInteger("Select an option: ");
            MenuOption menuChoice = this.getMenuOptionFromValue(choice);

            switch (menuChoice) {
                case ADD_NEW_BOOK:
                    System.out.println("Add a new book successfully.");
                    break;
                case ADD_NEW_MAGAZINE:
                    System.out.println("Add a new magazine successfully.");
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

    public MenuOption getMenuOptionFromValue(int value) {
        for (MenuOption menuOption : MenuOption.values()) {
            if (menuOption.getValue() == value) {
                return menuOption;
            }
        }
        return MenuOption.INVALID_OPTION;
    }
}
