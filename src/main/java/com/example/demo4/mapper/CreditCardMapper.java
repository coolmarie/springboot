package com.example.demo4.mapper;

import com.example.demo4.entity.CreditCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CreditCardMapper {

    void insertCard(CreditCard card);

    CreditCard selectCardById(@Param("id") Long id);

    void deleteCardById(@Param("id") Long id);
    CreditCard findall();
}

