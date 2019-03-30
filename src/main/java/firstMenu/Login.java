package firstMenu;

import loginMenu.LoginMenu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    public boolean verification(String username, String password) {

        final String FILENAME = System.getProperty("user.dir") + "\\src\\main\\resources\\myFile.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String line =  br.readLine();
            Integer lineNumber = 1;

            while (line != null) {
                String[] output  = line.split(" ");
                if(output.length == 2) {
                    if (output[0].equals(username)) {
                        if (output[1].equals(password)) {
                            System.out.println("Welcome, " + username);
                            return true;
                        }
                    }
                }
                else
                    System.out.println("Eroare la linia" + lineNumber );

                line =  br.readLine();
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("An error has occured while processing the file");
            e.printStackTrace();
        }
        return false;
    }


    public void loginMenu() {

        while (true) {
            Scanner string = new Scanner(System.in);
            System.out.println("Enter the username");
            String username = string.next();

            System.out.println("Enter the password");
            String password = string.next();

            boolean ifLoggedIn = this.verification(username, password);

            if (!ifLoggedIn) {
                System.out.println("Wrong username/password ");
            }
            else
            {
                LoginMenu secondMenu = new LoginMenu();
                secondMenu.runSecondMenu();
                break;
            }
        }
    }


}



