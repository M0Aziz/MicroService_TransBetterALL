package com.example.trans_better.Repository;

import com.example.trans_better.Entity.MoyenTransport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoyenTransportRepository extends JpaRepository<MoyenTransport,Integer> {
    MoyenTransport findByNumero (int num);
}
