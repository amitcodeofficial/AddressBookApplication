package com.bridgelab.addressbookapp.addressBook.services;

import com.bridgelab.addressbookapp.addressBook.dao.AddressBookRepository;
import com.bridgelab.addressbookapp.addressBook.model.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookIMPL implements IAddressBookService{
    List<AddressBook> addressBooks = new ArrayList<AddressBook>();

    @Autowired
    AddressBookRepository addressBookRepository;

    @Override
    public String addAddress(AddressBook addressBook) {
        addressBookRepository.save(addressBook);
        return "Address added successfully";
    }

    @Override
    public List<AddressBook> getAddressBook() {
        return addressBookRepository.findAll();
    }
}
