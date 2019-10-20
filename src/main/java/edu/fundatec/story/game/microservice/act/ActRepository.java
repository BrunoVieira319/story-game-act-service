package edu.fundatec.story.game.microservice.act;

import com.mongodb.QueryBuilder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ActRepository extends MongoRepository<Act, String> {

    List<Act> findActsByStoryId(String storyId);

    @Query(value="{'storyId':?0}", fields = "{'_id':1, 'title':1}")
    List<ActDto> findActTitles(String storyId);
}
