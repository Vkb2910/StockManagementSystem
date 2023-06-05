package com.stock.management.system.controller;

import com.stock.management.system.model.Stock;
import com.stock.management.system.service.StockService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StockController {

	private final StockService stockService;

	@Autowired
	public StockController(StockService stockService) {
		this.stockService = stockService;
	}

	@GetMapping("/stocks/new")
	public String showStockRegistrationForm(Model model) {
		model.addAttribute("stock", new Stock());
		return "stock_reg";
	}

	@PostMapping("/stocks/new")
	public String registerStock(@ModelAttribute("stock") Stock stock) {
		stockService.registerStock(stock);
		return "redirect:/stocks";
	}

	@PostMapping
	public Stock createStock(@RequestBody Stock stock) {
		return stockService.createStock(stock);
	}
//	@GetMapping("/stocks")
//	public String showAllStocks(Model model) {
//	    List<Stock> stocks = stockService.getAllStocks();
//	    model.addAttribute("stocks", stocks);
//	    return "stocks";
//	}


//	@GetMapping("/{id}")
//	public Stock getStock(@PathVariable Long id) {
//		return stockService.getStock(id);
//	}
//
//	@PutMapping("/{id}")
//	public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock) {
//		return stockService.updateStock(id, stock);
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteStock(@PathVariable Long id) {
//		stockService.deleteStock(id);
//	}
}
