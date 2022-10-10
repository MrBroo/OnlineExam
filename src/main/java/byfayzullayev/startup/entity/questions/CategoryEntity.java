package byfayzullayev.startup.entity.questions;

import byfayzullayev.startup.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class CategoryEntity extends BaseEntity {

    private String title;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<QuizEntity> quizzes = new LinkedHashSet<>();

    public CategoryEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<QuizEntity> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<QuizEntity> quizzes) {
        this.quizzes = quizzes;
    }
}
