package com.bridgelab.addressbookapp.user.controller;

import com.bridgelab.addressbookapp.user.dao.UserRepository;
import com.bridgelab.addressbookapp.user.model.User;
import com.bridgelab.addressbookapp.user.services.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = {"User Controller"})
@Tag(name = "User Controller", description = "This Controller provides services to user to add,get,update and delete user data and add a address list data of his friends.")
public class UserController {

    @Autowired
    IUserService iUserService;

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "This service is used to Add User And Address into the API.")
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user){
        String addMessage = iUserService.addUser(user);
        return new ResponseEntity<String>(addMessage, HttpStatus.OK);
    }

    @ApiOperation(value = "This service is used to get all the user data from API.")
    @GetMapping("/get")
    public ResponseEntity<List<User>> getUser(){
        List<User> users= iUserService.getUser();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "This service is used to update User data in API.",notes = "uId -> User Id Your Have to provide proper user id to update user data.")
    @PostMapping("/update/{uId}")
    public ResponseEntity<String> update(@RequestBody User user, @PathVariable int uId){
        String updateMessage = iUserService.update(user,uId);
        return new ResponseEntity<String>(updateMessage,HttpStatus.OK);
    }

    @ApiOperation(value = "This service is used to delete a user.")
    @DeleteMapping("/deleteUser/{uId}")
    public ResponseEntity<String> deleteUser(@PathVariable int uId){
        String deleteUMessage = iUserService.deleteUser(uId);
        return new ResponseEntity<String>(deleteUMessage,HttpStatus.OK);
    }

    @ApiOperation(value = "This service is used to delete a address in API.")
    @DeleteMapping("/deleteAddress/{uId}/{aId}")
    public ResponseEntity<String> deleteAddress(@PathVariable int uId,@PathVariable int aId){
        String deleteAMessage = iUserService.deleteAddress(uId,aId);
        return new ResponseEntity<String>(deleteAMessage, HttpStatus.OK);
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User userE = userRepository.findByEmail(email);
        return new ResponseEntity<User>(userE,HttpStatus.OK);
    }

}
