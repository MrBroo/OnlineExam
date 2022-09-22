package byfayzullayev.startup.service;

import byfayzullayev.startup.entity.Category;
import byfayzullayev.startup.entity.Quiz;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(Long id);

    public void deleteQuiz(Long id);

    public List<Quiz> getQuizzesOfCategory(Category category);
}
