package cache;
import entity.Account;
import entity.UserInfo;
import repository.AccountRepository;

import java.util.List;

/**
 * CacheUserData class
 * when you login, the user is loaded from the db;
 * when you logout, the user is deleted, so you can have a new date when you login with other user
 *
 * @author Stoica Ioana-Dana
 */
public class CacheUserData {

    private UserInfo userInfo;
    List<Account> accountList;
    private static CacheUserData instance = null;

    /**
     * constructor, private for Singleton
     */
    private CacheUserData() {
    }

    /**
     * Singleton Design Pattern
     *
     * @return a single instance of the class
     */
    public static CacheUserData getInstance(){
        if(instance == null){
            instance = new CacheUserData();
        }
        return instance;
    }

    public void populateAccountList(){
        List<Account> accountList = this.userInfo.getAccountList();
        if (accountList.size() == 0) {
            AccountRepository accountRepository = new AccountRepository();
            accountList = accountRepository.getListOfAccountsFromDb(this.userInfo.getId());
        }
        this.accountList=accountList;
    }

    public void updateAccountList(){
        AccountRepository accountRepository = new AccountRepository();
        this.accountList = accountRepository.getListOfAccountsFromDb(this.userInfo.getId());
    }


    public static void destroyCache(){
        instance = null;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
