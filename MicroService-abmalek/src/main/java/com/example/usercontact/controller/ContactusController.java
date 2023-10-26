package com.example.usercontact.controller;

import com.example.usercontact.entity.Contactus;
import com.example.usercontact.entity.Userr;
import com.example.usercontact.service.ContactusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contactus")
public class ContactusController {

    @Autowired
    private ContactusService contactusService;
    @GetMapping
    public List<Contactus> getAllContacts() {
        return contactusService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Optional<Contactus> getContactById(@PathVariable int id) {
        Optional<Contactus> contactus = contactusService.getContactById(id);
        return contactus;
    }

    @PostMapping
    public ResponseEntity<Contactus> saveContact(@RequestBody Contactus contactus) {
        Contactus savedu = contactusService.saveContact(contactus);
        return new ResponseEntity<>(savedu, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Contactus> updateContact(@PathVariable int id, @RequestBody Contactus contactus) {
        Contactus updatedu = contactusService.updateContact(id, contactus);
        return ResponseEntity.ok(updatedu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable int id) {
        contactusService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}
