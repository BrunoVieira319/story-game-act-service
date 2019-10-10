package edu.fundatec.story.game.microservice.act;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/acts")
public class ActController {

    private ActService actService;

    @Autowired
    public ActController(ActService actService) {
        this.actService = actService;
    }

    @PostMapping
    public ResponseEntity<Act> saveAct(@RequestBody Act act) {
        Act savedAct = actService.saveAct(act);
        return new ResponseEntity<>(savedAct, HttpStatus.CREATED);
    }

    @GetMapping("/{actId}")
    public ResponseEntity<Act> findAct(@PathVariable String actId) {
        Act act = actService.findActById(actId);
        return new ResponseEntity<>(act, HttpStatus.OK);
    }

    @GetMapping("/story/{storyId}")
    public ResponseEntity findActsFromStory(@PathVariable String storyId) {
        List<Act> acts = actService.findActsByStoryId(storyId);
        return new ResponseEntity<>(acts, HttpStatus.OK);
    }
}
