package byfayzullayev.startup.entity.questions;


import byfayzullayev.startup.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class QuestionEntity extends BaseEntity {

    @Column(columnDefinition = "text")
    private String content;
    private String image;


    @ManyToOne
    private QuizEntity quiz;

    public Set<OptionEntity> getOptionEntities() {
        return optionEntities;
    }

    public void setOptionEntities(Set<OptionEntity> optionEntities) {
        this.optionEntities = optionEntities;
    }

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<OptionEntity> optionEntities = new HashSet<>();

    public QuestionEntity() {
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

    public QuizEntity getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizEntity quiz) {
        this.quiz = quiz;
    }
}
