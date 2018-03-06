package com.chatter.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.chatter.DAO.BlogDAO;
import com.chatter.DAO.ForumDAO;
import com.chatter.DAO.JobDAO;
import com.chatter.DAO.UserDAO;
import com.chatter.DAOImpl.BlogDAOImpl;
import com.chatter.DAOImpl.ForumDAOImpl;
import com.chatter.DAOImpl.JobDAOImpl;
import com.chatter.DAOImpl.UserDAOImpl;
import com.chatter.model.Blog;
import com.chatter.model.Forum;
import com.chatter.model.Job;
import com.chatter.model.User;

@Configuration
@ComponentScan("com.chatter")
@EnableTransactionManagement
public class DBConfig {
	
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "hr";
	private static final String DB_PASS = "hr";
	
	//Properties
	private static final String HIBERNATE_DIALECT = "org.hibernate.dialect.OracleDialect";
	
	@Bean("dataSource")
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER_NAME);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USER);
		dataSource.setPassword(DB_PASS);
		return dataSource;
	}
	
	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate_dialect", HIBERNATE_DIALECT);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionFactoryBuilder.addProperties(getHibernateProperties());
		System.out.println("SessionFactory Loaded");
		
		sessionFactoryBuilder.addAnnotatedClass(Blog.class);
		sessionFactoryBuilder.addAnnotatedClass(Forum.class);
		sessionFactoryBuilder.addAnnotatedClass(Job.class);
		sessionFactoryBuilder.addAnnotatedClass(User.class);
		
		return sessionFactoryBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("TrasactionManager Loded");
		return transactionManager;
	}
	
	@Bean("blogDAO")
	public BlogDAO getBlogDAOImpl(){
		return new BlogDAOImpl();
	}
	
	@Bean("forumDAO")
	public ForumDAO getForumDAOImpl(){
		return new ForumDAOImpl();
	}
	
	@Bean("jobDAO")
	public JobDAO getJobDAOImpl(){
		return new JobDAOImpl();
	}
	
	@Bean("userDAO")
	public UserDAO getUserDAOImpl(){
		return new UserDAOImpl();
	}
	
}
