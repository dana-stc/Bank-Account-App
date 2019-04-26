/**
 * CacheUserData class
 * reading the file works as a cache;
 * when you login, the user and the accounts are loaded from the memory;
 * when you logout, the data is deleted, so you can have a new date when you login with other user
 *
 * @author Stoica Ioana-Dana
 */

package cache;

import constants.FileConstants;
import entity.AccountInfo;
import entity.UserInfo;
import read.file.CustomFileReader;

import java.util.ArrayList;
import java.util.List;

public class CacheUserData {

    private UserInfo userInfo;
    private List<AccountInfo> listAccounts;
    private static CacheUserData instance = null;

    /**
     * constructor, private for Singleton
     */
    private CacheUserData() {
    }

    public void setUserInfo(UserInfo userInfo){
        this.userInfo = userInfo;
    }

    /**
     * it uploads in the cache memory the list of accounts for the current username
     */
    public void populateListOfAccounts(){
        this.listAccounts = new ArrayList<>();
        CustomFileReader customFileReader = new CustomFileReader();
        List<AccountInfo> accountList = customFileReader.readFromFileAny(FileConstants.ACCOUNT_FILE);

        for(AccountInfo account: accountList){
            if(account.getUserName().equals(this.userInfo.getUserName())){
                this.listAccounts.add(account);
            }
        }
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


    /**
     * save the accounts and users
     */
    public void saveCacheData(){
        CustomFileReader fileReader = new CustomFileReader();
        fileReader.writeFromFileAny(FileConstants.ACCOUNT_FILE, this.listAccounts);
    }


    public static void destroyCache(){
        instance = null;
    }


    public UserInfo getUserInfo() {
        return userInfo;
    }

    public List<AccountInfo> getListAccounts() {
        return listAccounts;
    }
}
