package com.example.usercontact.repository;

import com.example.usercontact.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserrRepository extends JpaRepository<Userr,Integer> {

}
