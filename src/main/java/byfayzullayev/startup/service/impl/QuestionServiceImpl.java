package byfayzullayev.startup.service.impl;

import byfayzullayev.startup.Repository.QuestionRepository;
import byfayzullayev.startup.entity.questions.QuestionEntity;
import byfayzullayev.startup.entity.questions.QuizEntity;
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
    public QuestionEntity addQuestion(QuestionEntity question) {
        return questionsRepository.save(question);
    }

    @Override
    public QuestionEntity updateQuestion(QuestionEntity question) {
        return questionsRepository.save(question);
    }

    @Override
    public Set<QuestionEntity> getQuestions() {
        return new LinkedHashSet<>(questionsRepository.findAll());
    }

    @Override
    public QuestionEntity getQuestion(Long id) {
        return questionsRepository.findById(id).get();
    }

    @Override
    public void deleteQuestion(Long id) {
        QuestionEntity question = new QuestionEntity();
        question.setId(id);
        questionsRepository.delete(question);

    }

    @Override
    public Set<QuestionEntity> getQuestionsOfQuiz(QuizEntity quiz) {
        return questionsRepository.findByQuiz(quiz);
    }
}
