package com.adjoda.controller;

import com.adjoda.facade.CreditCardLimitIncreaseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardLimitIncreaseFacade creditCardLimitFacade;

    @GetMapping("/{expectedLimit}")
    public ResponseEntity<Boolean> increaseCreditCardLimit(@PathVariable Integer expectedLimit){
        //creditCardLimitFacade.increaseCreditCardLimit(10000);
        creditCardLimitFacade.increaseCreditCardLimit(expectedLimit);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
}