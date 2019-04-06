package menus;

import read.console.ConsoleReader;
import third.menu.AccountCreation;
import third.menu.AccountDisplayer;

public class AccountMenu {

    public void printThirdMenu() {
        System.out.println("Please make a selection: ");
        System.out.println("1) Create account");
        System.out.println("2) Display accounts");
    }

    public void runThirdMenu() {

        String chosenOption3;
        ConsoleReader reader = ConsoleReader.getInstance();
        while (true) {
            printThirdMenu();
            System.out.println("Enter your choice");
            chosenOption3 = reader.readFromConsole();

            if (chosenOption3.equals("1")) {
                AccountCreation createAccount = new AccountCreation();
                createAccount.addAccountInformationsIntoFile();

            } else if (chosenOption3.equals("2")) {
                AccountDisplayer accountDisplaying = new AccountDisplayer();
                accountDisplaying.printAccountFile();

            } else if (!chosenOption3.equals("1") || !chosenOption3.equals("2")) {
                System.out.println("Please enter one of the two options! \n");
            }
        }
    }

}