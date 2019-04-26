/**
 * @Author Stoica Ioana-Dana
 */

package account;

import cache.CacheUserData;
import entity.AccountInfo;

public class AccountDisplayer {

    /**
     * prints the content of an account
     */
    public void printAccountFile() {
        CacheUserData cache = CacheUserData.getInstance();
        for(AccountInfo cont: cache.getListAccounts())
        {
            System.out.println(cont);
        }
    }

    /**
     * prints the content of the accounts with a number before it - for the option
     */
    public void printAccountForPayment() {
        CacheUserData cache = CacheUserData.getInstance();
        for(int i=0;i < cache.getListAccounts().size(); i++)
        {
            System.out.println(i+1 + " " + cache.getListAccounts().get(i));
        }
    }

    /**
     *  prints the content of the accounts that are the same type with the account chosen + a number before it - for the option
     * @param type the type of the account chosen by the user
     * @param accountNumber the account number of the account chosen by the user
     */
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