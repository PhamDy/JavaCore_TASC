package com.example.demo.repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.Users;
import com.example.demo.rowmappers.UsersRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("JdbcTemplate")
public class UsersJdbcTemplate implements UsersDAO{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Autowired
//    public UsersRepository(@Qualifier("ConnectMySql") DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    public int saveAddress(Address address){
        String sql = "INSERT INTO address(city, phone)" +
                " VALUES (?,?)";
        return jdbcTemplate.update(sql, address.getCity(), address.getPhone());
    }

    public int saveUser(Users user){
        String sql = "INSERT INTO users(name, age, address_id)" +
                " VALUES (?,?,?)";
        return jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getAddress_id());
    }

    public int saveBatch(List<Users> usersList){
        String sql = "INSERT INTO users(name, age, address_id)" +
                " VALUES (?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        for (Users user: usersList
             ) {
            Object[] agrs = new Object[]{user.getName(), user.getAge(), user.getAddress_id()};
            batchArgs.add(agrs);
        }

        return Arrays.stream(jdbcTemplate.batchUpdate(sql, batchArgs)).sum();
    }

    public List<Users> getAll(){
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UsersRowMapper());
    }

    public List<Users> findUsersAge(int age){
        String sql = "SELECT * FROM users WHERE age = ?";
        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setInt(1, age);
            }
        }, new UsersRowMapper());
    }

    public List<Users> findUsersName(String name){
        String sql = "SELECT * FROM users WHERE name = ?";
        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, name);
            }
        }, BeanPropertyRowMapper.newInstance(Users.class));
    }

    public int updateUserName(String name, int id){
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, name);
                ps.setInt(2, id);
            }
        });
    }

    public int deleteUserById(int id){
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
            }
        });
    }

}
