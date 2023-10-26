package com.example.trans_better.Service;

import com.example.trans_better.Entity.Categorie;

import java.util.List;

public interface CategorieService {
    List<Categorie> getAllCategories();
    Categorie getCategorieById(Long id);
    Categorie saveCategorie(Categorie categorie);
    void deleteCategorie(Long id);

    Categorie updateCategorie(Long id, Categorie categorie);

}
