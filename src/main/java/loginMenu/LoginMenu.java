package loginMenu;

import accountMenu.AccountMenu;
import firstMenu.Menu;

import java.util.Scanner;
import java.util.logging.Logger;

public class LoginMenu {

    public void printSecondMenu(){
        System.out.println("Please make a selection: ");
        System.out.println("1) Account");
        System.out.println("2) Logout");
    }

    public void runSecondMenu() {

        String chosenOption2;

        while (true) {
            printSecondMenu();
            Scanner choice = new Scanner(System.in);
            System.out.println("Enter your choice");
            chosenOption2 = choice.next();

            if (chosenOption2.equals("1")) {
                AccountMenu accountMenu = new AccountMenu();
                accountMenu.runThirdMenu();
                break;
            } else if (chosenOption2.equals("2")) {
                System.out.println("You have successfully logged out");
                Menu menu = new Menu();
                menu.runMenu();
                break;
            } else if (!chosenOption2.equals("1") || !chosenOption2.equals("2")) {
                System.out.println("Please enter one of the two options! \n");
            }
        }
    }

}
