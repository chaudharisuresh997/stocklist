package com.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stock.entity.Currency;
import com.stock.service.FileReader;
import com.stock.service.StockService;

@Controller
public class IndexController {
	@Autowired 
	StockService stockService;
	@Autowired
	FileReader fileReader;
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	fileReader.saveCurrency();
    	//fileReader.readFile("data.csv");
    	
        model.addAttribute("name", name);
        return "hello";
    }
    @RequestMapping("/list")
    public String list(Model model)
    {
    	List<Currency> currencyList=stockService.getListOfNifty();
    	model.addAttribute("stocks",currencyList);
		return "list";
    }
    
}
