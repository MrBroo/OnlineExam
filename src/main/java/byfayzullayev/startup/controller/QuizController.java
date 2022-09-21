package byfayzullayev.startup.controller;

import byfayzullayev.startup.entity.Quiz;
import byfayzullayev.startup.model.receive.AnswerReceiveModel;
import byfayzullayev.startup.model.response.ApiResponse;
import byfayzullayev.startup.service.QuizService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
//
//
//    @CrossOrigin
//    @PostMapping("/add")
//    public HttpEntity<?> addQuiz(@RequestBody Quiz quiz ) {
//        return ResponseEntity.ok(answerService.addAnswer(answerReceiveModel));
//
//    }
//
//    @CrossOrigin
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getAnswersList(@PathVariable("id") long id) {
//        ApiResponse list = answerService.getAnswerList(id);
//        return ResponseEntity.ok(list);
//    }

}
