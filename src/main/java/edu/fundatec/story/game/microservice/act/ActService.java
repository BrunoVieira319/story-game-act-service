package edu.fundatec.story.game.microservice.act;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActService {

    private ActRepository actRepository;

    @Autowired
    public ActService(ActRepository actRepository) {
        this.actRepository = actRepository;
    }

    public Act saveAct(Act act) {
        return actRepository.save(act);
    }

    public Act findActById(String actId) {
        Optional<Act> optionalAct = actRepository.findById(actId);
        return optionalAct.orElseThrow(() -> new IllegalArgumentException("Id not found"));
    }

    public List<Act> findActsByStoryId(String storyId) {
        return actRepository.findActsByStoryId(storyId);
    }
}
