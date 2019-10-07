package com.example.demo.domain;

public class MoneyResult<T> {
    /**  error code          */
    private Integer code;
    /**  error message       */
    private String message;
    /**  error data          */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
