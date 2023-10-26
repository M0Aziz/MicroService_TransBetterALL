package com.example.usercontact.service;

import com.example.usercontact.entity.Contactus;
import com.example.usercontact.repository.ContactusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ContactusServImpl implements  ContactusService{
    @Autowired
    private ContactusRepository contactusRepository;

    @Override
    public List<Contactus> getAllContacts() {
        return contactusRepository.findAll();
    }

    @Override
    public Optional<Contactus> getContactById(int id) {
        return contactusRepository.findById(id);
    }

    @Override
    public Contactus saveContact(Contactus contactus) {
        return contactusRepository.save(contactus);
    }

    @Override
    public void deleteContact(int id) {
        Contactus contactus = contactusRepository.findById(id).orElse(null);
        contactusRepository.delete(contactus);
    }

    @Override
    public Contactus updateContact(int id, Contactus contactus) {
        Contactus contactusM = contactusRepository.findById(id).orElse(null);
        return contactusRepository.save(contactusM);
    }
}
