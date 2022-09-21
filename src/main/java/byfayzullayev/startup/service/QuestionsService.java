package byfayzullayev.startup.service;


import byfayzullayev.startup.entity.Question;
import byfayzullayev.startup.entity.Quiz;

import java.util.Set;

public interface QuestionsService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public void deleteQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);
}
