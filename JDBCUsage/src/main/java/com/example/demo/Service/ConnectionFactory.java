package com.example.demo.Service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class ConnectionFactory {
	
	
	private JdbcTemplate template;
	
	public JdbcTemplate  getTemplate() {
		if(template!=null)
			return template;
		else {
			jdbcTemplate(dataSource());
			return template;
		}
	}
	
	public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sai");
        dataSource.setUsername("root");
        dataSource.setPassword("9014803544");
        return dataSource;
    }

   
    public void jdbcTemplate(DataSource dataSource) {
        this.template= new JdbcTemplate(dataSource);
    }

}
