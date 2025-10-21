package com.example.demo4.service;

import com.example.demo4.mapper.CreditCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo4.entity.CreditCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CreditCardService {
    private static final Logger logger = LoggerFactory.getLogger(CreditCardService.class);

    @Autowired
    private CreditCardMapper mapper;

    public void saveCard(CreditCard card) {
        mapper.insertCard(card);
    }

    public CreditCard getCard(Long id) {
        return mapper.selectCardById(id);
    }

    public void deleteCard(Long id) {
        mapper.deleteCardById(id);
    }

    public List<CreditCard> findall(){
        return mapper.findallCreditCards();
    }

    public Map<String, String> saveCards(CreditCard card, HttpServletRequest request) {
        // Log card save attempt (do NOT log sensitive info like full card number in production)

       String maskedNumber = maskCardNumber(card.getCardNumber());
       String ip = request.getRemoteAddr();

       logger.info("Saving credit card: {} for holder: {}, IP: {}", maskedNumber, card.getCardHolder(), ip);
        Map<String, String> response = new HashMap<>();
        response.put("maskedCard", maskedNumber);
        response.put("ip", ip);

        // Normally here you would save to DB
        // e.g., creditCardMapper.insertCard(card);

        return response;

        // Here call your mapper / repository to save
        // e.g., creditCardMapper.insertCard(card);
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) return "****";
        String last4 = cardNumber.substring(cardNumber.length() - 4);
        return "**** **** **** " + last4;
    }


}

