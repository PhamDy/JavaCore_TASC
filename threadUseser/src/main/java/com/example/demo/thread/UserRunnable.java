package com.example.demo.thread;

import com.example.demo.entity.Users;
import com.example.demo.respository.UserRepository;
import lombok.SneakyThrows;

public class UserRunnable implements Runnable{

    private final UserRepository userRepository;

    private Users users;

    public UserRunnable(UserRepository userRepository, Users users) {
        this.userRepository = userRepository;
        this.users = users;
    }

    @SneakyThrows
    @Override
    public void run(){
        userRepository.save(users);
        System.out.println(Thread.currentThread().getId());
        Thread.sleep(1000);
    }
}
