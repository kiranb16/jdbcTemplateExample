package com.NelsonIQ.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public UserDao() {

	}
  //table create
	public int createTable() {
		String query = "create table if not exists User(id int primary key, name varchar(200), age int, city varchar(100))";

		int update = this.jdbcTemplate.update(query);
		//System.out.println("Table created constructor called " + update);

		return update; 
	}
	//inserting user into database
	public int insertUser( Integer id, String name, Integer age,String city ) {
		String query=" insert into User(id,name,age,city) values(?,?,?,?)";
		int update=this.jdbcTemplate.update(query, new Object[] {id,name,age,city});
		return update;
	}
	
	public int deleteUser( Integer id) {
		String query="delete from user where id= :id";
		MapSqlParameterSource src = new MapSqlParameterSource();
		src.addValue("id",1);
		namedParameterJdbcTemplate.queryForMap(query, src);
		 int update=this.jdbcTemplate.update(query, id);
		return update;
	}
	
	public int upadateUser(Integer id, String name, int age, String city) {
		 String query = "UPDATE user SET name = ?, age = ?, city = ? WHERE id = ?";
		    
		    // Perform the update and return the number of affected rows
		    return this.jdbcTemplate.update(query, name, age, city, id);
	}
}





















