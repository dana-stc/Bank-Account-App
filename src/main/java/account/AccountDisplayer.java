package account;

import constants.FileConstants;
import entity.AccountInfo;
import read.file.CustomFileReader;
import java.util.List;
import java.util.logging.Logger;

public class AccountDisplayer {

    private final static Logger LOGGER = Logger.getLogger( AccountDisplayer.class.getName());


    public void printAccountFile() {
        CustomFileReader customFileReader = new CustomFileReader();
        List<AccountInfo> accountList = customFileReader.readFromFileAny(FileConstants.ACCOUNT_FILE);

        for(AccountInfo cont: accountList)
        {
            System.out.println(cont);
        }
    }

    public void printAccountForPayment(List<AccountInfo> accountList) {

        for(int i=0;i < accountList.size(); i++)
        {
            System.out.println(i+1 + " " + accountList.get(i));
        }
    }


    public void printAccountByType(List<AccountInfo> accountList, String type, String accountNumber) {
        for(int i=0; i < accountList.size(); i++)
        {
            AccountInfo account = accountList.get(i);

            if(type.equals(account.getAccountType()) && !accountNumber.equals(account.getAccountNumber()) )
            System.out.println(i+1 + " " + account);
        }
    }

}