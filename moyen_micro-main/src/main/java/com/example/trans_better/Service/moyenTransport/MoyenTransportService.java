package  com.example.trans_better.Service.moyenTransport;

import com.example.trans_better.Entity.MoyenTransport;
import com.example.trans_better.Repository.MoyenTransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class MoyenTransportService implements IMoyenTransportService {

    @Autowired
    MoyenTransportRepository moyenTransportRepository ;

    @Override
    public List<MoyenTransport> retrieveAllMoyen(){
        return new ArrayList<>(this.moyenTransportRepository.findAll());
    }


    @Override
    public MoyenTransport addMoyen(MoyenTransport moyenTransport){
        return moyenTransportRepository.save(moyenTransport);
    }

    @Override
    public MoyenTransport updateMoyen(int id, MoyenTransport m) {
        MoyenTransport moyenTransport1= moyenTransportRepository.findById(id).orElse(null);
        if (moyenTransport1!=null){
            moyenTransport1.setDescription(m.getDescription());
            moyenTransport1.setNumero(m.getNumero());
            moyenTransport1.setHoraire(m.getHoraire());
        return moyenTransportRepository.save(moyenTransport1);
    } else
        return null;
    }
    @Override
    public MoyenTransport getByIdMoyenTransport (Integer idE){
        return this.moyenTransportRepository.findById(idE).get();
    }

    @Override
    public void deleteById(int id){
        this.moyenTransportRepository.deleteById(id);
    }
}
