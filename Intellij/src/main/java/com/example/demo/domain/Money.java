package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
@Entity
public class Money {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    @Min(value = 200,message = "没钱就别发红包！")
    private BigDecimal bigDecimal;

    private String giver;

    private String getter;

    public String getGiver() {
        return giver;
    }

    public void setGiver(String giver) {
        this.giver = giver;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public Money() {
    }

    @Override
    /*public String toString() {
        return "Money{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", bigDecimal=" + bigDecimal +
                ", giver='" + giver + '\'' +
                ", getter='" + getter + '\'' +
                '}';
    }*/

    public String toString() {
        return "Money{" +
                ", bigDecimal=" + bigDecimal +
                ", getter='" + getter + '\'' +
                '}';
    }
}
