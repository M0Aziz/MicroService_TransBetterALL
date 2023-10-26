package com.example.trans_better.Controller;

import com.example.trans_better.Entity.SousCategorie;
import com.example.trans_better.Service.SousCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/souscategories")
public class SousCategorieController {
    @Autowired
    private SousCategorieService sousCategorieService;

    @GetMapping
    public List<SousCategorie> getAllSousCategories() {
        return sousCategorieService.getAllSousCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SousCategorie> getSousCategorieById(@PathVariable Long id) {
        SousCategorie sousCategorie = sousCategorieService.getSousCategorieById(id);
        return ResponseEntity.ok(sousCategorie);
    }

    @PostMapping
    public ResponseEntity<SousCategorie> saveSousCategorie(@RequestBody SousCategorie sousCategorie) {
        SousCategorie savedSousCategorie = sousCategorieService.saveSousCategorie(sousCategorie);
        return new ResponseEntity<>(savedSousCategorie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SousCategorie> updateSousCategorie(@PathVariable Long id, @RequestBody SousCategorie sousCategorie) {
        SousCategorie updatedSousCategorie = sousCategorieService.updateSousCategorie(id, sousCategorie);
        return ResponseEntity.ok(updatedSousCategorie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSousCategorie(@PathVariable Long id) {
        sousCategorieService.deleteSousCategorie(id);
        return ResponseEntity.noContent().build();
    }
}

