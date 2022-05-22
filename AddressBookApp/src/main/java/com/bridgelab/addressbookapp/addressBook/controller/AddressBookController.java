package com.bridgelab.addressbookapp.addressBook.controller;

import com.bridgelab.addressbookapp.addressBook.dao.AddressBookRepository;
import com.bridgelab.addressbookapp.addressBook.model.AddressBook;
import com.bridgelab.addressbookapp.addressBook.services.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    @Autowired
    IAddressBookService iAddressBookService;

    @PostMapping("/add")
    public ResponseEntity<String> addAddress(@RequestBody AddressBook addressBook){
        String addMessage = iAddressBookService.addAddress(addressBook);
        return new ResponseEntity<String>(addMessage, HttpStatus.OK);
    }

    @GetMapping("get")
    public ResponseEntity<List<AddressBook>> getUser(){
        List<AddressBook> addressBook = iAddressBookService.getAddressBook();
        return new ResponseEntity<List<AddressBook>>(addressBook, HttpStatus.OK);
    }
}
