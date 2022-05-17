package com.example.restfullbadgesystem.controllers;

import com.example.restfullbadgesystem.dto.CheckInDTO;
import com.example.restfullbadgesystem.services.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckInController {


    @Autowired
    CheckInService checkInService;


    @PostMapping("checkIn")
    public String checkIn(@RequestBody CheckInDTO checkInDTO){
        String message = "";
        message=checkInService.CheckIn(checkInDTO);
        return message;
    }
}
