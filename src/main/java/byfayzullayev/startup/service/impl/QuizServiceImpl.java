package byfayzullayev.startup.service.impl;

import byfayzullayev.startup.Repository.QuizRepository;
import byfayzullayev.startup.entity.questions.CategoryEntity;
import byfayzullayev.startup.entity.questions.QuizEntity;
import byfayzullayev.startup.service.QuizService;
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
    public QuizEntity addQuiz(QuizEntity quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public QuizEntity updateQuiz(QuizEntity quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<QuizEntity> getQuizzes() {
        return new HashSet<>(quizRepository.findAll());
    }

    @Override
    public QuizEntity getQuiz(Long id) {

        return quizRepository.findById(id).get();
    }

    @Override
    public void deleteQuiz(Long id) {
        QuizEntity quiz = new QuizEntity();
        quiz.setId(id);
        quizRepository.delete(quiz);
    }

    @Override
    public List<QuizEntity> getQuizzesOfCategory(CategoryEntity category) {
        return quizRepository.findByCategory(category);
    }
}
