/**
 * UserInfo class
 *
 * @author Stoica Ioana-Dana
 */

package entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "userInfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private BigInteger id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
            mappedBy = "user")
    private Person person;

    @OneToMany(fetch = FetchType.EAGER,mappedBy ="user")
    private List<Account> accountList;

    public UserInfo() {
    }

    /**
     * Builds a new instance of a UserInfo
     *
     * @param username name of the user
     * @param password password of the user
     */
    public UserInfo(String username, String password, LocalDateTime createdTime, LocalDateTime updatedTime) {
        this.username = username;
        this.password = password;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

        @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if (!(obj instanceof UserInfo)) return false;
            UserInfo userInfo = (UserInfo) obj;

        if(userInfo.getUsername().equals(this.username) && userInfo.getPassword().equals(this.password))
            return true;
        return false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public List<Account> getAccountList() { return accountList; }

    public void setAccountList(List<Account> accountList) { this.accountList = accountList; }

    public BigInteger getId() {
        return id;
    }
}
