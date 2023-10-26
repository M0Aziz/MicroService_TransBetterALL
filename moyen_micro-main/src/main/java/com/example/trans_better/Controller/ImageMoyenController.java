package com.example.trans_better.Controller;

import com.example.trans_better.dto.ImageDto;
import com.example.trans_better.Entity.Image_moyen;
import com.example.trans_better.Entity.MoyenTransport;
import com.example.trans_better.Service.imageMoyen.IImageMoyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imageMoyen")
@CrossOrigin(origins = "http://localhost:4200")

public class ImageMoyenController {

    @Autowired
    private IImageMoyenService iImageMoyenService ;

    @GetMapping("/retrieveAllImageMoyen")
    public List<Image_moyen> retrieveAllImageMoyen (){
        return iImageMoyenService.retrieveAllImageMoyen();
    }

    @PostMapping("/addImageMoyen")
    public ImageDto addSerie (@RequestBody ImageDto imageDto ){
        return  iImageMoyenService.addImageMoyen(imageDto);
    }

    @PutMapping("/updateImageMoyen/{id}")
    public ResponseEntity<Image_moyen> updateImageMoyen(@PathVariable("id") Integer id, @RequestBody Image_moyen e){
        return ResponseEntity.ok(this.iImageMoyenService.updateImageMoyen(id,e));
    }

    @GetMapping("/getByIdImageMoyen/{id}")
    public Image_moyen getByIdImageMoyen (@PathVariable("id") Integer idE){
        return this.iImageMoyenService.getImageMoyenById(idE);
    }

    @DeleteMapping("/deleteImageMoyen/{id}")
    public void  deleteImageMoyen (@PathVariable("id") int id){
        this.iImageMoyenService.deleteById(id);
    }
}
