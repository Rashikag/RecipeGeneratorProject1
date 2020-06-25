package com.springmvc.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseController {
	@Autowired
	DataSource dataSource;
	
	 JdbcTemplate jdbcTemplate;
	 
	@Autowired
	public BaseController(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
		jdbcTemplate=new JdbcTemplate(this.dataSource);
	}
	


	
}
