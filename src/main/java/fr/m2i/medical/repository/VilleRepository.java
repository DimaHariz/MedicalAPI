package fr.m2i.medical.repository;

import fr.m2i.medical.entities.VilleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VilleRepository extends CrudRepository<VilleEntity, Integer> {

    public List<VilleEntity> findByNomContains(String search );
}