package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.model.User;

@Repository
public class LoginControllerDao {
	
	@Autowired
	 JdbcTemplate jdbcTemplate;
	
	public boolean validateLogin(String name,String password) {  
		List<User> finalUser=new ArrayList<>();
		finalUser=getAllUsers();
		for(User u:finalUser) {
			if(u.getUser_name().equalsIgnoreCase(name)&& u.getUser_password().equalsIgnoreCase(password))
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
						user.setUser_id(rs.getInt(1));
						user.setUser_name(rs.getString(2));
						user.setUser_password(rs.getString(3));
						user.setUser_gmail(rs.getString(4));			
						return user;
					}
				
				});
	}
	
	public int insertUser(User user) 
	{
		 String sql = "insert into user_detail(user_name,user_password,user_gmail)"
                 + " values (?, ?, ?)";
    return jdbcTemplate.update(sql, user.getUser_name(),user.getUser_password(),
    		user.getUser_gmail());
	}
}
