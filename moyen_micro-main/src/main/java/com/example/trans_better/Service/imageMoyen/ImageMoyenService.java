package  com.example.trans_better.Service.imageMoyen;

import com.example.trans_better.dto.ImageDto;
import com.example.trans_better.Entity.Image_moyen;
import com.example.trans_better.Entity.MoyenTransport;
import com.example.trans_better.mappers.ImageMappper;
import com.example.trans_better.Repository.ImageMoyenRepository;
import com.example.trans_better.Repository.MoyenTransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageMoyenService implements  IImageMoyenService{

    @Autowired
    ImageMoyenRepository imageMoyenRepository ;

    @Autowired
    MoyenTransportRepository moyenTransportRepository ;

    @Override
    public List<Image_moyen> retrieveAllImageMoyen(){
        return new ArrayList<>(this.imageMoyenRepository.findAll());
    }

    @Override
    public ImageDto addImageMoyen(ImageDto imageDto){
        MoyenTransport moyenTransportAffected = moyenTransportRepository.findByNumero(imageDto.getNumMoyen());

        Image_moyen image_moyen = imageMoyenRepository.save(ImageMappper.mapToEntity(imageDto));

        image_moyen.setMoyenTransport(moyenTransportAffected);
        imageMoyenRepository.save(image_moyen);

        return  imageDto ;
    }

    @Override
    public Image_moyen updateImageMoyen(int id, Image_moyen imageMoyen) {
        Image_moyen image_moyen1= imageMoyenRepository.findById(id).orElse(null);
        if (image_moyen1!=null){
            image_moyen1.setPath(imageMoyen.getPath());
            return imageMoyenRepository.save(image_moyen1);
        } else
            return null;
    }
    @Override
    public Image_moyen getImageMoyenById (Integer idE) {
        return this.imageMoyenRepository.findById(idE).get();
    }

    @Override
    public void deleteById(int id) {
        this.imageMoyenRepository.deleteById(id);
    }
}
