package br.com.resilia.smartclasses.domain.dto;

import br.com.resilia.smartclasses.domain.model.Student;
import br.com.resilia.smartclasses.domain.model.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TeamResponse {

    private Long id;
    private String name;
    private String courseName;
    private boolean isActive;
    private List<StudentOfTeamReponse> students;

    public TeamResponse(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.courseName = team.getName();
        this.isActive = team.isActive();
        this.students = team
                .getStudents()
                .stream()
                .map(StudentOfTeamReponse::new)
                .toList();
    }

    @Getter @Setter
    static class StudentOfTeamReponse {
        private String cpf;
        private String name;
        private String email;

        public StudentOfTeamReponse(Student student) {
            this.name = student.getName();
            this.cpf = student.getCpf();
            this.email = student.getEmail();
        }
    }
}

