package byfayzullayev.startup.service.impl;

import byfayzullayev.startup.Repository.QuestionRepository;
import byfayzullayev.startup.entity.Question;
import byfayzullayev.startup.entity.Quiz;
import byfayzullayev.startup.service.QuestionsService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionsService {
    private final QuestionRepository questionsRepository;

    public QuestionServiceImpl(QuestionRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @Override
    public Question addQuestion(Question question) {
        return questionsRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionsRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(questionsRepository.findAll());
    }

    @Override
    public Question getQuestion(Long id) {
        return questionsRepository.findById(id).get();
    }

    @Override
    public void deleteQuestion(Long id) {
        Question question = new Question();
        question.setId(id);
        questionsRepository.delete(question);

    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return questionsRepository.findByQuiz(quiz);
    }
}
