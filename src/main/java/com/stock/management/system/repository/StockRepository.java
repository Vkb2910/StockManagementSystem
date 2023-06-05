package com.stock.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.management.system.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    
}

