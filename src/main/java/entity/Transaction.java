package entity;

import service.constants.TransactionType;

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

    @Column(name = "account")
    private String account;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "details")
    private String details;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    // with table Account
    @ManyToOne
    @JoinColumn(name= "account_id")
    private Account fromAccount;

    public Transaction(){
    }

    public Transaction(String account, BigDecimal amount, String details, LocalDateTime createdTime, TransactionType type) {
        this.account = account;
        this.amount = amount;
        this.details = details;
        this.createdTime = createdTime;
        this.transactionType = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

        public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
