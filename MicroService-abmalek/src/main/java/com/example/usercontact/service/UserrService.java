package com.example.usercontact.service;

import com.example.usercontact.entity.Userr;

import java.util.List;
import java.util.Optional;

public interface UserrService {
    List<Userr> getAllUsers();
    Optional<Userr> getUserrById(int id);
    Userr saveUserr(Userr Userr);
    void deleteUserr(int id);

    Userr updateUserr(int id, Userr userr);
}
