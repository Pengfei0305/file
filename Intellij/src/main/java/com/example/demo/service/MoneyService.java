package com.example.demo.service;

import com.example.demo.domain.Money;
import com.example.demo.repository.MoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MoneyService {

    @Autowired
    private MoneyRepository repository;

    /**
     * 事务 是指数据库的事务
     */
    @Transactional
    public void  createTwo(){
        Money firstMoney = new Money();
        firstMoney.setDescription("ttt");
        firstMoney.setGiver("大王");
        firstMoney.setGetter("大飞");
        firstMoney.setBigDecimal(new BigDecimal(520));
        repository.save(firstMoney);

        Money secondMoney = new Money();
        secondMoney.setDescription("ttt");
        secondMoney.setGiver("大王");
        secondMoney.setGetter("大飞");
        secondMoney.setBigDecimal(new BigDecimal(520));
        repository.save(secondMoney);
    }


    public Money getMoney(Integer id){

        return repository.findById(id).orElse(null);
    }
    public List<Money> getByGiver(String giver){

        return repository.getByGiver(giver);
    }




}
