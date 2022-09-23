package byfayzullayev.startup.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Question extends Base {

    @Column(columnDefinition = "text")
    private String content;
    private String image;

    public String getGetNumberOfOption() {
        return getNumberOfOption;
    }

    public void setGetNumberOfOption(String getNumberOfOption) {
        this.getNumberOfOption = getNumberOfOption;
    }

    private String getNumberOfOption;

    @ManyToOne
    private Quiz quiz;

    public Set<OptionEntity> getOptionEntities() {
        return optionEntities;
    }

    public void setOptionEntities(Set<OptionEntity> optionEntities) {
        this.optionEntities = optionEntities;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<OptionEntity> optionEntities = new HashSet<>();

    public Question() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
