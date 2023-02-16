package br.com.resilia.smartclasses.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @OneToMany(mappedBy = "student")
    private List<Attendance> attendances;

}
