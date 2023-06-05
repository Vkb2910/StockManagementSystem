//package com.stock.management.system.service;
//
//import com.stock.management.system.model.Stock;
//import com.stock.management.system.repository.StockRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StockServiceImpl implements StockService {
//
//    private final StockRepository stockRepository;
//
//    @Autowired
//    public StockServiceImpl(StockRepository stockRepository) {
//        this.stockRepository = stockRepository;
//    }
//
//    public List<Stock> getAllStocks() {
//        return stockRepository.findAll();
//    }
//
//    public Stock getStockById(Long id) {
//        return stockRepository.findById(id).orElse(null);
//    }
//
//    public Stock addStock(Stock stock) {
//        return stockRepository.save(stock);
//    }
//
//    public void deleteStock(Long id) {
//        stockRepository.deleteById(id);
//    }
//}


package com.stock.management.system.service;

import com.stock.management.system.model.Stock;
import com.stock.management.system.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    private final StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public void registerStock(Stock stock) {
        stockRepository.save(stock);
    }

	@Override
	public Stock addStock(Stock stock) {
		
		return null;
	}

	@Override
	public Stock createStock(Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock getStock(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock updateStock(Long id, Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStock(Long id) {
		// TODO Auto-generated method stub
		
	}
}
