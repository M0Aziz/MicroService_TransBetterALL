package  com.example.trans_better.Service.moyenTransport;

import com.example.trans_better.Entity.MoyenTransport;

import java.util.List;

public interface IMoyenTransportService {
    List<MoyenTransport> retrieveAllMoyen();

    MoyenTransport addMoyen(MoyenTransport moyenTransport);

    MoyenTransport updateMoyen(int id, MoyenTransport newMoyenTransport);


    MoyenTransport getByIdMoyenTransport(Integer idE);

    void deleteById(int id);
}
