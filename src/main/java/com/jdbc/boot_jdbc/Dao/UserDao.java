package com.jdbc.boot_jdbc.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // create table
    public int createTable () {
        String query = "CREATE TABLE IF NOT EXISTS User (id int primary key, name varchar(100), age int, city varchar(100))";
        int create = this.jdbcTemplate.update(query);
        return create;
    }

    // insert data
    public int insertUser (int id, String name, int age, String city){
        String query = "INSERT INTO User values (?,?,?,?)";
        int insert = this.jdbcTemplate.update(query, new Object[]{id, name, age, city});
        return insert;
    }

    // update data
    public int update(int id, String name, int age, String city){
        String query = "UPDATE User SET name = ?, age = ?, city = ? WHERE id = ?";
        int update = this.jdbcTemplate.update(query, new Object[]{name, age, city, id});
        return update;
    }

    // delete data
    public int delete(int id){
        String query = "DELETE FROM User WHERE id = ?";
        int delete = this.jdbcTemplate.update(query, new Object[]{id});
        return delete;
    }

}
