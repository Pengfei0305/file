package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/hello")
public class DemoController {


    @Value("${limit.minMoney}")
    private BigDecimal bigDecimal;

    //@GetMapping("/say")
    @PostMapping("/say")
    //public String say(@PathVariable("id") Integer id){
    //public String say(@RequestParam("id") Integer id){
    public String say(@RequestParam(value = "id", defaultValue = "0",required = false) Integer id){
        return "你大爷的"+id;
    }

}
