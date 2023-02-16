package br.com.resilia.smartclasses.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attendances")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Lesson lesson;
    private Boolean inLesson;

}
