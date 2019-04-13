package menus;

import custom.exceptions.AmountCharacterIntroducingException;
import read.console.ConsoleReader;
import account.AccountCreation;
import account.AccountDisplayer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountMenu {

    private final static Logger LOGGER = Logger.getLogger(AccountCreation.class.getName());

    private void printThirdMenu() {
        System.out.println("Please make a selection: ");
        System.out.println("1) Create account");
        System.out.println("2) Display accounts");
        System.out.println("3) Back to login menu");
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
                try {
                    createAccount.addAccountInformationsIntoFile();
                } catch (AmountCharacterIntroducingException e) {
                   System.out.println("Error, do not use characters in Amount");
                }

            } else if (chosenOption3.equals("2")) {
                AccountDisplayer accountDisplaying = new AccountDisplayer();
                accountDisplaying.printAccountFile();

            }else if (chosenOption3.equals("3")) {
                LoginMenu loginMenu = new LoginMenu();
                loginMenu.runSecondMenu();
                break;
            } else if (!chosenOption3.equals("1") || !chosenOption3.equals("2")) {
                System.out.println("Please enter one of the two options! \n");
            }
        }
    }

}