package com.example.usercontact.controller;

import com.example.usercontact.entity.Userr;
import com.example.usercontact.service.UserrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")

public class UserrController {

    @Autowired
    private UserrService userrService;
    @GetMapping
    public List<Userr> getAllUsers() {
        return userrService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<Userr> getUserrById(@PathVariable int id) {
        Optional<Userr> userr = userrService.getUserrById(id);
        return userr;
    }

    @PostMapping
    public ResponseEntity<Userr> saveUser(@RequestBody Userr userr) {
        Userr savedu = userrService.saveUserr(userr);
        return new ResponseEntity<>(savedu, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Userr> updateUserr(@PathVariable int id, @RequestBody Userr userr) {
        Userr updatedu = userrService.updateUserr(id, userr);
        return ResponseEntity.ok(updatedu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserr(@PathVariable int id) {
        userrService.deleteUserr(id);
        return ResponseEntity.noContent().build();
    }

}
