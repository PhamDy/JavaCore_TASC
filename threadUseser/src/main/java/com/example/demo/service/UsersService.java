package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Users;
import com.example.demo.respository.UserRepository;
import com.example.demo.thread.UserRunnable;
import com.example.demo.thread.UserRunnablePlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

@Service
@EnableScheduling
public class UsersService {

    private static Queue<Users> usersQueue = new ArrayDeque<>();

    @Autowired
    private UserRepository userRepository;

    public void save(UserDto dto){
        Users user = mapToEntity(dto);
        usersQueue.add(user);
    }

    @Scheduled(fixedDelay = 2000)
    public void autoSave(){
        System.out.println(usersQueue);
        ExecutorService service = Executors.newFixedThreadPool(5);
            if (usersQueue.size()<2){
                while (!usersQueue.isEmpty()){
                    service.submit(new UserRunnable(userRepository, usersQueue.poll()));
                    System.out.println(usersQueue);
                }
            }

            if (usersQueue.size() > 2){
                List<Users> usersList = new ArrayList<>();
                synchronized (usersQueue){
                    for (int i = 0; i <= 2 ; i++) {
                        usersList.add(usersQueue.poll());
                    }
                }
                service.submit(new UserRunnablePlus(userRepository, usersList));
                System.out.println(usersList);
                usersList.clear();
            }
        }

    public Users mapToEntity(UserDto dto){
        return Users.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .build();
    }
}
