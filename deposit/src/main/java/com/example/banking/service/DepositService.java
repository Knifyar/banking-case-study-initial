package com.example.banking.service;

import com.example.banking.model.DepositAccount;
import com.example.banking.model.InitialBalance;
import com.example.banking.repository.DepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.logging.LoggingMXBean;

@Service
public class DepositService {

    private DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }


    public DepositAccount setdepositAccount(InitialBalance initialBalance) {
        //initialBalance.setAccountNumber("");
        Random rand = new Random();
        int randNum = rand.nextInt(1000000000);
        initialBalance.setAccountNumber(Integer.toString(randNum));
        DepositAccount card = new DepositAccount(initialBalance.getClientId(), initialBalance.getAccountNumber(),initialBalance.getName(),initialBalance.getInitialBalance());
        return this.depositRepository.save(card);
    }

    public List<DepositAccount> getDepositAccountByClientId(Long clientId) {
        //return this.depositRepository.findAllByClientId(clientId);
        return this.depositRepository.getAllDepositAccountByClientId(clientId);
    }

    public List<DepositAccount> getAllDepositAccounts() {
        return (List<DepositAccount>) this.depositRepository.findAll();
    }

    public DepositAccount updatedepositAccount(Long id, DepositAccount depositAccount) {
        DepositAccount account = this.depositRepository.getDepositAccountById(id);
        account.setName(depositAccount.getName());
        this.depositRepository.save(account);
        depositAccount.setId(id);
        return account;
    }

    public Boolean deletedepositAccount(Long id) {
        boolean success = true;

        try{
            this.depositRepository.deleteById(id);
        }catch (Exception e){
            success = false;
        }
        return success;
    }
}
