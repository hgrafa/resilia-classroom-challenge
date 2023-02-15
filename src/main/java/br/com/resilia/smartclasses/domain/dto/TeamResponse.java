package br.com.resilia.smartclasses.domain.dto;

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

    @Getter @Setter
    static class StudentOfTeamReponse {
        private String cpf;
        private String name;
        private String email;
    }
}

