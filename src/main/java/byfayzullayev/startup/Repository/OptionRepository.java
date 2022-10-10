package byfayzullayev.startup.Repository;

import byfayzullayev.startup.entity.questions.OptionEntity;
import byfayzullayev.startup.entity.questions.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface OptionRepository extends JpaRepository<OptionEntity, Long> {

    Set<OptionEntity> findByQuestion(QuestionEntity question);
}
