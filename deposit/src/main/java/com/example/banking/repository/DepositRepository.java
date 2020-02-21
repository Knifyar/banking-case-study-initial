package com.example.banking.repository;

import com.example.banking.model.DepositAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepository extends CrudRepository<DepositAccount, Long> {
    List<DepositAccount> findAllByClientId(Long clientId);

    DepositAccount getDepositAccountById(Long id);

    List<DepositAccount> getAllDepositAccountByClientId(Long clientId);
}
