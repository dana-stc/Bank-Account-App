package cache;
import entity.UserInfo;

/**
 * CacheUserData class
 * when you login, the user is loaded from the db;
 * when you logout, the user is deleted, so you can have a new date when you login with other user
 *
 * @author Stoica Ioana-Dana
 */
public class CacheUserData {

    private UserInfo userInfo;
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


    public static void destroyCache(){
        instance = null;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
