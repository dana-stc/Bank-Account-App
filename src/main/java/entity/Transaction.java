package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "transaction_id")
    private BigInteger id;

    @Column(name = "to_account")
    private String toAccount;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "details")
    private String details;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @ManyToOne
    @JoinColumn(name= "account_id")
    private Account account;

    public Transaction(){
    }

    public Transaction(String toAccount, BigDecimal balance, String details, LocalDateTime createdTime) {
        this.toAccount = toAccount;
        this.balance = balance;
        this.details = details;
        this.createdTime = createdTime;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Account getAccount() { return account; }

    public void setAccount(Account account) { this.account = account; }
}
