package edu.fundatec.story.game.microservice.act;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActRepository extends MongoRepository<Act, String> {

    List<Act> findActsByStoryId(String storyId);
}
