package byfayzullayev.startup.Repository;

import byfayzullayev.startup.entity.questions.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
