package com.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.dao.StockDaoImpl;
import com.stock.entity.Currency;
@Component
public class StockService {
	@Autowired
	StockDaoImpl stockDao;
	public List<Currency> getListOfNifty()
	{
		
		return stockDao.getCurrencyDetails();
	}
}
