package fr.m2i.medical.api;

import fr.m2i.medical.entities.VilleEntity;
import fr.m2i.medical.entities.VilleEntity;
import fr.m2i.medical.repository.VilleRepository;
import fr.m2i.medical.service.VilleService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/ville")
public class VilleAPIController {

    VilleService vs;

    public VilleAPIController( VilleService vs ){
        this.vs = vs;
    }

    @GetMapping(value="" , produces = "application/json")
    public Iterable<VilleEntity> getAll(){
        return vs.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public VilleEntity get(@PathVariable int id) {
        return vs.findVille(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) throws Exception {
        vs.delete(id);
    }
}