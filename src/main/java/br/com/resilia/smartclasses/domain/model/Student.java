package br.com.resilia.smartclasses.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id
    private String cpf;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}
