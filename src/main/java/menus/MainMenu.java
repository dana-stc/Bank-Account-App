package menus;

import login.Login;
import read.console.ConsoleReader;

public class MainMenu {

    public void printHeader() {
        System.out.println("+---------------------------------------+");
        System.out.println("|             Welcome to our            |");
        System.out.println("|            Menu application           |");
        System.out.println("+---------------------------------------+");
    }

    public void printMenu() {
        System.out.println("Please make a selection: ");
        System.out.println("1) Login");
        System.out.println("2) Exit");
    }

    public void runMenu() {
        printHeader();
        String chosenOption;
        ConsoleReader reader = ConsoleReader.getInstance();
        while (true) {
            printMenu();
            System.out.println("Enter your choice");
            chosenOption = reader.readFromConsole();

            if (chosenOption.equals("1")) {
                Login login = new Login();
                login.loginMenu();
                break;
            } else if (chosenOption.equals("2")) {
                System.out.println("Thank you for using our application! ");
                break;
            } else if (!chosenOption.equals("1") || !chosenOption.equals("2")) {
              System.out.println("Please re-enter an valid option! ");
            }
        }
        reader.closeScaner();
    }


}

