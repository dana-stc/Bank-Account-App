package accountMenu;

public class AccountInfo {

    private String accountNumber;
    private String userNumber;
    private String amount;
    private String balance;
    private String accountType;

    public AccountInfo() {

    }

    public AccountInfo(String accountNumber, String userNumber, String amount, String balance, String accountType) {
        this.accountNumber = accountNumber;
        this.userNumber = userNumber;
        this.amount = amount;
        this.balance = balance;
        this.accountType = accountType;
    }

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

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
