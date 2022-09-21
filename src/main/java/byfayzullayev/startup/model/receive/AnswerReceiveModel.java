package byfayzullayev.startup.model.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AnswerReceiveModel {
    private String answer;
    @JsonProperty("category_id")
    private long questionsId;
}