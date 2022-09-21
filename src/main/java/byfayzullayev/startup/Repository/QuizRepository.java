package byfayzullayev.startup.Repository;

import byfayzullayev.startup.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
