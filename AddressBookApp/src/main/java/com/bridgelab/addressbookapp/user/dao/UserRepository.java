package com.bridgelab.addressbookapp.user.dao;

import com.bridgelab.addressbookapp.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
