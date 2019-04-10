package menus;

import entity.UserInfo;
import read.console.ConsoleReader;
import account.AccountCreation;
import account.AccountDisplayer;

public class AccountMenu {

    private void printThirdMenu() {
        System.out.println("Please make a selection: ");
        System.out.println("1) Create account");
        System.out.println("2) Display accounts");
        System.out.println("3) Back to login menu");
    }

    public void runThirdMenu(UserInfo currentUser) {

        String chosenOption3;
        ConsoleReader reader = ConsoleReader.getInstance();
        while (true) {
            printThirdMenu();
            System.out.println("Enter your choice");
            chosenOption3 = reader.readFromConsole();

            if (chosenOption3.equals("1")) {
                AccountCreation createAccount = new AccountCreation();
                createAccount.addAccountInformationsIntoFile(currentUser);

            } else if (chosenOption3.equals("2")) {
                AccountDisplayer accountDisplaying = new AccountDisplayer();
                accountDisplaying.printAccountFile();

            }else if (chosenOption3.equals("3")) {
                LoginMenu loginMenu = new LoginMenu();
                loginMenu.runSecondMenu(currentUser);
                break;
            } else if (!chosenOption3.equals("1") || !chosenOption3.equals("2")) {
                System.out.println("Please enter one of the two options! \n");
            }
        }
    }

}