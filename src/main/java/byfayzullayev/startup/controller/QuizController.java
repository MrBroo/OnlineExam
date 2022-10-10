package byfayzullayev.startup.controller;

import byfayzullayev.startup.entity.questions.CategoryEntity;
import byfayzullayev.startup.entity.questions.QuizEntity;
import byfayzullayev.startup.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/onlineExam/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<QuizEntity> addQuiz(@RequestBody QuizEntity quiz) {
        return ResponseEntity.ok(quizService.addQuiz(quiz));

    }

    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<QuizEntity> updateQuiz(@RequestBody QuizEntity quiz) {
        return ResponseEntity.ok(quizService.updateQuiz(quiz));

    }

    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<?> getQuizList() {
        return ResponseEntity.ok(quizService.getQuizzes());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public QuizEntity getQuiz(@PathVariable("id") Long id) {
        return quizService.getQuiz(id);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void deleteQuiz(@PathVariable("id") Long id) {
        quizService.deleteQuiz(id);
    }

    @CrossOrigin
    @GetMapping("/category/{id}")
    public List<QuizEntity> getQuizzesOfCategory(@PathVariable("id") Long id){
        CategoryEntity category = new CategoryEntity();
        category.setId(id);
        return quizService.getQuizzesOfCategory(category);
    }

}
