package edu.fundatec.story.game.microservice.act;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document
@Getter
public class Act {

    @Id
    private String id;

    @NotNull
    @NotEmpty
    private String storyId;

    @NotNull
    @NotEmpty
    private String description;

    private String cover;

    private List<Choice> choices;

}
