package tn.esprit.ticketms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ticketms.entities.Ticket;
import tn.esprit.ticketms.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Tickets")
public class TicketController {

    @Autowired
    private TicketRepository TicketRepo ;

    @ResponseBody
    @GetMapping("/all")
    public List<Ticket> getAllTickets() {

        return TicketRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> Ticket = TicketRepo.findById(id);
        return Ticket.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket Ticket) {
        Ticket createdTicket = TicketRepo.save(Ticket);
        return ResponseEntity.ok(createdTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket updatedTicket) {
        Optional<Ticket> optionalTicket = TicketRepo.findById(id);

        if (optionalTicket.isPresent()) {
            Ticket existingTicket = optionalTicket.get();
            existingTicket.setTitle(updatedTicket.getTitle());
            existingTicket.setPrice(updatedTicket.getPrice());

            Ticket savedTicket = TicketRepo.save(existingTicket);
            return ResponseEntity.ok(savedTicket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        Optional<Ticket> optionalTicket = TicketRepo.findById(id);

        if (optionalTicket.isPresent()) {
            TicketRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}