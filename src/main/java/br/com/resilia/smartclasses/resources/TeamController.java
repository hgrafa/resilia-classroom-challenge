package br.com.resilia.smartclasses.resources;

import br.com.resilia.smartclasses.domain.dto.NewTeamRequest;
import br.com.resilia.smartclasses.domain.dto.NewTeamResponse;
import br.com.resilia.smartclasses.domain.dto.TeamResponse;
import br.com.resilia.smartclasses.domain.dto.UpdateTeamRequest;
import br.com.resilia.smartclasses.domain.model.Team;
import br.com.resilia.smartclasses.services.TeamService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teams")
@RequiredArgsConstructor
public class TeamController {
    @NonNull private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamResponse>> getAllTeams(
            @RequestParam(name="active", defaultValue = "false") boolean active
    ) {
        var teams = active ? teamService.getAllActive() : teamService.getAll();
        var teamsReponse = teams.stream().map(TeamResponse::new).toList();
        return ResponseEntity.ok(teamsReponse);
    }

    @PostMapping
    public ResponseEntity<NewTeamResponse> addNewTeam(
            @RequestBody NewTeamRequest newTeamRequest
    ) {
        var teamRegisted = teamService.registerTeam(newTeamRequest);
        var teamResponse = new NewTeamResponse(teamRegisted);
        return ResponseEntity.ok(teamResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TeamResponse> updateTeam (
            @PathVariable long id,
            @RequestBody UpdateTeamRequest updateTeamRequest
    ) {

        try {
            var updatedTeam = teamService.updateTeambyId(id, updateTeamRequest);
            var teamResponse = new TeamResponse(updatedTeam);
            return ResponseEntity.ok(teamResponse);
        }  catch (Exception ignored) {
            // TODO catch exception updating team that not exist with 404
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeTeam(
            @PathVariable long id
    ) {
        var isNotDeleted = !teamService.deleteById(id);
        var successMessage = "team has been deleted";
        var failedMessage = "team could not be founded to be deleted";

        if(isNotDeleted)
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(failedMessage);

        return ResponseEntity.ok(successMessage);
    }

}
