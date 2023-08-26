package com.deepan.repository;

import com.deepan.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
//
}

//i am going to get access to interface that specify all methods to speak with the database
//spring data jpa provide all methods to perform various database operations

//@Controller
//@RestController
//@Repository
//@Service
