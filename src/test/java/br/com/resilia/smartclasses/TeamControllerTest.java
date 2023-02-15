package br.com.resilia.smartclasses;

import br.com.resilia.smartclasses.domain.dto.NewTeamRequest;
import br.com.resilia.smartclasses.domain.dto.NewTeamResponse;
import br.com.resilia.smartclasses.domain.model.Course;
import br.com.resilia.smartclasses.domain.model.Team;
import br.com.resilia.smartclasses.resources.TeamController;
import br.com.resilia.smartclasses.services.TeamService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeamController.class)
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TeamService teamService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testPostNewTeamShouldReturnOkAndCreateNewTeam() throws Exception {
        String name = "javascript runners";
        String courseName = "javascript";
        String startDate = "2022-02-14 10:00";
        String endDate = "2023-04-15 17:00";
        Long id = 1L;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        NewTeamRequest newTeamRequest = NewTeamRequest
                .builder().id(id).courseName(courseName)
                .start(startDate).end(endDate).build();

        String teamRequestAsJson = objectMapper.writeValueAsString(newTeamRequest);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/teams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(teamRequestAsJson);

        Team team = Team.builder()
                .id(1L)
                .name(name)
                .students(new ArrayList<>())
                .startDate(LocalDateTime.parse(startDate, formatter))
                .endDate(LocalDateTime.parse(endDate, formatter))
                .course(
                        Course.builder().id(id)
                                .name(courseName).build())
                .build();

        NewTeamResponse teamResponse = new NewTeamResponse(team);
        String teamResponseAsJson = objectMapper.writeValueAsString(teamResponse);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(teamResponseAsJson))
                .andReturn();


        String endpointReponse = result.getResponse().getContentAsString();
        assertEquals(endpointReponse, teamResponseAsJson);
    }

}
