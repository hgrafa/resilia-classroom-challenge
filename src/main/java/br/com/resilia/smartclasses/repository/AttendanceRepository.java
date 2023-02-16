package br.com.resilia.smartclasses.repository;

import br.com.resilia.smartclasses.domain.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
