package com.stock.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stock.management.system.model.Stock;
import com.stock.management.system.service.StockService;

@Controller
public class StockDisplayController {

    private final StockService stockService;

    @Autowired
    public StockDisplayController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stocks")
    public String showAllStocks(Model model) {
        List<Stock> stocks = stockService.getAllStocks();
        model.addAttribute("stocks", stocks);
        return "stocks";
    }
}

