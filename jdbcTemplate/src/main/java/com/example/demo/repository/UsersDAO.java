package com.example.demo.repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.Users;

import java.util.List;

public interface UsersDAO {
    int saveAddress(Address address);
    int saveUser(Users user);
    int saveBatch(List<Users> usersList);
    List<Users> getAll();
    List<Users> findUsersAge(int age);
    List<Users> findUsersName(String name);
    int updateUserName(String name, int id);
    int deleteUserById(int id);
}
