package byfayzullayev.startup.entity.questions;

import byfayzullayev.startup.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class OptionEntity extends BaseEntity {

    private String option;
    private boolean isTrue = false;

    @ManyToOne
    @JsonBackReference
    private QuestionEntity question;

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public OptionEntity() {
    }

    public OptionEntity(String option, boolean isTrue, QuestionEntity question) {
        this.option = option;
        this.isTrue = isTrue;
        this.question = question;
    }
}
