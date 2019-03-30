package accountMenu;

import java.math.BigDecimal;

public class AccountInfo {

    private String accountNumber;
    private BigDecimal userNumber;
    private BigDecimal amount;
    private BigDecimal balance;
    private String accountType;


    public Boolean verifyInfo() {

        if (accountNumber.length() == 24 && accountNumber.startsWith("RO") && (accountType.equals("Euro") || accountType.equals("Ron")))
            return true;
        return false;

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(BigDecimal userNumber) {
        this.userNumber = userNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
