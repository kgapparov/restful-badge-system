package com.example.restfullbadgesystem.controllers;

import com.example.restfullbadgesystem.domain.Transaction;
import com.example.restfullbadgesystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("transactions")
@Transactional
public class TransactionController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private TransactionService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @RolesAllowed({"user", "admin"})
    public Transaction findById(@PathVariable int id) {
        return service.findById(id);
    }
    @PostMapping
    @RolesAllowed({"user", "admin"})
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction save(@RequestBody Transaction transaction) {
        return service.create(transaction);
    }
}