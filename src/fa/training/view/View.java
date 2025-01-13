package fa.training.view;

import fa.training.common.MenuOption;

public class View {

    /**
     * Show list of menu option except invalid option
     */
    public void showMenuOptionExceptInvalidOption() {
        System.out.println("LIBARY MANAGEMENT");
        for(MenuOption menuOption: MenuOption.values()) {
            if (menuOption != MenuOption.INVALID_OPTION) {
                System.out.println(menuOption.getLabel());
            }
        }
    }

    public View() {
    }
}
