/**
 * @Author Stoica Ioana-Dana
 */

package account;

import cache.CacheUserData;
import constants.FileConstants;
import custom.exceptions.AmountCharacterIntroducingException;
import entity.AccountInfo;
import read.console.ConsoleReader;
import read.file.CustomFileReader;
import java.math.BigDecimal;
import java.util.List;


public class AccountCreator {


    public Boolean verifyInfo(AccountInfo account) {
        if (account.getAccountNumber().length() == 24 && account.getAccountNumber().startsWith("RO") && (account.getAccountType().equals("Euro") || account.getAccountType().equals("Ron")))
            return true;
        return false;
    }

    /**
     * a method for adding account informations readed from the keyboard into the cache file
     * @throws AmountCharacterIntroducingException - characters not allowed in amount
     */
    public void addAccountInformationsIntoFile() throws AmountCharacterIntroducingException {

        ConsoleReader reader = ConsoleReader.getInstance();
        AccountInfo account = new AccountInfo();
        CacheUserData cache = CacheUserData.getInstance();

        while (true) {
            System.out.println("Enter your account number");
            account.setAccountNumber(reader.readFromConsole());
            account.setUserName(cache.getUserInfo().getUserName());
            System.out.println("Enter the amount of your account");
            String ammount = reader.readFromConsole();
            if(!ammount.matches("[0-9]+"))
            {
                throw new AmountCharacterIntroducingException("Characters not allowed in amount");
            }

            account.setAmount(new BigDecimal(ammount));
            System.out.println("Enter the account type - Euro or Ron - ");
            account.setAccountType(reader.readFromConsole());

            CustomFileReader fileReader = new CustomFileReader();

            // write into file
            if (verifyInfo(account)) {
                // add multiple objects into the file
                List<AccountInfo> accountList = fileReader.readFromFileAny(FileConstants.ACCOUNT_FILE);
                accountList.add(account);

                fileReader.writeFromFileAny(FileConstants.ACCOUNT_FILE, accountList);
                cache.populateListOfAccounts();
                break;
            } else
                System.out.println("Invalid data; please re-enter your informations! ");
        }
    }
}
