/**
 * Login class
 * implements the logic for loginș user and password verifications
 * @Author Stoica Ioana-Dana
 */

package login;

import cache.CacheUserData;
import constants.FileConstants;
import entity.UserInfo;
import menus.LoginMenu;
import read.console.ConsoleReader;
import read.file.CustomFileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {

    private final static Logger LOGGER = Logger.getLogger( Login.class.getName());

    /**
     * verify the user and the password
     * @param username the username of the user readed from keyboard
     * @param password the password of the user readed from keyboard
     * @return the current user
     */
    private UserInfo verifyWithObjects(String username, String password){

        UserInfo myUser = new UserInfo(username, password);
        CustomFileReader fileReader = new CustomFileReader();

        //lista user existenti
        List<UserInfo> myList =  fileReader.readFromFileAny(FileConstants.USER_FILE);
        if(myList.size() > 0){
            for(UserInfo user: myList)
            {
                if(user.equals(myUser))
                    return myUser;
            }
            return null;
        }
        //When the file is empty, insert the first user
        else {
            List<UserInfo> user = new ArrayList<>();
            user.add(myUser);
            if(fileReader.writeFromFileAny(FileConstants.USER_FILE, user)){
                return myUser;
            }
            LOGGER.log(Level.SEVERE,"Error inserting user into the database");
            return null;
        }
    }


    /**
     * verify if it is a user from the list of users
     * if it is, you login in the cache memory the accounts of the current user
     */
    public void loginMenu(){
        ConsoleReader reader = ConsoleReader.getInstance();
        while (true) {
            System.out.println("Enter the username");
            String username = reader.readFromConsole();

            System.out.println("Enter the password");
            String password = reader.readFromConsole();

            UserInfo currentUser = this.verifyWithObjects(username, password);

            if (currentUser == null) {
                System.out.println("Wrong username/password");
            }
            else
            {
                CacheUserData cacheUserData = CacheUserData.getInstance(); // asa iau instanta unica
                cacheUserData.setUserInfo(currentUser);
                cacheUserData.populateListOfAccounts();

                LoginMenu secondMenu = new LoginMenu();
                secondMenu.runSecondMenu();
                break;
            }
        }
    }

}



