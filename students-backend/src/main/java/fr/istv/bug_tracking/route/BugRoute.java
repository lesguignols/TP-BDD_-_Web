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
import fr.istv.bug_tracking.models.CreateBug;
import fr.istv.bug_tracking.models.Bug;
import fr.istv.bug_tracking.repositories.BugRepository;
import fr.istv.bug_tracking.service.BugService;

@RestController
public class BugRoute {

    @Autowired
    BugRepository bugRepository;

    @Autowired
    BugService bugService;

    @GetMapping("bugs/{id}")
    public Bug getBug(@PathVariable("id") Integer id) {
        return bugRepository.findById(id).orElse(null);
    }

    @GetMapping("bugs")
    public List<Bug> getAllBug() {
        return bugRepository.findAll();
    }

    @GetMapping("bugs/{id}/marks")
    public Bug getBugMarks(@PathVariable("id") Integer id, @RequestParam("subject") String subjet) {
        // do your treatment here
        return null;
    }
    
    @PostMapping("bugs")
    public Bug createBug(@Validated @RequestBody CreateBug bug) { 
        return bugRepository.save(
            Bug
            .builder()
            .title(bug.getTitle())
            .description(bug.getDescription())
            .build()
        );
    }

    @DeleteMapping("bugs/{id}")
    public ResponseEntity<?> createBug(@PathVariable("id") Integer id) {
        if(!bugRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bug not found with id " + id);
        }

        return bugRepository.findById(id)
                .map(bug -> {
                    bugRepository.delete(bug);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Bug not found with id " + id));

    }
}
