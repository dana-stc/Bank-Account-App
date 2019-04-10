package menus;

import account.PaymentFunctionality;
import entity.UserInfo;
import read.console.ConsoleReader;

public class LoginMenu {

    public void printSecondMenu(){
        System.out.println("Please make a selection: ");
        System.out.println("1) Account");
        System.out.println("2) Transfer money");
        System.out.println("3) Logout");
    }

    public void runSecondMenu(UserInfo currentUser) {

        String chosenOption2;
        ConsoleReader reader = ConsoleReader.getInstance();
        while (true) {
            printSecondMenu();
            System.out.println("Enter your choice");
            chosenOption2 = reader.readFromConsole();

            if (chosenOption2.equals("1")) {
                AccountMenu accountMenu = new AccountMenu();
                accountMenu.runThirdMenu(currentUser);
                break;
            }else if (chosenOption2.equals("2")) {
                PaymentFunctionality transferMoney = new PaymentFunctionality();
                transferMoney.transferSomeMoney();

            }else if (chosenOption2.equals("3")) {
                System.out.println("You have successfully logged out");
                MainMenu menu = new MainMenu();
                menu.runMenu();
                break;
            } else if (!chosenOption2.equals("1") || !chosenOption2.equals("2")|| !chosenOption2.equals("3")) {
                System.out.println("Please enter one of the two options! \n");
            }
        }
    }

}
