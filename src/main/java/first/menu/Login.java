package first.menu;

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

    public void loginMenu() {
        ConsoleReader reader = ConsoleReader.getInstance();
        while (true) {
            System.out.println("Enter the username");
            String username = reader.readFromConsole();

            System.out.println("Enter the password");
            String password = reader.readFromConsole();

            UserInfo ifLoggedIn = this.verifyWithObjects(username, password);

            if (ifLoggedIn == null) {
                System.out.println("Wrong username/password ");
            }
            else
            {
                LoginMenu secondMenu = new LoginMenu();
                secondMenu.runSecondMenu();
                break;
            }
        }
    }

}



