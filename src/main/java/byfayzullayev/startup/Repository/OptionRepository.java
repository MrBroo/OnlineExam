package byfayzullayev.startup.Repository;

import byfayzullayev.startup.entity.OptionEntity;
import byfayzullayev.startup.entity.Question;
import byfayzullayev.startup.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface OptionRepository extends JpaRepository<OptionEntity, Long> {

    Set<OptionEntity> findByQuestion(Question question);
}
