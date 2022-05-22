package com.bridgelab.addressbookapp.addressBook.services;

import com.bridgelab.addressbookapp.addressBook.model.AddressBook;

import java.util.List;

public interface IAddressBookService {
    public String addAddress(AddressBook addressBook);
    public List<AddressBook> getAddressBook();
}
