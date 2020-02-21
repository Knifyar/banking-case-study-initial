package com.example.banking.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AccountSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @OneToMany
    private List<AutoLoan> loan;
    @Column
    @OneToMany
    private List<CreditCard> card;
    @Column
    @OneToMany
    private List<DepositAccount> account;

    public AccountSummary() {
    }

    public AccountSummary(List<AutoLoan> loan, List<CreditCard> card, List<DepositAccount> account){
        this.loan = loan;
        this.card = card;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AutoLoan> getLoan() {
        return loan;
    }

    public void setLoan(List<AutoLoan> loan) {
        this.loan = loan;
    }

    public List<CreditCard> getCard() {
        return card;
    }

    public void setCard(List<CreditCard> card) {
        this.card = card;
    }

    public List<DepositAccount> getAccount() {
        return account;
    }

    public void setAccount(List<DepositAccount> account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "AccountSummary{" +
                "id=" + id +
                ", loan=" + loan +
                ", card=" + card +
                ", account=" + account +
                '}';
    }
}
