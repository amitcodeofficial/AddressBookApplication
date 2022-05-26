package com.bridgelab.addressbookapp.user.services;

import com.bridgelab.addressbookapp.user.model.User;

import java.util.List;

public interface IUserService {
    public String addUser(User user);
    public List<User> getUser();
    public User getUserById(int id);
    public String update(User user,int uId);
    public String deleteUser(int uId);
    public String deleteAddress(int uId, int aId);
}
