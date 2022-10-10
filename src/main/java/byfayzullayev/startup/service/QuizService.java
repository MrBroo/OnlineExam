package byfayzullayev.startup.service;

import byfayzullayev.startup.entity.questions.CategoryEntity;
import byfayzullayev.startup.entity.questions.QuizEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {
    public QuizEntity addQuiz(QuizEntity quiz);

    public QuizEntity updateQuiz(QuizEntity quiz);

    public Set<QuizEntity> getQuizzes();

    public QuizEntity getQuiz(Long id);

    public void deleteQuiz(Long id);

    public List<QuizEntity> getQuizzesOfCategory(CategoryEntity category);
}
