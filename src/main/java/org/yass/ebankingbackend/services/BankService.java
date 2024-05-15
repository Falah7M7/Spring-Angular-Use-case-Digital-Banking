package org.yass.ebankingbackend.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yass.ebankingbackend.entities.BankAccount;
import org.yass.ebankingbackend.entities.CurrentAccount;
import org.yass.ebankingbackend.entities.SavingAccount;
import org.yass.ebankingbackend.repositories.BankAccountRepository;

@Service
@Transactional

public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;


    public void consulter(){
        BankAccount bankAccount =
                bankAccountRepository.findById("034d8361-152e-4361-92e8-90215822d880").orElse(null);
        if (bankAccount != null) {
            System.out.println("*********************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over draft =>" + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate =>" + ((SavingAccount) bankAccount).getInterestRate());
            }

            bankAccount.getAccountOperations().forEach(op -> {
                System.out.println("================");
                System.out.println(op.getType());
                System.out.println(op.getOperationDate());
                System.out.println(op.getAmount());
            });
        }

    }
}
