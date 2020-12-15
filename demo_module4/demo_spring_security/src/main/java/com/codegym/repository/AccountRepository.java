package com.codegym.repository;

import com.codegym.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserName(String userName);
}
