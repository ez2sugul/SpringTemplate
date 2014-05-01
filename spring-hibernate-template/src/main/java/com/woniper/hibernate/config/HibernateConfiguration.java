package com.woniper.hibernate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	// databases properties
	@Value("${mysql.driverClassName}") 	private String driverClassName;
	@Value("${mysql.url}") 				private String url;
	@Value("${mysql.username}") 		private String username;
	@Value("${mysql.password}") 		private String password;
	
	// hibernate properties
	@Value("${hibernate.dialect}") private String dialect;
	@Value("${hibernate.show_sql}") private String show_sql;
	@Value("${hibernate.hbm2ddl.auto}") private String hbm2ddl_auto;
	@Value("${entitymanager.packages.to.scan}") private String packageScan;
	
//	private String driverClassName = "com.mysql.jdbc.Driver";
//	private String url = "jdbc:mysql://14.63.197.153:11000/woniper?useUnicode=true&characterEncoding=utf-8";
//	private String username = "root";
//	private String password = "1234";
	
	private static final String APP_PROPERTIES = "database.properties";
	
	// properties 설정값 로딩.
	@Bean
	public static PropertyPlaceholderConfigurer placeHolder() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocations(new Resource[] {new ClassPathResource(APP_PROPERTIES)});
		return ppc;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	private Properties hibProperties() {
		  Properties properties = new Properties();
		  // databases Driver
		  properties.put("hibernate.dialect", dialect);
		  properties.put("hibernate.show_sql", show_sql);
		  // 맵핑 정보를 사용해서 데이터베이스 스키마 검증 
		  // -> validate(운영), update, create, create-drop
		  properties.put("hibernate.hbm2ddl.auto", hbm2ddl_auto);
		  return properties; 
	}
	
	// 1. SessionFactory 설정  
	// Hibernate4에는 AnnotationSessionFactoryBean이 없는 것 같음.
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		// @Entity가 붙은 클래스를 찾아 맵핑 정보로 활용.
		sessionFactory.setPackagesToScan(packageScan);
		sessionFactory.setHibernateProperties(hibProperties());
		return sessionFactory;
	}
	
	// 2. Hibernate 트랜젝션 설정 
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new HibernateTransactionManager(sessionFactory().getObject());
	}
	/*
	@Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource) throws Exception {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.woniper.hibernate");
        em.setPersistenceProvider(new HibernatePersistence());
        Map<String, String> p = new HashMap<String, String>();
        p.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "create");
        p.put(org.hibernate.cfg.Environment.HBM2DDL_IMPORT_FILES, "import_h2.sql");
        p.put(org.hibernate.cfg.Environment.DIALECT, H2Dialect.class.getName());
        p.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");
        em.setJpaPropertyMap(p);
        return em;
    }
	*/
}
