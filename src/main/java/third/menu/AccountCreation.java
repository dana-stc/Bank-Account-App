package third.menu;

import constants.FileConstants;
import entity.AccountInfo;
import read.console.ConsoleReader;
import read.file.CustomFileReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

public class AccountCreation {

    private final static Logger LOGGER = Logger.getLogger(AccountCreation.class.getName());

    public void addAccountInformationsIntoFile() {

        ConsoleReader reader = ConsoleReader.getInstance();
        AccountInfo account = new AccountInfo();

        while (true) {
            System.out.println("Enter your account number");
            account.setAccountNumber(reader.readFromConsole());
            System.out.println("Enter your user name");
            account.setUserName(reader.readFromConsole());
            System.out.println("Enter the amount of your account");
            account.setAmount(new BigDecimal(reader.readFromConsole()));
            System.out.println("Enter the account type - Euro or Ron - ");
            account.setAccountType(reader.readFromConsole());

            CustomFileReader fileReader = new CustomFileReader();
            // add multiple objects into the file
            List<AccountInfo> accountList = fileReader.readFromFileAny(FileConstants.ACCOUNT_FILE);
            accountList.add(account);


            // write into file
            if (account.verifyInfo()) {
                fileReader.writeFromFileAny(FileConstants.ACCOUNT_FILE, accountList);
                break;
            } else
                System.out.println("Invalid data; please re-enter your informations! ");
        }
    }
}
