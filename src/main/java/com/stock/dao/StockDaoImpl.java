package com.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.stock.entity.Currency;
@Component
public class StockDaoImpl {
@Autowired
SessionFactory sessionFactory;
@Transactional
	public void insertCurrencyDetails(Currency currency) {
		sessionFactory.openSession().save(currency);
		//getCurrencyDetails();
		/*Transaction trans=session.beginTransaction();
		try {
		    // The real work is here
			session.save(currency);
			
		  } catch (Exception ex) {
		    // Log the exception here
		   // trans.rollback();
		    throw ex;
		  }
		 finally {
			session.close();
		}		
		try
		{
			trans.commit();}catch(Exception e) {System.out.println(e.getMessage());}	*/
	}

	public List<Currency> getCurrencyDetails()
	{
		Session session=sessionFactory.getCurrentSession();
		Transaction trans=session.beginTransaction();
		List<?> currencies=session.createQuery("from Currency").list();
		trans.commit();
		return (List<Currency>) currencies;
	
	}
}
