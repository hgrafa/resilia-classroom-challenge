package br.com.resilia.smartclasses.repository;

import br.com.resilia.smartclasses.domain.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {


}
