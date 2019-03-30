package accountMenu;

import java.util.Scanner;

public class AccountMenu {

    public void printThirdMenu() {
        System.out.println("Please make a selection: ");
        System.out.println("1) Create account");
        System.out.println("2) Display accounts");
    }

    public void runThirdMenu() {

        String chosenOption3;
        while (true) {

            printThirdMenu();
            Scanner choice = new Scanner(System.in);
            System.out.println("Enter your choice");
            chosenOption3 = choice.next();

            if (chosenOption3.equals("1")) {
                AccountCreation createAccount = new AccountCreation();
                createAccount.addAccountInformationsIntoFile();

            } else if (chosenOption3.equals("2")) {
                AccountDisplaying accountDisplaying = new AccountDisplaying();
                accountDisplaying.printAccountFile();

            } else if (!chosenOption3.equals("1") || !chosenOption3.equals("2")) {
                System.out.println("Please enter one of the two options! \n");
            }
        }
    }

}