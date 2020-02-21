package com.example.banking.controller;

import com.example.banking.model.DepositAccount;
import com.example.banking.model.InitialBalance;
import com.example.banking.service.DepositService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposit/")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepositController {
    private DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping(value = "createDepositAccount", produces = "application/json")
    public DepositAccount createDepositAccount(@RequestBody InitialBalance initialBalance){
        return this.depositService.setdepositAccount(initialBalance);
    }


    @GetMapping(value = "getDepositAccountsByClientId/{clientId}", produces = "application/json")
    public List<DepositAccount> getDepositAccountsByClientId(@PathVariable String clientId){
        return this.depositService.getDepositAccountByClientId(Long.parseLong(clientId));
    }

    @GetMapping(value = "getAllDepositAccounts", produces = "application/json")
    public List<DepositAccount> getAllDepositAccounts(){
        return this.depositService.getAllDepositAccounts();
    }

    //Update
    @PutMapping(value = "updateDepositAccount/{id}", produces = "application/json")
    public DepositAccount updateDepositAccount(@PathVariable Long id,@RequestBody DepositAccount depositAccount){
        return this.depositService.updatedepositAccount(id, depositAccount);
    }

    //Delete
    @DeleteMapping(value = "deleteDepositAccount/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteDepositAccount(@PathVariable Long id){
        Boolean success = this.depositService.deletedepositAccount(id);
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
