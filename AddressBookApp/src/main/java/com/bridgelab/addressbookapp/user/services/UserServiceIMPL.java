package com.bridgelab.addressbookapp.user.services;

import com.bridgelab.addressbookapp.addressBook.dao.AddressBookRepository;
import com.bridgelab.addressbookapp.user.dao.UserRepository;
import com.bridgelab.addressbookapp.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressBookRepository addressBookRepository;

    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return "User Added Successfully";
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public String update(User user,int uId) {
        User temp = userRepository.findById(uId).get();
        if(temp!=null){
            userRepository.save(user);
        }else{
            return "User Id Not Found";
        }
        return "Updated Successfully";
    }

    @Override
    public String deleteUser(int uId) {
        User tempU = userRepository.findById(uId).get();
        if(tempU!=null){
            userRepository.deleteById(uId);
        }else{
            return "Id Not Found";
        }
        return "User Deleted Successfully";
    }

    @Override
    public String deleteAddress(int uId, int aId) {
        User user = userRepository.findById(uId).get();
        if(user!=null){
            addressBookRepository.deleteById(aId);
        }else{
            return "Id Not Found";
        }
        return "Address Deleted Successfully";
    }

}
