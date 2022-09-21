package byfayzullayev.startup.Repository;

import byfayzullayev.startup.entity.Question;
import byfayzullayev.startup.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
