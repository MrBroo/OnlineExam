package byfayzullayev.startup.Repository;

import byfayzullayev.startup.entity.questions.CategoryEntity;
import byfayzullayev.startup.entity.questions.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuizRepository extends JpaRepository<QuizEntity, Long> {

    public List<QuizEntity> findByCategory(CategoryEntity category);
}
