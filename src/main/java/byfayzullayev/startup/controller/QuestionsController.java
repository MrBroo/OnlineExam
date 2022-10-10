package byfayzullayev.startup.controller;

import byfayzullayev.startup.entity.questions.QuestionEntity;
import byfayzullayev.startup.entity.questions.QuizEntity;
import byfayzullayev.startup.service.QuestionsService;
import byfayzullayev.startup.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/onlineExam/questions")
public class QuestionsController {

    private final QuestionsService questionsService;
    private final QuizService quizService;

    public QuestionsController(QuestionsService questionsService, QuizService quizService) {
        this.questionsService = questionsService;
        this.quizService = quizService;
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<QuestionEntity> addQuestion(@RequestBody QuestionEntity question) {
        return ResponseEntity.ok(questionsService.addQuestion(question));

    }

    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<QuestionEntity> updateQuestion(@RequestBody QuestionEntity question) {
        return ResponseEntity.ok(questionsService.updateQuestion(question));

    }

    @CrossOrigin
    @GetMapping("/quiz/{id}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("id") Long id) {
//        Quiz quiz = new Quiz();
//        quiz.setId(id);
//        Set<Question> questionsOfQuiz = questionsService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

        QuizEntity quiz = quizService.getQuiz(id);
        Set<QuestionEntity> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
            list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);

    }


    //get single question
    @CrossOrigin
    @GetMapping("/{id}")
    public QuestionEntity getQuestion(@PathVariable("id") Long id) {
        return questionsService.getQuestion(id);
    }


    //delete question

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable("id") Long id) {
        questionsService.deleteQuestion(id);
    }
}
