package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/saveAddress")
    public ResponseEntity<?> saveAddress(@RequestBody Address address){
        return new ResponseEntity<>(usersService.saveAddress(address), HttpStatus.CREATED);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody Users user){
        return new ResponseEntity<>(usersService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/saveBatch")
    public ResponseEntity<?> saveBatch(@RequestBody List<Users> usersList){
        return new ResponseEntity<>(usersService.saveBatch(usersList), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(usersService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/age")
    public ResponseEntity<?> getAge(@RequestParam int age){
        return new ResponseEntity<>(usersService.getUsersByAge(age), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<?> getName(@RequestParam String name){
        return new ResponseEntity<>(usersService.getUsersByName(name), HttpStatus.OK);
    }

    @PatchMapping("/updateUserName")
    public ResponseEntity<?> getName(@RequestParam String name, @RequestParam int id){
        return new ResponseEntity<>(usersService.updateUserName(name, id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteByUserId")
    public ResponseEntity<?> deleteUserById(@RequestParam int id){
        return new ResponseEntity<>(usersService.deleteUserById(id), HttpStatus.OK);
    }

}
