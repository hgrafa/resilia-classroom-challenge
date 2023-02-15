package br.com.resilia.smartclasses.domain.dto;

import br.com.resilia.smartclasses.domain.model.Team;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewTeamResponse {
    private Long id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

    public NewTeamResponse(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.start = team.getStartDate();
        this.end = team.getEndDate();
    }

}
