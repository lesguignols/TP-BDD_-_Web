package fr.istv.bug_tracking.route;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.istv.bug_tracking.exception.ResourceNotFoundException;
import fr.istv.bug_tracking.models.CreateDevelopper;
import fr.istv.bug_tracking.models.Developper;
import fr.istv.bug_tracking.repositories.DevelopperRepository;
import fr.istv.bug_tracking.service.DevelopperService;

@RestController
public class DevelopperRoute {

    @Autowired
    DevelopperRepository developpersRepository;

    @Autowired
    DevelopperService developperService;

    @GetMapping("developpers/{id}")
    public Developper getDevelopper(@PathVariable("id") Integer id) {
        return developpersRepository.findById(id).orElse(null);
    }

    @GetMapping("developpers")
    public List<Developper> getAllDevelopper() {
        return developpersRepository.findAll();
    }

    @GetMapping("developpers/{id}/marks")
    public Developper getDevelopperMarks(@PathVariable("id") Integer id, @RequestParam("subject") String subjet) {
        // do your treatment here
        return null;
    }
    
    @PostMapping("developpers")
    public Developper createDevelopper(@Validated @RequestBody CreateDevelopper developper) { 
        return developpersRepository.save(
            Developper
            .builder()
            .name(developper.getName())
            .firstName(developper.getFirstName())
            .build()
        );
    }

    @DeleteMapping("developpers/{id}")
    public ResponseEntity<?> createDevelopper(@PathVariable("id") Integer id) {
        if(!developpersRepository.existsById(id)) {
            throw new ResourceNotFoundException("Developper not found with id " + id);
        }

        return developpersRepository.findById(id)
                .map(developper -> {
                    developpersRepository.delete(developper);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Developper not found with id " + id));

    }
}
