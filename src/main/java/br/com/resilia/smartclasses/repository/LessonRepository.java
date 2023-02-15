package br.com.resilia.smartclasses.repository;

import br.com.resilia.smartclasses.domain.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
