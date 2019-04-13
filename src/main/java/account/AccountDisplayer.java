package account;

import cache.CacheUserData;
import entity.AccountInfo;
import java.util.logging.Logger;

public class AccountDisplayer {

    private final static Logger LOGGER = Logger.getLogger( AccountDisplayer.class.getName());


    public void printAccountFile() {
        CacheUserData cache = CacheUserData.getInstance();
        for(AccountInfo cont: cache.getListAccounts())
        {
            System.out.println(cont);
        }
    }

    public void printAccountForPayment() {
        CacheUserData cache = CacheUserData.getInstance();
        for(int i=0;i < cache.getListAccounts().size(); i++)
        {
            System.out.println(i+1 + " " + cache.getListAccounts().get(i));
        }
    }


    public void printAccountByType(String type, String accountNumber) {
        CacheUserData cache = CacheUserData.getInstance();
        for(int i=0; i < cache.getListAccounts().size(); i++)
        {
            AccountInfo account =  cache.getListAccounts().get(i);

            if(type.equals(account.getAccountType()) && !accountNumber.equals(account.getAccountNumber()) )
            System.out.println(i+1 + " " + account);
        }
    }

}