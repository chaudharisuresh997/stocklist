package com.stock.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long curId;
	@Column
	public Date date;
	@Column
	public int openPrice;

	@Column
	public String stockCurrency;
	@Column
	public int closePrice;
	@Column
	public int highPrice;
	@Column
	public int lowPrice;
	@Column
	public long volume;
	@Column
	public long turnOver;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(int openPrice) {
		this.openPrice = openPrice;
	}

	public int getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(int closePrice) {
		this.closePrice = closePrice;
	}

	public int getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(int highPrice) {
		this.highPrice = highPrice;
	}

	public int getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public long getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(long turnOver) {
		this.turnOver = turnOver;
	}

	public long getCurId() {
		return curId;
	}

	public void setCurId(long curId) {
		this.curId = curId;
	}

	public String getStockCurrency() {
		return stockCurrency;
	}

	public void setStockCurrency(String stockCurrency) {
		this.stockCurrency = stockCurrency;
	}
}
