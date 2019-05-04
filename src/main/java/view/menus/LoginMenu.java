
package view.menus;

import cache.CacheUserData;
import service.account.PaymentFunctionality;
import service.exceptions.UnacceptableTransferException;
import service.read.console.ConsoleReader;

/**
 * LoginMenu class
 * the menu after you login with a user
 * @Author Stoica Ioana-Dana
 */
public class LoginMenu {

    private void printSecondMenu(){
        System.out.println("Please make a selection: ");
        System.out.println("1) Account");
        System.out.println("2) Transfer money");
        System.out.println("3) Logout");
    }

    public void runSecondMenu() {
        String chosenOption2;
        ConsoleReader reader = ConsoleReader.getInstance();

        while (true) {
            printSecondMenu();
            System.out.println("Enter your choice");
            chosenOption2 = reader.readFromConsole();

            if (chosenOption2.equals("1")) {
                AccountMenu accountMenu = new AccountMenu();
                accountMenu.runThirdMenu();
                break;
            }else if (chosenOption2.equals("2")) {
                PaymentFunctionality transferSomeMoney = new PaymentFunctionality();
                try {
                    transferSomeMoney.transferMoney();
                } catch (UnacceptableTransferException e) {
                    System.out.println("Error, transfers not allowed here ");
                }

            }else if (chosenOption2.equals("3")) {
                System.out.println("You have successfully logged out");
                CacheUserData.destroyCache();
                MainMenu menu = new MainMenu();
                menu.runMenu();

                break;
            } else if (!chosenOption2.equals("1") || !chosenOption2.equals("2")|| !chosenOption2.equals("3")) {
                System.out.println("Please enter one of the two options! \n");
            }
        }
    }

}
