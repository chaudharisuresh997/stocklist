package com.stock;

import java.util.Properties;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stock.entity.Currency;

@Configuration
@ComponentScan("com.stock.*")
@EnableAutoConfiguration
@EnableTransactionManagement
public class AppConfig {
	String dialect="org.hibernate.dialect.Oracle10gDialect";//"org.hibernate.dialect.H2Dialect";
	String driverClass="oracle.jdbc.driver.OracleDriver";//"org.h2.Driver";//"org.hsqldb.jdbcDriver";
	String url="jdbc:oracle:thin:@10.19.5.56:1521:xe";//"jdbc:h2:file:D:/test";//"org.h2.Driver"//"jdbc:hsqldb:mem://stockDb";jdbc:h2:file:C:/data/sample
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername("oracle123");//("sa");
		dataSource.setPassword("oracle123");//("");
		return dataSource;
		
	}
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean()
	{
		LocalSessionFactoryBean sesFactory=new LocalSessionFactoryBean();
		sesFactory.setAnnotatedClasses(Currency.class);
		sesFactory.setDataSource(getDataSource());
		Properties props=new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		props.setProperty("hibernate.dialect",dialect);
		props.setProperty("hibernate.current_session_context_class","thread");
		//props.setProperty("hibernate.dialect", dialect);
		sesFactory.setHibernateProperties(props);
		return sesFactory;
	}
	@Bean
	   public HibernateTransactionManager getTransactionManager() {
	      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	      transactionManager.setSessionFactory(getLocalSessionFactoryBean().getObject());
	      return transactionManager;
	   }
	/*@Bean
	public HibernateTemplate getTemplate()
	{
		HibernateTemplate hTemplate=new HibernateTemplate();
		hTemplate.setSessionFactory( getLocalSessionFactoryBean());
		return hTemplate;
	}*/

}
