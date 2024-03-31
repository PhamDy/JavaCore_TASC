package com.example.demo.thread;

import com.example.demo.entity.Users;
import com.example.demo.respository.UserRepository;
import com.example.demo.service.UsersService;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class UserRunnable implements Runnable {

    private final UserRepository userRepository;

    public UserRunnable(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            System.out.println("start thread ... " + Thread.currentThread().getId());
            System.out.println(UsersService.usersQueueMulti);
            if (UsersService.usersQueueMulti.size()<UsersService.BATCH_SIZE){
                while (!UsersService.usersQueueMulti.isEmpty()){
                    userRepository.save(UsersService.usersQueueMulti.take());
                }
            } else {
                Users user;
                List<Users> usersList = new ArrayList<>();
                for (int i = 0; i < UsersService.BATCH_SIZE; i++) {
                    user = UsersService.usersQueueMulti.take();
                    if (user!=null){
                        usersList.add(user);
                    }
                }
                userRepository.saveAll(usersList);
            }
            System.out.println(Thread.currentThread().getId() + " fineshed!");
            Thread.sleep(2000);
        }
    }
}
