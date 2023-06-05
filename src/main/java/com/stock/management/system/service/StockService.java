package com.stock.management.system.service;

import java.util.List;

import com.stock.management.system.model.Stock;

public interface StockService {

	List<Stock> getAllStocks();

	Stock addStock(Stock stock);

	void registerStock(Stock stock);

	Stock createStock(Stock stock);

	Stock getStock(Long id);

	Stock updateStock(Long id, Stock stock);

	void deleteStock(Long id);


  
}
