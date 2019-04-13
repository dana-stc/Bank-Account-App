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

    private CacheUserData() {
    }

    public void setUserInfo(UserInfo userInfo){
        this.userInfo = userInfo;
    }

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

    // returnez o singura instanta a clasei - Singleton !
    public static CacheUserData getInstance(){
        if(instance == null){
            instance = new CacheUserData();
        }
        return instance;
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
