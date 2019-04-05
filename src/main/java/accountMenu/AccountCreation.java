package accountMenu;

import constants.FileConstants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountCreation {

    private final static Logger LOGGER = Logger.getLogger( AccountCreation.class.getName());

    public void addAccountInformationsIntoFile() {

        Scanner option = new Scanner(System.in);
        BufferedWriter out = null;
        String file = FileConstants.FILENAME + "accountFile.txt";

        try
        {
            out = new BufferedWriter(new FileWriter(file));
            AccountInfo account = new AccountInfo();

            while (true) {
                System.out.println("Enter your account number");
                account.setAccountNumber(option.next());
                System.out.println("Enter your user name");
                account.setUserName(option.next());
                System.out.println("Enter the amount of your account");
                account.setAmount(option.nextBigDecimal());
                System.out.println("Enter the account type - Euro or Ron - ");
                account.setAccountType(option.next());

                // write into file
                if (account.verifyInfo()) {
                    out.write(account.getAccountNumber() + " " + account.getUserName() + " " +
                            account.getAmount().toString() + " " + account.getAccountType());
                    System.out.println("Au fost adaugate datele in fisier.");
                    break;

                } else
                    System.out.println("Invalid data; please re-enter your informations! ");
            }
        }
        catch ( IOException e)
        {
            LOGGER.log(Level.SEVERE, "An error has occured while processing the file" );
            LOGGER.log(Level.SEVERE, e.getMessage() );
        }

        finally {
            try {
                if ( out != null)
                out.close();
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "An error has occured while closing the file" );
                LOGGER.log(Level.SEVERE, e.getMessage() );
            }
        }
    }
}
