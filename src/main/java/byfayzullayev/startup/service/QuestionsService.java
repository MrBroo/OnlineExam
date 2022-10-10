package byfayzullayev.startup.service;


import byfayzullayev.startup.entity.questions.QuestionEntity;
import byfayzullayev.startup.entity.questions.QuizEntity;

import java.util.Set;

public interface QuestionsService {

    public QuestionEntity addQuestion(QuestionEntity question);

    public QuestionEntity updateQuestion(QuestionEntity question);

    public Set<QuestionEntity> getQuestions();

    public QuestionEntity getQuestion(Long id);

    public void deleteQuestion(Long id);

    public Set<QuestionEntity> getQuestionsOfQuiz(QuizEntity quiz);
}
