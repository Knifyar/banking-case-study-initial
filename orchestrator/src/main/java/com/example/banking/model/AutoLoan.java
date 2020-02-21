package com.example.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AutoLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long clientId;
    private String name;
    private Double balance;

    public AutoLoan() {
    }

    public AutoLoan(Long clientId, String name, Double balance) {
        this.clientId = clientId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AutoLoan{" +
                "id=" + id +
                ", clientId=" + String.format("%03d", clientId) +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static AutoLoanBuilder builder(){
        return new AutoLoanBuilder();
    }

    public static final class AutoLoanBuilder{
        private AutoLoan autoLoan;

        private AutoLoanBuilder(){
            autoLoan = new AutoLoan();
        }

        public AutoLoanBuilder withId(Long id){
            autoLoan.setId(id);
            return this;
        }

        public AutoLoanBuilder withclientId(Long clientId){
            autoLoan.setClientId(clientId);
            return this;
        }

        public AutoLoanBuilder withName(String name){
            autoLoan.setName(name);
            return this;
        }

        public AutoLoanBuilder withBalance(Double balance){
            autoLoan.setBalance(balance);
            return this;
        }

        public AutoLoan build(){
            return autoLoan;
        }

    }
}
