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

//import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.servlet.http.HttpServletRequest;


@RestController
//@RequestMapping("/api/cards")
@CrossOrigin(origins = "https://hggfs7-4200.csb.app")
public class CreditCardController {

    @Autowired
    private CreditCardService service;
    //HttpServletRequest request;

    // Create a new credit card
    //@PostMapping("/api/cards/submit")
    //public Map<String, String> submitCard(@RequestBody CreditCard card,HttpServletRequest request) {
      //  Map<String, String> response = new HashMap<>();
       // service.saveCard(card);
        //service.findall();
        //return service.saveCards(card,request);
        //return card;
    //}

    @PostMapping("/api/cards/submit")
    public List<CreditCard> submitCard(@RequestBody CreditCard card, HttpServletRequest request) {
        Map<String, String> response = new HashMap<>();
        service.saveCard(card);
        return service.findall();
        //return service.saveCards(card,request);
        //return card;
    }

    // Get a card by ID
    @GetMapping("/api/cards/{id}")
    public CreditCard getCard(@PathVariable Long id) {
        return service.getCard(id);
    }

    @GetMapping("/api/cards")
    public List<CreditCard> findall() {
        return service.findall();
    }

    // Delete a card by ID
    @DeleteMapping("/api/cards/{id}")
    public String deleteCard(@PathVariable Long id) {
        service.deleteCard(id);
        return "Card with id " + id + " deleted successfully!";
    }
}
