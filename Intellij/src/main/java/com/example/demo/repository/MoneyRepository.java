package com.example.demo.repository;

import com.example.demo.domain.Money;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoneyRepository extends JpaRepository<Money, Integer> {

    public List<Money> getByGiver(String giver);
}
