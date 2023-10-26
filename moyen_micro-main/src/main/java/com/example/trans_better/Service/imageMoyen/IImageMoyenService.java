package com.example.trans_better.Service.imageMoyen;

import com.example.trans_better.dto.ImageDto;
import com.example.trans_better.Entity.Image_moyen;

import java.util.List;

public interface IImageMoyenService {
    List<Image_moyen> retrieveAllImageMoyen();
    ImageDto addImageMoyen(ImageDto imageDto);

    Image_moyen updateImageMoyen(int id, Image_moyen imageMoyen);

    Image_moyen getImageMoyenById(Integer idE);

    void deleteById(int id);

}
