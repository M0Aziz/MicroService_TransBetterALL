package com.example.usercontact.service;

import com.example.usercontact.entity.Contactus;
import com.example.usercontact.entity.Userr;
import com.example.usercontact.repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class UserrServImpl implements UserrService{
    @Autowired
    private UserrRepository userrRepository;

    @Override
    public List<Userr> getAllUsers() {
        return userrRepository.findAll();
    }

    @Override
    public Optional<Userr> getUserrById(int id) {
        return userrRepository.findById(id);
    }

    @Override
    public Userr saveUserr(Userr userr) {
        return userrRepository.save(userr);
    }

    @Override
    public void deleteUserr(int id) {
        Userr userr = userrRepository.findById(id).orElse(null);
        userrRepository.delete(userr);
    }

    @Override
    public Userr updateUserr(int id, Userr userr) {
        Userr userrM = userrRepository.findById(id).orElse(null);
        return userrRepository.save(userrM);
    }
}
