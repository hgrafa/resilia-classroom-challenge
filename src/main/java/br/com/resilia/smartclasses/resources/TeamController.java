package br.com.resilia.smartclasses.resources;

import br.com.resilia.smartclasses.domain.dto.NewTeamResponse;
import br.com.resilia.smartclasses.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/teams")
@AllArgsConstructor
public class TeamController {

    private TeamService teamService;

    public ResponseEntity<NewTeamResponse>
}
