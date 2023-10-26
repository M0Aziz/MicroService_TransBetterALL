package com.example.trans_better.Service;

import com.example.trans_better.Entity.SousCategorie;
import com.example.trans_better.Repository.SousCategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SousCategorieServiceImpl implements SousCategorieService {
    @Autowired
    private SousCategorieRepository sousCategorieRepository;

    @Override
    public List<SousCategorie> getAllSousCategories() {
        return sousCategorieRepository.findAll();
    }

    @Override
    public SousCategorie getSousCategorieById(Long id) {
        Optional<SousCategorie> sousCategorieOptional = sousCategorieRepository.findById(id);
        if (sousCategorieOptional.isPresent()) {
            return sousCategorieOptional.get();
        } else {
            throw new RuntimeException("Sous-categorie introuvable avec l'ID : " + id);
        }
    }

    @Override
    public SousCategorie saveSousCategorie(SousCategorie sousCategorie) {
        return sousCategorieRepository.save(sousCategorie);
    }

    @Override
    public void deleteSousCategorie(Long id) {
        SousCategorie sousCategorie = sousCategorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-categorie introuvable avec l'ID : " + id));

        sousCategorieRepository.delete(sousCategorie);
    }

    @Override
    public SousCategorie updateSousCategorie(Long id, SousCategorie sousCategorie) {
        SousCategorie existingSousCategorie = sousCategorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-categorie introuvable avec l'ID : " + id));

        // Mettez à jour les propriétés de la sous-catégorie existante
        existingSousCategorie.setNom(sousCategorie.getNom());

        // Vous pouvez également mettre à jour la catégorie parente si nécessaire
        existingSousCategorie.setCategorie(sousCategorie.getCategorie());

        return sousCategorieRepository.save(existingSousCategorie);
    }

}
