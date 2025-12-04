package LLD_without_Design_Pattern.StackOverflow.entities;

import LLD_without_Design_Pattern.StackOverflow.models.AccountType;

import java.util.UUID;

public class Account {

    private String AccountId;
    private String accountName;
    private AccountType accountType;

    public Account(String accountName, AccountType accountType) {
        this.AccountId = UUID.randomUUID().toString();
        this.accountName = accountName;
        this.accountType = accountType;
    }


    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        this.AccountId = accountId;
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
