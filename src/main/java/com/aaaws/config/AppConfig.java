package com.aaaws.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.aaaws.model.Employee;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:app.properties")
@ComponentScan("com.aaaws")
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource ds() {
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName(env.getProperty("db.driver"));
		bds.setUrl(env.getProperty("db.url"));
		bds.setUsername(env.getProperty("db.user"));
		bds.setPassword(env.getProperty("db.password"));
		return bds;
	}

	@Bean
	public Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("orm.dialect"));
		p.put("hibernate.show_sql", env.getProperty("orm.showsql"));
		p.put("hibernate.format_sql", env.getProperty("orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("orm.ddlauto"));
		
		return p;
	}
	
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean ls=new LocalSessionFactoryBean();
		ls.setDataSource(ds());
		ls.setHibernateProperties(props());
		ls.setAnnotatedClasses(Employee.class);
		return ls;
	}
	
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate h=new HibernateTemplate();
		h.setSessionFactory(sf().getObject() );
		return h;
	}
	
	@Bean
	public HibernateTransactionManager hxt() {
		HibernateTransactionManager hm=new HibernateTransactionManager();
		hm.setSessionFactory(sf().getObject());
		return hm;
	}
	
	@Bean
	public InternalResourceViewResolver irv() {
		InternalResourceViewResolver vi=new InternalResourceViewResolver();
		vi.setPrefix(env.getProperty("mvc.prefix"));
		vi.setSuffix(env.getProperty("mvc.suffix"));
		return vi;
	}
		
}