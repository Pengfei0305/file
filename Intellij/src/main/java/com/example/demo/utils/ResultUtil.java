package com.example.demo.utils;

import com.example.demo.domain.MoneyResult;

public class ResultUtil {

    public static MoneyResult success(Object object){
        MoneyResult moneyResult = new MoneyResult();
        moneyResult.setCode(1);
        moneyResult.setMessage("成功发送红包！");
        moneyResult.setData(object);
        return moneyResult;
    }

    public static MoneyResult success(){
        MoneyResult moneyResult = new MoneyResult();
        moneyResult.setCode(1);
        moneyResult.setMessage("成功发送红包！");
        return moneyResult;
    }

    public static MoneyResult error(Integer code, String message){
        MoneyResult moneyResult = new MoneyResult();
        moneyResult.setCode(code);
        moneyResult.setMessage(message);
        return moneyResult;
    }

}
