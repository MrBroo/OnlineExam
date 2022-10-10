package byfayzullayev.startup.controller;

import byfayzullayev.startup.entity.questions.OptionEntity;
import byfayzullayev.startup.service.OptionService;
import byfayzullayev.startup.service.QuestionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/onlineExam/option")
@CrossOrigin("*")
public class OptionController {

private final OptionService optionService;
private final QuestionsService questionsService;

    public OptionController(OptionService optionService, QuestionsService questionsService) {
        this.optionService = optionService;
        this.questionsService = questionsService;
    }

    @PostMapping("/add")
    public ResponseEntity<OptionEntity> addOption(@RequestBody OptionEntity optionEntity) {
        return ResponseEntity.ok(optionService.addOption(optionEntity));
    }
    @PutMapping("/update")
    public ResponseEntity<OptionEntity> updateOption(@RequestBody OptionEntity optionEntity) {
        return ResponseEntity.ok(optionService.updateOption(optionEntity));

    }

//    @GetMapping("/question/{id}")
//    public ResponseEntity<?> getOptionOfQuestion(@PathVariable("id") Long id) {
//
//        Question question  = questionsService.getQuestion(id);
//        Set<OptionEntity> optionEntities = question.getOptionEntities();
//        List list = new ArrayList(optionEntities);
//        if (list.size() > Integer.parseInt(question.getGetNumberOfOption())) {
//            list.subList(0, Integer.parseInt(question.getGetNumberOfOption() + 1));
//        }
//        Collections.shuffle(list);
//        return ResponseEntity.ok(list);
//
//    }

    @GetMapping("/{id}")
    public OptionEntity getOption(@PathVariable("id") Long id) {
        return optionService.getOption(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteOption(@PathVariable("id") Long id) {
        optionService.deleteOption(id);
    }

}
