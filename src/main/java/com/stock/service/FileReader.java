package com.stock.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.dao.StockDaoImpl;
import com.stock.entity.Currency;

@Component
public class FileReader {
	@Autowired
	StockDaoImpl stockDao;
	
	public String readFile(String fileName) {
		int captionRow=0;
		Scanner sc = null;
		try {
			sc = new Scanner(new File(getClass().getClassLoader().getResource(fileName).getFile()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.next()!=null)
		{//Date	Open	High	Low	Close	Shares Traded	Turnover 
			String line=sc.nextLine();
			captionRow++;
			if(captionRow>4)
			{
			
			Currency currencyObj=split(line);
			
			stockDao.insertCurrencyDetails(currencyObj);
			}
		}
		return "";
	}
	private Currency split(String line) {
		String[] fields=line.split(",");
		Currency currencyObj=new Currency();
		currencyObj.setDate(Date.valueOf(fields[0]));
		currencyObj.setOpenPrice(Integer.valueOf(fields[1]));
		currencyObj.setHighPrice(Integer.valueOf(fields[2]));
		currencyObj.setLowPrice(Integer.valueOf(fields[3]));
		currencyObj.setClosePrice(Integer.valueOf(fields[4]));
		currencyObj.setVolume(Long.valueOf(fields[5]));
		currencyObj.setTurnOver(Long.valueOf(fields[6]));
		return currencyObj;
	}
	public void saveCurrency() {
		Currency cur=new Currency();
		cur.setHighPrice(1234);
		stockDao.insertCurrencyDetails(cur);
	}
}
