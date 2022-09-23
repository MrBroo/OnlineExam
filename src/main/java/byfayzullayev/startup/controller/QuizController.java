package byfayzullayev.startup.controller;

import byfayzullayev.startup.entity.Category;
import byfayzullayev.startup.entity.Quiz;
import byfayzullayev.startup.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.addQuiz(quiz));

    }

    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.updateQuiz(quiz));

    }

    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<?> getQuizList() {
        return ResponseEntity.ok(quizService.getQuizzes());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable("id") Long id) {
        return quizService.getQuiz(id);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void deleteQuiz(@PathVariable("id") Long id) {
        quizService.deleteQuiz(id);
    }

    @CrossOrigin
    @GetMapping("/category/{id}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("id") Long id){
        Category category = new Category();
        category.setId(id);
        return quizService.getQuizzesOfCategory(category);
    }

}
