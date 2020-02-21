package com.example.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long clientId;
    private String number;
    private String name;
    private Double balance;

    public CreditCard() {
    }

    public CreditCard(Long clientId, String number, String name, Double balance) {
        this.clientId = clientId;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        return "CreditCard{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static CreditCardBuilder builder(){
        return new CreditCardBuilder();
    }

    public static final class CreditCardBuilder{
        private CreditCard creditCard;

        private CreditCardBuilder(){
            creditCard = new CreditCard();
        }

        public CreditCardBuilder withId(Long id){
            creditCard.setId(id);
            return this;
        }

        public CreditCardBuilder withClientId(Long clientId){
            creditCard.setClientId(clientId);
            return this;
        }

        public CreditCardBuilder withNumber(String number){
            creditCard.setName(number);
            return this;
        }

        public CreditCardBuilder withName(String name){
            creditCard.setName(name);
            return this;
        }

        public CreditCardBuilder withBalance(Double balance){
            creditCard.setBalance(balance);
            return this;
        }

        public CreditCard build(){
            return creditCard;
        }

    }
}
