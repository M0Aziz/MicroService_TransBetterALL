package com.example.trans_better.Controller;

import com.example.trans_better.Entity.MoyenTransport;
import com.example.trans_better.Service.moyenTransport.IMoyenTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moyenTransport")
@CrossOrigin(origins = "http://localhost:4200")

public class MoyenTransportController {

    @Autowired
    private IMoyenTransportService iMoyenTransportService ;

    @GetMapping("/retrieveAllMoyen")
    public List<MoyenTransport> retrieveAllMoyen (){
        return iMoyenTransportService.retrieveAllMoyen();
    }

    @PostMapping("/addMoyenTransport")
    public ResponseEntity<MoyenTransport> addMoyenTransportService(@RequestBody MoyenTransport e) {
        return ResponseEntity.ok(this.iMoyenTransportService.addMoyen(e));
    }

    @PutMapping("/updateMoyenTransport/{id}")
    public ResponseEntity<MoyenTransport> updateMoyenTransport(@PathVariable("id") Integer id,@RequestBody MoyenTransport e){
        return ResponseEntity.ok(this.iMoyenTransportService.updateMoyen(id,e));
    }

    @GetMapping("/getByIdMoyenTransport/{id}")
    public MoyenTransport getByIdMoyenTransport (@PathVariable("id") Integer idE){
        return this.iMoyenTransportService.getByIdMoyenTransport(idE);
    }

    @DeleteMapping("/deleteMoyenTransport/{id}")
    public void  deleteMoyenTransport (@PathVariable("id") int id){
        this.iMoyenTransportService.deleteById(id);
    }

}
