package br.com.resilia.smartclasses.domain.dto;

import lombok.*;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class UpdateTeamRequest {

    private String name = null;
    private String courseName = null;
    private String start = null;
    private String end = null;

}
