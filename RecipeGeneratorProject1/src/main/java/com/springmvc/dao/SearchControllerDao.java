package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Ingredients;
import com.springmvc.model.Recipe;

@Repository
public class SearchControllerDao {

    @Autowired
    DatabaseConfig databaseConfig;

	JdbcTemplate jdbcTemplate;

	@Autowired
	public SearchControllerDao(DatabaseConfig databaseConfig) {
		jdbcTemplate = new JdbcTemplate(databaseConfig.getDataSource());
	}

	
	/**
	 * fetches ingredient list from database
	 * @return
	 */
	
	public List<Ingredients> getIngredientList(){
		List<Ingredients> ingredientList=new ArrayList<Ingredients>();
		ingredientList=jdbcTemplate.query("Select * from ingredients", new RowMapper<Ingredients>(){
			public Ingredients mapRow(ResultSet rs, int row) throws SQLException {
				Ingredients ingredient=new Ingredients();
				ingredient.setIngredientId(rs.getInt(1));
				ingredient.setIngredientName(rs.getString(2));
				ingredient.setIngredientType(rs.getString(3));
				ingredient.setCategory(rs.getString(4));
				return ingredient;
			}
		});
		return ingredientList;
	}
	/**
	 * converts ingredientList to ingredientNameList
	 * @return
	 */
	public List<String> getIngredientNameList(){
		List<Ingredients> ing=new ArrayList<Ingredients>();
		List<String> ingredientNameList=new ArrayList<>();
		ing=getIngredientList();
		for(Ingredients i:ing) {
			ingredientNameList.add(i.getIngredientName());
		}
		return ingredientNameList;
	}
	
	
	/**
	 * fetches recipe list from database based on search query
	 * @return
	 */
	public List<Recipe> fetchRecipes(Recipe recipe) {
		StringBuilder query = new StringBuilder("select r.recipe_id, r.recipe_title, r.cuisine, r.cuisine_type, r.details, r.recipe_type, r.recipe_image "
				+ "from recipe r ");
	    query.append("join recipe_ingredient_mapping m on m.recipe_id = r.recipe_id"
	    		+ " join ingredients i on i.ingredient_id=m.ingredient_id where ");
		if (recipe.getIngredientNameList() != null) {
			//creating a comma seperate list of ingredient Names
			String inSql = recipe.getIngredientNameList().stream().map(s -> "'" + s + "'").collect(Collectors.joining(", "));
			query.append("i.ingredient_name IN (" + inSql + ") ");
		}
		if (recipe.getRecipeType() != null) {
			query.append("AND r.recipe_type= '" + recipe.getRecipeType() + "' ");
		} 
		if(recipe.getCuisine()!=null) {
			query.append("AND r.cuisine = '" + recipe.getCuisine()+ "' ");
		}
		if(recipe.getCuisineType()!=null) {
			query.append("AND r.cuisine_type= '" + recipe.getCuisineType() + "' ");
		}
	    query.append("group by r.recipe_id");
		List<Recipe> recipeList = new ArrayList<>();
		recipeList = jdbcTemplate.query(query.toString(), new RowMapper<Recipe>() {

			public Recipe mapRow(ResultSet rs, int row) throws SQLException {
				Recipe recipe = new Recipe();
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
		return recipeList;
	}

	
}
