package service.login;

import cache.CacheUserData;
import entity.UserInfo;
import repository.UserRepository;
import view.menus.LoginMenu;
import service.read.console.ConsoleReader;

import java.util.logging.Logger;

/**
 * Login class
 * implements the logic for login user and password verifications
 * @Author Stoica Ioana-Dana
 */

public class Login {

    private final static Logger LOGGER = Logger.getLogger( Login.class.getName());

    /**
     * verify the user and the password
     * @param username the username of the user read from keyboard
     * @param password the password of the user read from keyboard
     * @return the current user
     */
    private UserInfo verifyWithDb(String username, String password){

        UserRepository userRepository = new UserRepository();
        return userRepository.getCurrentUser(username, password);
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

            UserInfo currentUser = this.verifyWithDb(username, password);

            if (currentUser == null) {
                System.out.println("Wrong username/password");
            }
            else
            {
                CacheUserData cache = CacheUserData.getInstance();
                cache.setUserInfo(currentUser);
                LoginMenu secondMenu = new LoginMenu();
                secondMenu.runSecondMenu();
                break;
            }
        }
    }

}



