package byfayzullayev.startup.Repository;

import byfayzullayev.startup.entity.Category;
import byfayzullayev.startup.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuizRepository extends JpaRepository<Quiz, Long> {

    public List<Quiz> findByCategory(Category category);
}
