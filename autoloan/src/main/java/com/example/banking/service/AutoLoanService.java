package com.example.banking.service;

import com.example.banking.model.AutoLoan;
import com.example.banking.repository.AutoLoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoLoanService {
    private AutoLoanRepository autoLoanRepository;

    public AutoLoanService(AutoLoanRepository autoLoanRepository) {
        this.autoLoanRepository = autoLoanRepository;
    }

    //create
    public AutoLoan setAutoLoan(AutoLoan loan) {
        AutoLoan autoLoan = AutoLoan.builder().withclientId(Long.parseLong(loan.getClientId())).withName(loan.getName()).withBalance(loan.getBalance()).build();
        return this.autoLoanRepository.save(autoLoan);
    }

    //read
    public List<AutoLoan> getAutoLoan(Long clientId) {
        return this.autoLoanRepository.findAllByClientId(clientId);
    }

    public List<AutoLoan> getAllLoans() {
        return (List<AutoLoan>) this.autoLoanRepository.findAll();
    }

    //TODO fix null balance
    //update
    public AutoLoan updateLoan(Long id, AutoLoan autoLoan) {
        AutoLoan loan = this.autoLoanRepository.getAutoLoanById(id);
        loan.setName(autoLoan.getName());
        this.autoLoanRepository.save(loan);
        autoLoan.setId(id);
        return loan;
    }

    //delete
    public Boolean deleteLoan(Long id) {
        boolean success = true;

        try{
            this.autoLoanRepository.deleteById(id);
        }catch (Exception e){
            success = false;
        }
        return success;
    }

}
