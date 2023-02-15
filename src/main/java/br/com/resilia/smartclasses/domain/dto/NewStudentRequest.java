package br.com.resilia.smartclasses.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewStudentRequest {
    private String cpf;
    private String name;
    private String email;
}
