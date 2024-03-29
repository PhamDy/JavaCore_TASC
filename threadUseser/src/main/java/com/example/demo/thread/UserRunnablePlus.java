package com.example.demo.thread;

import com.example.demo.entity.Users;
import com.example.demo.respository.UserRepository;
import com.example.demo.service.UsersService;
import lombok.SneakyThrows;

import java.util.List;

public class UserRunnablePlus implements Runnable{

    private final UserRepository userRepository;

    public UserRunnablePlus(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SneakyThrows
    @Override
    public void run(){
        synchronized (UsersService.usersQueue){
            for (int i = 0; i < UsersService.MAX_SIZE; i++) {
                UsersService.usersList.add(UsersService.usersQueue.poll());
            }
        }
        userRepository.saveAll(UsersService.usersList);
        System.out.println(Thread.currentThread().getId());
        Thread.sleep(1000);
    }
}
