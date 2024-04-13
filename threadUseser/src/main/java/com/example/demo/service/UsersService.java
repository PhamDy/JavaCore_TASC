package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Users;
import com.example.demo.respository.UserRepository;
import com.example.demo.thread.UserRunnable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;

@Service
@EnableScheduling
public class UsersService {

    public static int BATCH_SIZE = 200;

    public static final int NUM_THREAD = 3;

    public static Queue<Users> usersQueueSingle = new ArrayDeque<>();

    public static BlockingQueue<Users> usersQueueMulti = new LinkedBlockingQueue<>();

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        autoSaveMultiThread();
    }

    public void saveSingleThread(UserDto dto) {
        var user = mapToEntity(dto);
        usersQueueSingle.offer(user);
    }

    public void saveMultiThread(UserDto dto) {
        var user = mapToEntity(dto);
        try {
            usersQueueMulti.put(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Đơn tiến trình
    @Scheduled(fixedDelay = 2000)
    public void autoSaveSingleThread() {
        System.out.println("start thread ..." + Thread.currentThread().getId());
        System.out.println(usersQueueSingle);
        if (usersQueueSingle.size() < BATCH_SIZE) {
            List<Users> usersList = new ArrayList<>();
            while (!usersQueueSingle.isEmpty()) {
                usersList.add(usersQueueSingle.poll());
            }
            userRepository.saveAll(usersList);
        } else {
            Users user;
            List<Users> usersList = new ArrayList<>();
            for (int i = 0; i < BATCH_SIZE; i++) {
                user = usersQueueSingle.poll();
                if (user != null)
                    usersList.add(user);
            }
            userRepository.saveAll(usersList);
            System.out.println("Save successfully!");
        }
    }

    // Đa tiến trình
    public void autoSaveMultiThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREAD);
        for (int i = 1; i <= NUM_THREAD; i++) {
            executorService.submit(new UserRunnable(userRepository));
        }
    }

    public Users mapToEntity(UserDto dto) {
        return Users.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .build();
    }
}
