package fr.m2i.medical.service;

import fr.m2i.medical.api.PatientAPIController;
import fr.m2i.medical.entities.PatientEntity;
import fr.m2i.medical.entities.VilleEntity;
import fr.m2i.medical.repository.PatientRepository;
import fr.m2i.medical.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PatientService {

    private PatientRepository pr;
    private VilleService vs;

    public PatientService( PatientRepository pr ){
        this.pr = pr;
    }

    public Iterable<PatientEntity> findAll() {
        return pr.findAll();
    }

    private void checkPatient( PatientEntity p ) throws InvalidObjectException {

        if( p.getNom().length() < 2  ){
            throw new InvalidObjectException("Nom de patient invalide");
        }
        if( p.getPrenom().length() < 2  ){
            throw new InvalidObjectException("Prenom de patient invalide");
        }
        if( p.getAdresse().length() <= 10 ) {
            throw new InvalidObjectException("Adresse de patient invalide");
        }

    }

    public PatientEntity findPatient(int id) {
        return pr.findById(id).get();
    }

    public void addPatient( PatientEntity p ) throws InvalidObjectException {
        checkPatient(p);
        pr.save(p);
    }

    public void delete(int id) {
        pr.deleteById(id);
    }

    public void editPatient( int id , PatientEntity p) throws InvalidObjectException , NoSuchElementException {
        checkPatient(p);
        try{
            PatientEntity pExistante = pr.findById(id).get();

            pExistante.setPrenom( p.getPrenom() );
            pExistante.setNom( p.getNom() );
            pExistante.setDatenaissance( p.getDatenaissance() );
            pExistante.setAdresse( p.getAdresse() );
            pExistante.setVille( p.getVille() );

            pr.save( pExistante );

        }catch ( NoSuchElementException e ){
            throw e;
        }

    }
}
