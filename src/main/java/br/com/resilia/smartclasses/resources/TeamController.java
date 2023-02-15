package br.com.resilia.smartclasses.resources;

import br.com.resilia.smartclasses.domain.dto.NewTeamRequest;
import br.com.resilia.smartclasses.domain.dto.NewTeamResponse;
import br.com.resilia.smartclasses.domain.dto.TeamResponse;
import br.com.resilia.smartclasses.repository.TeamRepository;
import br.com.resilia.smartclasses.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamResponse>> getAllTeams(
            @RequestParam(name="active", defaultValue = "false") boolean active
    ) {
        var teams = active ? teamService.getAllActive() : teamService.getAll();
        var teamsReponse = teams.stream().map(TeamResponse::new).toList();
        return ResponseEntity.ok(teamsReponse);
    }

    @PostMapping ResponseEntity<NewTeamResponse> addNewTeam(@RequestBody NewTeamRequest newTeamRequest) {
        var teamRegisted = teamService.registerTeam(newTeamRequest);
        var teamResponse = new NewTeamResponse(teamRegisted);
        return ResponseEntity.ok(teamResponse);
    }

}
