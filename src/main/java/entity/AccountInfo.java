/**
 * AccountInfo class
 * the accounts that a user have as it login
 *
 * @author Stoica Ioana-Dana
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountInfo implements Serializable {

    private String accountNumber;
    private String userName;
    private BigDecimal amount;
    private String accountType;


    @Override
    public String toString() {
        return this.accountNumber + ", " + this.userName + ", " + this.amount + ", " + this.accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userNumber) {
        this.userName = userNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
