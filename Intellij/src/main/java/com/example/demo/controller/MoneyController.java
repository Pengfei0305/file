package com.example.demo.controller;

import com.example.demo.aspect.HttpAspect;
import com.example.demo.domain.Money;
import com.example.demo.domain.MoneyResult;
import com.example.demo.repository.MoneyRepository;
import com.example.demo.service.MoneyService;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hello")
public class MoneyController {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private MoneyRepository repository;

    @Autowired
    private MoneyService moneyService;



    /**
     * getString
     */
    @GetMapping("/String1")
    public String String1(){
        return "hahah";
    }

    /**
     * getMoney
     */
    @GetMapping("/Moneys")
    public List<Money> getMoney(){
        return repository.findAll();
    }


    /**
     * getById
     */
    @GetMapping("/getById/{id}")
    public Money getById(@PathVariable("id") Integer id){

        return repository.findById(id).orElse(null);
    }
    /**
     * create
     */
    @PostMapping("/createMoney")
    public Money create(@RequestBody Money money){

        return repository.save(money);
    }

    @RequestMapping(value = "/api", method = RequestMethod.POST)
    public void createCity(@RequestBody String money) {
        System.out.println(money);
         //repository.save(money);
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public void createCity(@RequestBody City city) {
//        cityService.saveCity(city);
//    }

    /**
     * update
     */

    @PutMapping("/updateMoney")
    public MoneyResult<Money> update(@Valid Money money, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.error(0,bindingResult.getFieldError().getDefaultMessage());
        }

        Optional<Money> optional = repository.findById(money.getId());
        if(optional.isPresent()){
            Money moneySave = optional.get();
            moneySave.setDescription(money.getDescription());
            moneySave.setBigDecimal(money.getBigDecimal());
            return ResultUtil.success(repository.save(moneySave));
        }

        return null;

    }


    @PostMapping("/setMoneyTwo")
    public void setMoneyTwo(){
        moneyService.createTwo();
    }

    @GetMapping("/getByGiver")
    public List<Money> getByGiver(@RequestParam("giver") String giver){
        return moneyService.getByGiver(giver);
    }





}
