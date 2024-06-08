package com.adjoda.controller;

import com.adjoda.facade.CreditCardLimitIncreaseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardLimitIncreaseFacade creditCardLimitFacade;

    @GetMapping
    public ResponseEntity<Boolean> increaseCreditCardLimit(){
        creditCardLimitFacade.increaseCreditCardLimit(10000);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
}