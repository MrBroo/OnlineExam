package byfayzullayev.startup.Repository;

import byfayzullayev.startup.entity.questions.QuestionEntity;
import byfayzullayev.startup.entity.questions.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
    Set<QuestionEntity> findByQuiz(QuizEntity quiz);
}
