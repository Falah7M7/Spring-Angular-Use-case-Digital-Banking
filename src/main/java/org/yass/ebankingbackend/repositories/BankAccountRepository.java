package org.yass.ebankingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yass.ebankingbackend.entities.BankAccount;
import org.yass.ebankingbackend.entities.Customer;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
