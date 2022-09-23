package byfayzullayev.startup.service.impl;

import byfayzullayev.startup.Repository.QuizRepository;
import byfayzullayev.startup.entity.Category;
import byfayzullayev.startup.entity.Quiz;
import byfayzullayev.startup.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long id) {

        return quizRepository.findById(id).get();
    }

    @Override
    public void deleteQuiz(Long id) {
        Quiz quiz = new Quiz();
        quiz.setId(id);
        quizRepository.delete(quiz);
    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return quizRepository.findByCategory(category);
    }
}
