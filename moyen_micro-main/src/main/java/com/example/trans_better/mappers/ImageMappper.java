package com.example.trans_better.mappers;

import com.example.trans_better.dto.ImageDto;
import com.example.trans_better.Entity.Image_moyen;

public class ImageMappper {

    public  static Image_moyen mapToEntity (ImageDto imageDto){
        Image_moyen  image_moyen= Image_moyen.builder()
                .idImageMoyen(imageDto.getIdImageMoyen())
                .path(imageDto.getPath())
                .build();
        return  image_moyen ;
    }
}
