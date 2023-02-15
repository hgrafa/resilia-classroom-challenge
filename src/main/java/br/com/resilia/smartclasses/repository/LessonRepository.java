package br.com.resilia.smartclasses.repository;

import br.com.resilia.smartclasses.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
