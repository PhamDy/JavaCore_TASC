package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Users;
import com.example.demo.repository.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
//    @Qualifier("JdbcTemplate")
    @Qualifier("NamedJdbcTemplate")
    private UsersDAO usersRepository;

    public int saveAddress(Address address){
        return usersRepository.saveAddress(address);
    }

    public int saveUser(Users user){
        return usersRepository.saveUser(user);
    }

    public int saveBatch(List<Users> user){
       return usersRepository.saveBatch(user);
    }

    public List<Users> getAll(){
        return usersRepository.getAll();
    }

    public List<Users> getUsersByAge(int age){
        return usersRepository.findUsersAge(age);
    }

    public List<Users> getUsersByName(String name){
        return usersRepository.findUsersName(name);
    }

    public int updateUserName(String name, int id){
        return usersRepository.updateUserName(name, id);
    }

    public int deleteUserById(int id){
        return usersRepository.deleteUserById(id);
    }


}
