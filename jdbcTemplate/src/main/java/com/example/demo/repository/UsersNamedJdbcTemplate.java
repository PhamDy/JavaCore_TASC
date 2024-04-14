package com.example.demo.repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.Users;
import com.example.demo.rowmappers.UsersRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository("NamedJdbcTemplate")
public class UsersNamedJdbcTemplate implements UsersDAO{

    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    public UsersNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate){
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    @Override
    public int saveAddress(Address address) {
        String sql = "INSERT INTO address(city, phone)" +
                " VALUES (:city, :phone)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("city", address.getCity())
                        .addValue("phone", address.getPhone());
        return namedJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public int saveUser(Users user) {
        String sql = "INSERT INTO users(name,age,address_id)" +
                " VALUES (:name, :age, :address_id)";
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
//        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
//        parameterSource.addValue("name", user.getName())
//                        .addValue("age", user.getAge())
//                        .addValue("address_id", user.getAddress_id());
        return namedJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public int saveBatch(List<Users> usersList) {
        String sql = "INSERT INTO users(name,age,address_id)" +
                " VALUES (:name, :age, :address_id)";
        SqlParameterSource[] batchArgs = usersList.stream()
                .map(users -> new MapSqlParameterSource()
                        .addValue("name", users.getName())
                        .addValue("age", users.getAge())
                        .addValue("address_id", users.getAddress_id()))
                .toArray(SqlParameterSource[]::new);
        return Arrays.stream(namedJdbcTemplate.batchUpdate(sql, batchArgs)).sum();
    }

    @Override
    public List<Users> getAll() {
        String sql = "SELECT * FROM users";
        return namedJdbcTemplate.query(sql, new UsersRowMapper());
    }

    @Override
    public List<Users> findUsersAge(int age) {
        String sql = "SELECT * FROM users WHERE age = :age";
        SqlParameterSource parameterSource = new MapSqlParameterSource("age", age);
        return namedJdbcTemplate.query(sql, parameterSource, new UsersRowMapper());
    }

    @Override
    public List<Users> findUsersName(String name) {
        String sql = "SELECT * FROM users WHERE name = :name";
        SqlParameterSource parameterSource = new MapSqlParameterSource("name", name);
        return namedJdbcTemplate.query(sql, parameterSource, BeanPropertyRowMapper.newInstance(Users.class));
    }

    @Override
    public int updateUserName(String name, int id) {
        String sql = "UPDATE users SET name = :name WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id)
                        .addValue("name", name);
        return namedJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public int deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return namedJdbcTemplate.update(sql, parameterSource);
    }
}
