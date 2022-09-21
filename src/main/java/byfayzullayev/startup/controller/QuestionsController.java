package byfayzullayev.startup.controller;

import byfayzullayev.startup.entity.Question;
import byfayzullayev.startup.entity.Quiz;
import byfayzullayev.startup.model.receive.QuestionsReceiveModel;
import byfayzullayev.startup.service.QuestionsService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/questions")
public class QuestionsController {

    private final QuestionsService questionsService;

    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionsService.addQuestion(question));

    }
    @PutMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionsService.updateQuestion(question));

    }
    @CrossOrigin
    @GetMapping("/quiz/{id}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("id") Long id) {
        Quiz quiz = new Quiz();
        quiz.setId(id);
        Set<Question> questionsOfQuiz = questionsService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionsOfQuiz);
    }

}
