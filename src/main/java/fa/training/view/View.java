package fa.training.view;

import fa.training.common.MenuOption;

public class View {

    public View() {
    }

    /**
     * Show list of menu option except invalid option
     */
    public void showMenuOptionExceptInvalidOption() {
        System.out.println("LIBRARY MANAGEMENT");
        for (MenuOption menuOption : MenuOption.values()) {
            if (menuOption != MenuOption.INVALID_OPTION) {
                System.out.println(menuOption.getLabel());
            }
        }
    }
}
