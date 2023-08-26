package com.deepan.controller;

import com.deepan.dto.Response;
import com.deepan.exceptions.AccountAlreadyPresentException;
import com.deepan.exceptions.AccountNotPresentException;
import com.deepan.model.Account;
import com.deepan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class AccountController {

    @Autowired
   private AccountService accountService;

    @GetMapping("/test")
    public String testHandler(){

        return "Welcome to my Account API";
    }

//    GET ----   for getting all the accounts ----  /api/v1/accounts
//    Response (Resources, Response Headers, status code) ---  ResponseEntity
//    1. create a method map to the url
//    2. read the accounts resource from the database and store in the object
//    3. build response entity with the accounts resources, headers if required along with status code
//    4. return response entity


//    handler method for getting all the accounts
    @GetMapping(value = "/accounts")
    public ResponseEntity<List<Account>> getAllAccountsHandler(
            @RequestParam(value = "accType",required = false) String accType,
            @RequestParam(value = "sort", required = false) String sortProperty,
            @RequestParam(value = "order", required = false) String order,
            @RequestParam(value = "page", required = false) Integer page
    ){
        ResponseEntity<List<Account>> responseEntity;
        List<Account> accountList = accountService.getAllAccounts(accType);

        responseEntity = new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
        return responseEntity;
    }

//    handler method for adding a new account to the accounts collection

    @PostMapping(value = "/accounts")
    public ResponseEntity<Response> addNewAccountHandler(@RequestBody Account account){
        ResponseEntity<Response> responseEntity;

        try {
            Account account1 = accountService.addNewAccount(account);
            Response response = new Response("Success","Account added Successfully");
            responseEntity = new ResponseEntity<>(response,HttpStatus.CREATED);
        } catch (AccountAlreadyPresentException e) {
            Response response = new Response("Failed","Account already Exist");
            responseEntity = new ResponseEntity<>(response,HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

//    creating unique uri for individual resource
    @GetMapping(value = "/accounts/{accountNumber}")
    public ResponseEntity<?> getAccountByAccountNumber(@PathVariable("accountNumber") String accNumber){
        System.out.println();
        ResponseEntity<?> responseEntity;

        try {
            Account account = accountService.findAccountByAccountNumber(accNumber);
            responseEntity = new ResponseEntity<Account>(account,HttpStatus.OK);
        } catch (AccountNotPresentException e) {
            Response response = new Response("Failed","Account Not Found");
            responseEntity = new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


//    pathVariable --- use unique value ---  unique endpoint ---  uniform interface

//    editing the account  ---  put
//    deleting the account --- delete
}

//{status: "success",message:"Account added successfully"} ---  Data Transfer Object

//controller   Service(read data from the repository and apply business logic and return processesed resource to the controller)   Repository


//sortInteger(int a) sortInteger(10);
//sortStrings()
//sortDouble()

//sort<A>();
//sort<Integer>();
//sort<Double>();
//sort<String>();

//List<String>
//List<integer>
//List<Account>
//ResponseEntity<List<Account>>


