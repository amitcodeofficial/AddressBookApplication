package com.bridgelab.addressbookapp.user.controller;

import com.bridgelab.addressbookapp.user.dao.UserRepository;
import com.bridgelab.addressbookapp.user.model.User;
import com.bridgelab.addressbookapp.user.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user){
        String addMessage = iUserService.addUser(user);
        return new ResponseEntity<String>(addMessage, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUser(){
        List<User> users= iUserService.getUser();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping("/update/{uId}")
    public ResponseEntity<String> update(@RequestBody User user, @PathVariable int uId){
        String updateMessage = iUserService.update(user,uId);
        return new ResponseEntity<String>(updateMessage,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{uId}")
    public ResponseEntity<String> deleteUser(@PathVariable int uId){
        String deleteUMessage = iUserService.deleteUser(uId);
        return new ResponseEntity<String>(deleteUMessage,HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress/{uId}/{aId}")
    public ResponseEntity<String> deleteAddress(@PathVariable int uId,@PathVariable int aId){
        String deleteAMessage = iUserService.deleteAddress(uId,aId);
        return new ResponseEntity<String>(deleteAMessage, HttpStatus.OK);
    }

}
