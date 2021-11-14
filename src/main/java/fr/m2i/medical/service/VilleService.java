package fr.m2i.medical.service;

import fr.m2i.medical.api.VilleAPIController;
import fr.m2i.medical.entities.VilleEntity;
import fr.m2i.medical.repository.VilleRepository;
import org.springframework.stereotype.Service;

@Service
public class VilleService {

    private VilleRepository vr;

    public VilleService( VilleRepository vr ){
        this.vr = vr;
    }

    public Iterable<VilleEntity> findAll() {
        return vr.findAll();
    }

    public VilleEntity findVille(int id) {
        return vr.findById(id).get();
    }

    public void delete(int id) {
        vr.deleteById(id);
    }
}
