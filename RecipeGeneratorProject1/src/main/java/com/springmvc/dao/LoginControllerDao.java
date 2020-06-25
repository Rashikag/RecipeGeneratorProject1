package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springmvc.model.User;

@Repository
public class LoginControllerDao{
	
	@Autowired
	DataSource dataSource;
	
	 JdbcTemplate jdbcTemplate;
	
	@Autowired
	public LoginControllerDao(DataSource dataSource) {
		this.dataSource=dataSource;
		jdbcTemplate=new JdbcTemplate(this.dataSource);
	}
	
	public boolean validateLogin(String name,String password) {  
		List<User> finalUser=new ArrayList<>();
		finalUser=getAllUsers();
		for(User u:finalUser) {
			if(u.getUserName().equalsIgnoreCase(name)&& u.getUserPassword().equalsIgnoreCase(password))
				return true;
		}
		return false;
	}
	public List<User> getAllUsers() 
	{
		return jdbcTemplate.query("select * from User_detail", new RowMapper<User>()
				{

					public User mapRow(ResultSet rs, int row) throws SQLException {
						User user=new User();
						user.setUserId(rs.getInt(1));
						user.setUserName(rs.getString(2));
						user.setUserPassword(rs.getString(3));
						user.setUserGmail(rs.getString(4));			
						return user;
					}
				
				});
	}
	
   public int insertUser(String name,String password,String gmail) 
	{
	   User user=new User();
		user.setUserName(name);
		user.setUserPassword(password);
		user.setUserGmail(gmail);		
		 String sql = "insert into user_detail(user_name,user_password,user_gmail)"
                 + " values (?, ?, ?)";
    return jdbcTemplate.update(sql,user.getUserName(),user.getUserPassword(),user.getUserGmail());
	} 
}
