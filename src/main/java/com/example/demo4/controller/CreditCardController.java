package com.example.demo4.controller;

import com.example.demo4.mapper.CreditCardMapper;
import com.example.demo4.service.CarService;

import com.example.demo4.entity.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo4.entity.CreditCard;
import com.example.demo4.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/api/cards")
public class CreditCardController {

    @Autowired
    private CreditCardService service;
    HttpServletRequest request;

    // Create a new credit card
    @PostMapping("/api/cards/submit")
    public Map<String, String> submitCard(@RequestBody CreditCard card) {
        Map<String, String> response = new HashMap<>();
        service.saveCard(card);
        response= service.saveCards(card,request);
        return response; // return the saved card
        //return card;
    }

    // Get a card by ID
    @GetMapping("/api/cards/{id}")
    public CreditCard getCard(@PathVariable Long id) {
        return service.getCard(id);
    }

    @GetMapping("/api/cards")
    public CreditCard findall() {
        return service.findall();
    }

    // Delete a card by ID
    @DeleteMapping("/api/cards/{id}")
    public String deleteCard(@PathVariable Long id) {
        service.deleteCard(id);
        return "Card with id " + id + " deleted successfully!";
    }
}
