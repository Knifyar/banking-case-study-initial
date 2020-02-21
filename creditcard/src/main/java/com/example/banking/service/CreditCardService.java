package com.example.banking.service;

import com.example.banking.model.CreditCard;
import com.example.banking.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    private CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCard setCreditCard(CreditCard creditCard) {
        CreditCard card = CreditCard.builder().withClientId(Long.parseLong(creditCard.getClientId())).withNumber(creditCard.getNumber()).withName(creditCard.getName()).withBalance(Double.parseDouble(creditCard.getBalance())).build();
        return this.creditCardRepository.save(card);
    }

    public List<CreditCard> getCreditCard(Long clientId) {
        return (List<CreditCard>) this.creditCardRepository.findAllByClientId(clientId);
    }

    public List<CreditCard> getCreditCard() {
        return (List<CreditCard>) this.creditCardRepository.findAll();
    }

    public CreditCard updateCreditCard(Long id, CreditCard creditCard) {
        CreditCard card = this.creditCardRepository.getCreditCardById(id);
        card.setName(creditCard.getName());
        this.creditCardRepository.save(card);
        creditCard.setId(id);
        return card;
    }

    public Boolean deleteCreditCard(Long id) {
        boolean success = true;

        try{
            this.creditCardRepository.deleteById(id);
        }catch (Exception e){
            success = false;
        }
        return success;
    }
}
