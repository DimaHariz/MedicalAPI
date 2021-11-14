package fr.m2i.medical.repository;

import fr.m2i.medical.entities.VilleEntity;
import org.springframework.data.repository.CrudRepository;

public interface VilleRepository extends CrudRepository<VilleEntity , Integer> {

    Iterable<VilleEntity> findByNom( String nom ); // select * from ville  where nom = :nom


}