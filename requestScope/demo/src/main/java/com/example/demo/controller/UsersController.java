package com.example.demo.controller;

import com.example.demo.service.Impl.UsersService;
import com.example.demo.service.UsersServiceImpl1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",maxAge = 3600)
@Slf4j
public class UsersController {

    public static int count = 1;

    @Autowired
    private UsersServiceImpl1 usersService;

    @PostMapping("/")
    public ResponseEntity<?> test(@RequestParam(name = "id") Integer id, @RequestParam(name = "name") String name){
        usersService.save(id, name);
        log.info("Số lượng request: " + count);
        count++;
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

}
