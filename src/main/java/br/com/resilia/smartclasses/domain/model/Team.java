package br.com.resilia.smartclasses.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_id")
    private Course course;

    public boolean isActive() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(start) && now.isBefore(end);
    }

}
