package br.com.resilia.smartclasses.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private String name;
    private String cpf;
    private String email;
}
