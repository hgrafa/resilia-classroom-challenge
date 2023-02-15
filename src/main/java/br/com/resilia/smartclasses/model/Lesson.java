package br.com.resilia.smartclasses.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "lessons")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDateTime moment;
    private String meetingLink;

    @ElementCollection
    private Set<String> topics = new LinkedHashSet<>();

    public LocalDate getDay() {
        return moment.toLocalDate();
    }

    public LocalTime getTime() {
        return moment.toLocalTime();
    }

    public void addTopic(String topic) {
        topics.add(topic);
    }

    public void removeTopic(String topic) {
        topics.remove(topic);
    }

}
