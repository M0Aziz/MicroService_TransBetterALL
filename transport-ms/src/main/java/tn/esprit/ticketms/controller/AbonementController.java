package tn.esprit.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ticketms.entities.Abonement;
import tn.esprit.ticketms.repositories.AbonementRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Abonements")
public class AbonementController {

    @Autowired
    private AbonementRepository abonementRepository;

    @ResponseBody
    @GetMapping("/all")
    public List<Abonement> getAllAbonements() {
        return abonementRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abonement> getTicketById(@PathVariable Long id) {
        Optional<Abonement> Abonement = abonementRepository.findById(id);
        return Abonement.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Abonement> createAbonement(@RequestBody Abonement Abonement) {
        Abonement createdAbonement = abonementRepository.save(Abonement);
        return ResponseEntity.ok(createdAbonement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abonement> updateTicket(@PathVariable Long id, @RequestBody Abonement updatedAbonement) {
        Optional<Abonement> optionalAbonement= abonementRepository.findById(id);

        if (optionalAbonement.isPresent()) {
            Abonement existingAbonement = optionalAbonement.get();
            existingAbonement.setTitle(optionalAbonement.get().getTitle());
            existingAbonement.setPrice(optionalAbonement.get().getPrice());

            Abonement savedAbonement = abonementRepository.save(existingAbonement);
            return ResponseEntity.ok(savedAbonement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        Optional<Abonement> optionalAbonement = abonementRepository.findById(id);

        if (optionalAbonement.isPresent()) {
            abonementRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}