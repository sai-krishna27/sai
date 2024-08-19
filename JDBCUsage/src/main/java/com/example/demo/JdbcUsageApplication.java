package com.example.demo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.example.demo.Service.ConnectionFactory;

@SpringBootApplication
public class JdbcUsageApplication implements CommandLineRunner{

	@Autowired
	public ConnectionFactory connection;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcUsageApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		JdbcTemplate template= connection.getTemplate();
		String sql = "SELECT * FROM employee";
        List<Map<String, Object>> employees=template.queryForList(sql);
        System.out.println(employees);
		
	}

}
