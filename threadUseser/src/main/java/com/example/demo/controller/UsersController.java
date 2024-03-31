package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/singlethread")
    public ResponseEntity<?> saveSingleThread(@Valid @RequestBody UserDto dto){
        usersService.saveSingleThread(dto);
        return new ResponseEntity<>("Update successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/multithread")
    public ResponseEntity<?> saveMultiThread(@Valid @RequestBody UserDto dto){
        usersService.saveMultiThread(dto);
        return new ResponseEntity<>("Update successfully!", HttpStatus.CREATED);
    }

}
