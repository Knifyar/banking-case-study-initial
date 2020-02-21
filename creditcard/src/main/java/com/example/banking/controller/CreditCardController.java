package com.example.banking.controller;

import com.example.banking.model.CreditCard;
import com.example.banking.service.CreditCardService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditcard/")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardController {
    private CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping(value = "createCreditCard", produces = "application/json")
    public CreditCard createCreditCard(@RequestBody CreditCard creditCard){
        return this.creditCardService.setCreditCard(creditCard);
    }


    @GetMapping(value = "getCreditCardsByClientId/{clientId}", produces = "application/json")
    public List<CreditCard> getCreditCard(@PathVariable Long clientId){
        return this.creditCardService.getCreditCard(clientId);
    }

    @GetMapping(value = "getAllCreditCards", produces = "application/json")
    public List<CreditCard> getCreditCards(){
        return this.creditCardService.getCreditCard();
    }

    //Update
    @PutMapping(value = "updateCreditCard/{id}", produces = "application/json")
    public CreditCard updateCreditCard(@PathVariable Long id,@RequestBody CreditCard creditCard){
        return this.creditCardService.updateCreditCard(id, creditCard);
    }

    //Delete
    @DeleteMapping(value = "deleteCreditCard/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteCreditCard(@PathVariable Long id){
        Boolean success = this.creditCardService.deleteCreditCard(id);
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
