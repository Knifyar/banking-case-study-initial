package com.example.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class DepositAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long clientId;
    private String accountNumber;
    private String name;
    private Double balance;

    public DepositAccount() {
    }

    public DepositAccount(Long clientId, String accountNumber, String name, Double balance) {
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return String.format("%03d",clientId);
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return String.format("%g", balance);
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", number='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static DepositAccountBuilder builder(){
        return new DepositAccountBuilder();
    }

    public static final class DepositAccountBuilder{
        private DepositAccount depositAccount;

        private DepositAccountBuilder(){
            depositAccount = new DepositAccount();
        }

        public DepositAccountBuilder withId(Long id){
            depositAccount.setId(id);
            return this;
        }

        public DepositAccountBuilder withClientId(Long clientId){
            depositAccount.setClientId(clientId);
            return this;
        }

        public DepositAccountBuilder withAccountNumber(){
            String accountNumber;
            Random rand = new Random();
            Long randNum = rand.nextLong();
            accountNumber = String.format("%09d", randNum);
            depositAccount.setAccountNumber(accountNumber);
            return this;
        }

        public DepositAccountBuilder withName(String name){
            depositAccount.setName(name);
            return this;
        }

        public DepositAccountBuilder withBalance(Double balance){
            depositAccount.setBalance(balance);
            return this;
        }

        public DepositAccount build(){
            return depositAccount;
        }

    }
}
