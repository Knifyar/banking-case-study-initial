package com.example.banking.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class InitialBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long clientId;
    private String accountNumber;
    private String name;
    private Double initialBalance;

    public InitialBalance() {
    }

    public InitialBalance(Long clientId, String accountNumber, String name, Double initialBalance){
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.initialBalance = initialBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
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

    public Double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Double initialBalance) {
        this.initialBalance = initialBalance;
    }

    @Override
    public String toString() {
        return "InitialBalance{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", initialBalance=" + initialBalance +
                '}';
    }

    public static InitialBalanceBuilder builder(){
        return new InitialBalanceBuilder();
    }

    public static final class InitialBalanceBuilder{
        private InitialBalance initialBalance;

        private InitialBalanceBuilder(){
            initialBalance = new InitialBalance();
        }

        public InitialBalanceBuilder withId(Long id){
            this.initialBalance.setId(id);
            return this;
        }

        public InitialBalanceBuilder withClientId(Long clientId){
            this.initialBalance.setClientId(clientId);
            return this;
        }

        public InitialBalanceBuilder withAccountNumber(){
            String accountNumber;
            Random rand = new Random();
            Long randNum = rand.nextLong();
            accountNumber = String.format("%09d", randNum);
            this.initialBalance.setAccountNumber(accountNumber);
            return this;
        }

        public InitialBalanceBuilder withName(String name){
            this.initialBalance.setName(name);
            return this;
        }

        public InitialBalanceBuilder withBalance(Double initialBalance){
            this.initialBalance.setInitialBalance(initialBalance);
            return this;
        }

        public InitialBalance build(){
            return initialBalance;
        }

    }
}
