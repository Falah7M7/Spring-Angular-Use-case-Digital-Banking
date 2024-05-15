package org.yass.ebankingbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yass.ebankingbackend.entities.AccountOperation;
import org.yass.ebankingbackend.entities.BankAccount;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
