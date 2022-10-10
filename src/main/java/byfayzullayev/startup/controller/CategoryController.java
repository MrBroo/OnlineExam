package byfayzullayev.startup.controller;

import byfayzullayev.startup.entity.questions.CategoryEntity;
import byfayzullayev.startup.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/onlineExam/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody CategoryEntity category){
        CategoryEntity category1 = categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    @GetMapping("/{id}")
    public CategoryEntity getCategory(@PathVariable("id") Long id){
        return categoryService.getCategory(id);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PutMapping("/update")
    public CategoryEntity updateCategory(@RequestBody CategoryEntity category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }

}
