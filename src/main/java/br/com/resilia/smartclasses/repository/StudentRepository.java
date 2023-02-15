package br.com.resilia.smartclasses.repository;

import br.com.resilia.smartclasses.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByNameStartingWith(String name);
    Optional<Student> findByEmail(String email);

}
