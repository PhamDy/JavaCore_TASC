package com.example.demo.thread;

import com.example.demo.entity.Users;
import com.example.demo.respository.UserRepository;
import lombok.SneakyThrows;

import java.util.List;

public class UserRunnablePlus implements Runnable{

    private final UserRepository userRepository;
    private List<Users> usersList;

    public UserRunnablePlus(UserRepository userRepository, List<Users> usersList) {
        this.userRepository = userRepository;
        this.usersList = usersList;
    }

    @SneakyThrows
    @Override
    public void run(){
        userRepository.saveAll(usersList);
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}
