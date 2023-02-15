package br.com.resilia.smartclasses.services;

import br.com.resilia.smartclasses.domain.dto.NewTeamRequest;
import br.com.resilia.smartclasses.domain.model.Course;
import br.com.resilia.smartclasses.repository.CourseRepository;
import br.com.resilia.smartclasses.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamService {

    private TeamRepository teamRepository;
    private CourseRepository courseRepository;
    public boolean registerTeam(NewTeamRequest newTeamRequest) {
        return true;
    }

    private Course getCourse(String courseName) {
        var course = courseRepository.findByName(courseName);
        Course newCourse = toCourse(courseName);

        if(course.isEmpty()){
            newCourse = courseRepository.save(newCourse);
        }

        return course.orElse(newCourse);
    }

    private Course toCourse(String courseName) {
        return Course.builder()
                .name(courseName)
                .build();
    }

}
