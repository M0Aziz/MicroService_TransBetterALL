package tn.esprit.ticketms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ticketms.entities.Abonement;

@Repository
public interface AbonementRepository extends JpaRepository<Abonement, Long> {

}
