package third.menu;

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
}