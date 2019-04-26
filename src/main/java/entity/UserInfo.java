/**
 * UserInfo class
 *
 * @author Stoica Ioana-Dana
 */

package entity;

import java.io.Serializable;

public class UserInfo implements Serializable {


    private String userName;
    private String password;

    /**
     * Builds a new instance of a UserInfo
     * @param userName name of the user
     * @param password password of the user
     */
    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if (!(obj instanceof UserInfo)) return false;
        UserInfo userInfo = (UserInfo) obj;

        if(userInfo.getUserName().equals(this.userName) && userInfo.getPassword().equals(this.password))
            return true;
        return false;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
