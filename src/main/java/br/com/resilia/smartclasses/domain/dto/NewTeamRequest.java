package br.com.resilia.smartclasses.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class NewTeamRequest {

    private Long id;
    private String name;
    private String courseName;
    private String start;
    private String end;

}
