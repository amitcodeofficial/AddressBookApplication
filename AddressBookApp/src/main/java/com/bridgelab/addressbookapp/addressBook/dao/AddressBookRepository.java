package com.bridgelab.addressbookapp.addressBook.dao;

import com.bridgelab.addressbookapp.addressBook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
}
