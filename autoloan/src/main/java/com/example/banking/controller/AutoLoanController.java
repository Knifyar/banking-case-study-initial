package com.example.banking.controller;

import com.example.banking.model.AutoLoan;
import com.example.banking.service.AutoLoanService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autoloan/")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoLoanController {

    private AutoLoanService autoLoanService;

    public AutoLoanController(AutoLoanService autoLoanService) {
        this.autoLoanService = autoLoanService;
    }

    //Create
    @PostMapping(value = "createLoan", produces = "application/json")
    public AutoLoan setAutoLoan(@RequestBody AutoLoan loan){
        return this.autoLoanService.setAutoLoan(loan);
    }

    //Read
    @GetMapping(value = "getLoansByClientId/{clientId}", produces = "application/json")
    public List<AutoLoan> getAutoLoan(@PathVariable Long clientId){
        return this.autoLoanService.getAutoLoan(clientId);
    }

    @GetMapping(value = "getAllLoans", produces = "application/json")
    public List<AutoLoan> getAllLoans(){
        return this.autoLoanService.getAllLoans();
    }

    //Update
    @PutMapping(value = "updateLoan/{id}", produces = "application/json")
    public AutoLoan updateLoan(@PathVariable Long id,@RequestBody AutoLoan autoLoan){
        return this.autoLoanService.updateLoan(id, autoLoan);
    }

    //Delete
    @DeleteMapping(value = "deleteLoan/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteLoan(@PathVariable Long id){
        Boolean success = this.autoLoanService.deleteLoan(id);
        HttpStatus status;
        String message = "";

        if(success) {
            status = HttpStatus.NO_CONTENT;
            message = "Record deleted!";
        }else{
            status = HttpStatus.NOT_FOUND;
            message = "Record not deleted.";
        }
        return new ResponseEntity(message, status);
    }
}
