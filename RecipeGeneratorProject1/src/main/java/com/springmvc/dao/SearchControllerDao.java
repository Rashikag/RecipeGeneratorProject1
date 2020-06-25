package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Recipe;
import com.springmvc.model.User;

@Repository
public class SearchControllerDao{

	@Autowired
	DataSource dataSource;
	
	 JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SearchControllerDao(DataSource dataSource) {
		this.dataSource=dataSource;
		jdbcTemplate=new JdbcTemplate(this.dataSource);
	}
	
	public List<Recipe> getAllRecipes() 
	{
		return jdbcTemplate.query("select * from recipe",new RowMapper<Recipe>()
				{

					public Recipe mapRow(ResultSet rs, int row) throws SQLException {
						Recipe recipe=new Recipe();
						recipe.setRecipeId(rs.getInt(1));
						recipe.setRecipeTitle(rs.getString(2));
						recipe.setCuisine(rs.getString(3));
						recipe.setCuisineType(rs.getString(4));
						recipe.setDetails(rs.getString(5));
						recipe.setRecipeType(rs.getString(6));
						recipe.setRecipeImage(rs.getString(7));
						return recipe;
					}
				
				});
	} 
    /* public String validateRecipeName(String recipeTitle) {

        String sql = "select details from recipe where recipe_title='" + recipeTitle + "'";

        return jdbcTemplate.queryForObject(
                sql, String.class);

    } */
	public Recipe validateRecipeName(String recipeTitle) {
		// TODO Auto-generated method stub
		List<Recipe> recipeList=new ArrayList<>();
		//Recipe recipe=new Recipe();
		recipeList=getAllRecipes();
		for(Recipe r:recipeList)
		{
			if(r.getRecipeTitle().equals(recipeTitle))
		return r;
		}
		return null;
		
	} 

	/*public String validateRecipeName(String recipeTitle) {
		// TODO Auto-generated method stub
		 String sql = "select details from recipe where recipe_title='" + recipeTitle + "'";

	        return jdbcTemplate.queryForObject(
	                sql, String.class);
		
	}*/
}