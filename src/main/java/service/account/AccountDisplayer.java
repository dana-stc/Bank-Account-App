
package service.account;

import cache.CacheUserData;
import entity.Account;
import repository.AccountRepository;

import java.util.List;

/**
 * @Author Stoica Ioana-Dana
 */
public class AccountDisplayer {

    /**
     * prints the content of an account
     */
    public void printAccounts() {
        CacheUserData cacheUserData = CacheUserData.getInstance();
        List<Account> accountList = cacheUserData.getUserInfo().getAccountList();
        if (accountList.size() == 0) {
            AccountRepository accountRepository = new AccountRepository();
            accountList = accountRepository.getListOfAccountsFromDb(cacheUserData.getUserInfo().getId());
        }
        System.out.println("------------ The accounts of the current user: ------------");
        for (Account currentAccount : accountList) {
            System.out.println(currentAccount);
        }
    }

    /**
     * prints the content of the accounts with a number before it - for the option
     */
    public void printAccountForPayment() {
//        CacheUserData cache = CacheUserData.getInstance();
//        for(int i=0;i < cache.getListAccounts().size(); i++)
//        {
//            System.out.println(i+1 + " " + cache.getListAccounts().get(i));
//        }
    }

    /**
     * prints the content of the accounts that are the same type with the account chosen + a number before it - for the option
     *
     * @param type          the type of the account chosen by the user
     * @param accountNumber the account number of the account chosen by the user
     */
    public void printAccountByType(String type, String accountNumber) {
//        CacheUserData cache = CacheUserData.getInstance();
//        for(int i=0; i < cache.getListAccounts().size(); i++)
//        {
//            Account account =  cache.getListAccounts().get(i);
//
//            if(type.equals(account.getAccountType()) && !accountNumber.equals(account.getAccountNumber()) )
//            System.out.println(i+1 + " " + account);
//        }
    }

}