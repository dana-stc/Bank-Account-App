package account;

import constants.FileConstants;
import entity.AccountInfo;
import read.console.ConsoleReader;
import read.file.CustomFileReader;

import java.math.BigDecimal;
import java.util.List;

public class PaymentFunctionality {

    public void transferSomeMoney(){

        String chosenOption;
        ConsoleReader reader = ConsoleReader.getInstance();
        CustomFileReader customFileReader = new CustomFileReader();
        List<AccountInfo> accountList = customFileReader.readFromFileAny(FileConstants.ACCOUNT_FILE);

        System.out.println("-------------------------------------------");
        AccountDisplayer accountDisplaying = new AccountDisplayer();
        accountDisplaying.printAccountForPayment(accountList);
        System.out.println("-------------------------------------------");

        System.out.println("Please enter a choice for the account from which you want to make the transfer");
        chosenOption = reader.readFromConsole();

        if(chosenOption.matches("[0-9]+") && Integer.parseInt(chosenOption) <  accountList.size() + 1) {

            AccountInfo currentAccount = accountList.get(Integer.parseInt(chosenOption) - 1);
            System.out.println("Please enter the amount that you want to transfer");
            chosenOption = reader.readFromConsole();
            if (chosenOption.matches("[0-9]+") && new BigDecimal(chosenOption).compareTo(currentAccount.getAmount()) <= 0 )
            {
                BigDecimal chosenAmount = new BigDecimal(chosenOption);
                System.out.println("-------------------------------------------");
                accountDisplaying.printAccountByType(accountList,currentAccount.getAccountType(), currentAccount.getAccountNumber() );
                System.out.println("-------------------------------------------");
                System.out.println("Please enter the account where you want to make the transfer");

            }
            else {
                System.out.println("Please enter an amount <= than the current amount! ");
            }
        }
        else {
            System.out.println("Please enter a valid option! ");
        }



      //  chosenOption = reader.readFromConsole();
    }
}
