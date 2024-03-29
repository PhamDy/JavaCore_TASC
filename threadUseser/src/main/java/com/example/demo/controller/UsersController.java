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

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody UserDto dto){
        usersService.save(dto);
        return new ResponseEntity<>("Update successfully!", HttpStatus.CREATED);
    }

}
