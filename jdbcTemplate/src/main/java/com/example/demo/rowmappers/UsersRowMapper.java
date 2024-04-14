package com.example.demo.rowmappers;

import com.example.demo.entity.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRowMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users users = new Users();
        users.setId(rs.getInt("id"));
        users.setName(rs.getString("name"));
        users.setAge(rs.getInt("age"));
        users.setAddress_id(rs.getInt("address_id"));
        return users;
    }
}
