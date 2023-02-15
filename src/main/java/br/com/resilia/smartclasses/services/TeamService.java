package br.com.resilia.smartclasses.services;

import br.com.resilia.smartclasses.domain.dto.NewTeamRequest;
import br.com.resilia.smartclasses.domain.dto.NewTeamResponse;
import br.com.resilia.smartclasses.domain.model.Course;
import br.com.resilia.smartclasses.domain.model.Team;
import br.com.resilia.smartclasses.repository.CourseRepository;
import br.com.resilia.smartclasses.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {

    private TeamRepository teamRepository;
    private CourseRepository courseRepository;

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public List<Team> getAllActive() {
        return teamRepository.findAll().stream()
                .filter(Team::isActive).toList();
    }

    public Team getTeamByName(String name) {
        // TODO exception handle when there is no team with this name
        return teamRepository.findByName(name).get();
    }

    public Team registerTeam(NewTeamRequest newTeamRequest) {
        // TODO register team
        var teamToRegister = toTeam(newTeamRequest);
        return teamRepository.save(teamToRegister);
    }

    private Course getCourse(String courseName) {
        var course = courseRepository.findByName(courseName);
        Course newCourse = toCourse(courseName);

        if(course.isEmpty()){
            newCourse = courseRepository.save(newCourse);
        }

        return course.orElse(newCourse);
    }

    private Team toTeam(NewTeamRequest newTeamRequest) {
        var courseOfTeam = getCourse(newTeamRequest.getCourseName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return Team.builder()
                .course(courseOfTeam)
                .name(newTeamRequest.getName())
                .startDate(LocalDateTime.parse(newTeamRequest.getStart(), formatter))
                .endDate(LocalDateTime.parse(newTeamRequest.getEnd(), formatter))
                .students(new ArrayList<>())
                .build();
    }

    private Course toCourse(String courseName) {
        return Course.builder()
                .name(courseName)
                .build();
    }

}
