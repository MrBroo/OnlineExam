package byfayzullayev.startup.Repository;

import byfayzullayev.startup.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
