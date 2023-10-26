package com.example.usercontact.service;

import com.example.usercontact.entity.Contactus;

import java.util.List;
import java.util.Optional;

public interface ContactusService {

    List<Contactus> getAllContacts();
    Optional<Contactus> getContactById(int id);
    Contactus saveContact(Contactus contactus);
    void deleteContact(int id);

    Contactus updateContact(int id, Contactus contactus);
}
