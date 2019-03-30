package accountMenu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountCreation {

    private final static Logger LOGGER = Logger.getLogger( AccountCreation.class.getName());

    public void addAccountInformationsIntoFile() {

        Scanner option = new Scanner(System.in);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("accountFile.txt"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error has occured while processing the file" );
            LOGGER.log(Level.SEVERE, e.getMessage() );
        }
        try {

            AccountInfo account = new AccountInfo();

            while (true) {
                System.out.println("Enter your account number");
                account.setAccountNumber(option.next());
                System.out.println("Enter your user number");
                account.setUserNumber(new BigDecimal(option.next()));
                System.out.println("Enter the amount of your account");
                account.setAmount(new BigDecimal(option.next()));
                System.out.println("Enter the balance of your account");
                account.setBalance(new BigDecimal(option.next()));
                System.out.println("Enter the account type - Euro or Ron - ");
                account.setAccountType(option.next());


                if (account.verifyInfo()) {
                    out.write(account.getAccountNumber() + " " + account.getUserNumber() + " " +
                            account.getAmount() + " " + account.getBalance() + " " + account.getAccountType());
                    break;
                } else
                    System.out.println("Invalid data; please re-enter your informations! ");
            }

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error has occured while processing the file" );
            LOGGER.log(Level.SEVERE, e.getMessage() );
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "An error has occured while closing the file" );
                LOGGER.log(Level.SEVERE, e.getMessage() );
            }
        }
    }

}
