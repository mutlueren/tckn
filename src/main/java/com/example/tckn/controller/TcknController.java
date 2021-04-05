package com.example.tckn.controller;

import com.example.tckn.service.TcknValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TcknController {

    @Autowired
    TcknValidationService tcknValidationService;

    @RequestMapping("/isTcknValid")
    public String isGivenCardValid(@RequestParam("tckn") String tckn) throws Exception {
        if(tcknValidationService.isTcknValid(tckn)){
            return "Given TCKN is valid.";
        }
        return "Given TCKN is invalid , please insert a valid TCKN.";
    }

}
