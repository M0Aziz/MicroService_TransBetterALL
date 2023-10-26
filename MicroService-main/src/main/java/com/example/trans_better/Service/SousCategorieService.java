package com.example.trans_better.Service;

import com.example.trans_better.Entity.Categorie;
import com.example.trans_better.Entity.SousCategorie;

import java.util.List;

public interface SousCategorieService {

    List<SousCategorie> getAllSousCategories();
    SousCategorie getSousCategorieById(Long id);
    SousCategorie saveSousCategorie(SousCategorie sousCategorie);
    void deleteSousCategorie(Long id);
    SousCategorie updateSousCategorie(Long id, SousCategorie sousCategorie);

}
