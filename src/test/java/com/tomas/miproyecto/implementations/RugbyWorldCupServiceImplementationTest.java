package com.tomas.miproyecto.implementations;


import com.tomas.miproyecto.clients.MatchClientRestTemplate;
import com.tomas.miproyecto.clients.TeamClientRestTemplate;
import com.tomas.miproyecto.clients.dtos.TeamClientInnerMatchDTO;
import com.tomas.miproyecto.dtos.TeamDTO;
import com.tomas.miproyecto.services.impl.RugbyWorldCupServiceImplementation;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {RugbyWorldCupServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class RugbyWorldCupServiceImplementationTest {
    @MockBean
    private MatchClientRestTemplate matchClientRestTemplate;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private RugbyWorldCupServiceImplementation rugbyWorldCupServiceImplementation;

    @MockBean
    private TeamClientRestTemplate teamClientRestTemplate;

    /**
     * Method under test: {@link RugbyWorldCupServiceImplementation#getPool(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPool() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.http.ResponseEntity.getBody()" because the return value of "ar.edu.utn.frc.tup.lciii.clients.TeamClientRestTemplate.getTeams()" is null
        //       at ar.edu.utn.frc.tup.lciii.services.implementations.RugbyWorldCupServiceImplementation.getPool(RugbyWorldCupServiceImplementation.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        when(teamClientRestTemplate.getTeams()).thenReturn(null);
        rugbyWorldCupServiceImplementation.getPool("Pool");
    }

    /**
     * Method under test:
     * {@link RugbyWorldCupServiceImplementation#getWinner(Map, TeamClientInnerMatchDTO, TeamClientInnerMatchDTO)}
     */
    @Test
    void testGetWinner() {
        HashMap<Long, TeamDTO> teamDTOMap = new HashMap<>();
        TeamClientInnerMatchDTO teamOneInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L);

        TeamClientInnerMatchDTO teamTwoInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L);

        rugbyWorldCupServiceImplementation.getWinner(teamDTOMap, teamOneInnerMatchDTO, teamTwoInnerMatchDTO);
        assertEquals(1L, teamOneInnerMatchDTO.getId());
        assertEquals(1L, teamTwoInnerMatchDTO.getId());
        assertEquals(1L, teamOneInnerMatchDTO.getPoints());
        assertEquals(1L, teamTwoInnerMatchDTO.getPoints());
        assertEquals(1L, teamOneInnerMatchDTO.getRedCards());
        assertEquals(1L, teamTwoInnerMatchDTO.getRedCards());
        assertEquals(1L, teamOneInnerMatchDTO.getTries());
        assertEquals(1L, teamTwoInnerMatchDTO.getTries());
        assertEquals(1L, teamOneInnerMatchDTO.getYellowCards());
        assertEquals(1L, teamTwoInnerMatchDTO.getYellowCards());
    }

    /**
     * Method under test:
     * {@link RugbyWorldCupServiceImplementation#getWinner(Map, TeamClientInnerMatchDTO, TeamClientInnerMatchDTO)}
     */
    @Test
    void testGetWinner2() {
        HashMap<Long, TeamDTO> teamDTOMap = new HashMap<>();
        teamDTOMap.put(1L, new TeamDTO(1L, "Name", "GB", 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L));
        TeamClientInnerMatchDTO teamOneInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L);

        rugbyWorldCupServiceImplementation.getWinner(teamDTOMap, teamOneInnerMatchDTO,
                new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L));
        assertEquals(1, teamDTOMap.size());
    }

    /**
     * Method under test:
     * {@link RugbyWorldCupServiceImplementation#replaceOnMap(Map, TeamDTO)}
     */
    @Test
    void testReplaceOnMap() {
        HashMap<Long, TeamDTO> teamDTOMap = new HashMap<>();
        TeamDTO teamDTO = new TeamDTO(1L, "Name", "GB", 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);

        rugbyWorldCupServiceImplementation.replaceOnMap(teamDTOMap, teamDTO);
        assertEquals("GB", teamDTO.getCountry());
        assertEquals("Name", teamDTO.getName());
        assertEquals(1L, teamDTO.getBonusPoints());
        assertEquals(1L, teamDTO.getDraws());
        assertEquals(1L, teamDTO.getId());
        assertEquals(1L, teamDTO.getLosses());
        assertEquals(1L, teamDTO.getMatchesPlayed());
        assertEquals(1L, teamDTO.getPoints());
        assertEquals(1L, teamDTO.getPointsAgainst());
        assertEquals(1L, teamDTO.getPointsDifferential());
        assertEquals(1L, teamDTO.getPointsFor());
        assertEquals(1L, teamDTO.getTotalRedCards());
        assertEquals(1L, teamDTO.getTotalYellowCards());
        assertEquals(1L, teamDTO.getTriesMade());
        assertEquals(1L, teamDTO.getWins());
    }

    /**
     * Method under test:
     * {@link RugbyWorldCupServiceImplementation#replaceOnMap(Map, TeamDTO)}
     */
    @Test
    void testReplaceOnMap2() {
        HashMap<Long, TeamDTO> teamDTOMap = new HashMap<>();
        teamDTOMap.put(1L, new TeamDTO(1L, "Name", "GB", 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L));
        rugbyWorldCupServiceImplementation.replaceOnMap(teamDTOMap,
                new TeamDTO(1L, "Name", "GB", 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L));
        assertEquals(1, teamDTOMap.size());
    }

    /**
     * Method under test:
     * {@link RugbyWorldCupServiceImplementation#getBonusPoints(Map, TeamClientInnerMatchDTO, TeamClientInnerMatchDTO)}
     */
    @Test
    void testGetBonusPoints() {
        HashMap<Long, TeamDTO> teamDTOMap = new HashMap<>();
        TeamClientInnerMatchDTO teamOneInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L);

        TeamClientInnerMatchDTO teamTwoInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L);

        rugbyWorldCupServiceImplementation.getBonusPoints(teamDTOMap, teamOneInnerMatchDTO, teamTwoInnerMatchDTO);
        assertEquals(1L, teamOneInnerMatchDTO.getId());
        assertEquals(1L, teamTwoInnerMatchDTO.getId());
        assertEquals(1L, teamOneInnerMatchDTO.getPoints());
        assertEquals(1L, teamTwoInnerMatchDTO.getPoints());
        assertEquals(1L, teamOneInnerMatchDTO.getRedCards());
        assertEquals(1L, teamTwoInnerMatchDTO.getRedCards());
        assertEquals(1L, teamOneInnerMatchDTO.getTries());
        assertEquals(1L, teamTwoInnerMatchDTO.getTries());
        assertEquals(1L, teamOneInnerMatchDTO.getYellowCards());
        assertEquals(1L, teamTwoInnerMatchDTO.getYellowCards());
    }

    /**
     * Method under test:
     * {@link RugbyWorldCupServiceImplementation#getBonusPoints(Map, TeamClientInnerMatchDTO, TeamClientInnerMatchDTO)}
     */
    @Test
    void testGetBonusPoints2() {
        HashMap<Long, TeamDTO> teamDTOMap = new HashMap<>();
        teamDTOMap.put(1L, new TeamDTO(1L, "Name", "GB", 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L));
        TeamClientInnerMatchDTO teamOneInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L);

        TeamClientInnerMatchDTO teamTwoInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L);

        rugbyWorldCupServiceImplementation.getBonusPoints(teamDTOMap, teamOneInnerMatchDTO, teamTwoInnerMatchDTO);
        assertEquals(1L, teamOneInnerMatchDTO.getId());
        assertEquals(1L, teamTwoInnerMatchDTO.getId());
        assertEquals(1L, teamOneInnerMatchDTO.getPoints());
        assertEquals(1L, teamTwoInnerMatchDTO.getPoints());
        assertEquals(1L, teamOneInnerMatchDTO.getRedCards());
        assertEquals(1L, teamTwoInnerMatchDTO.getRedCards());
        assertEquals(1L, teamOneInnerMatchDTO.getTries());
        assertEquals(1L, teamTwoInnerMatchDTO.getTries());
        assertEquals(1L, teamOneInnerMatchDTO.getYellowCards());
        assertEquals(1L, teamTwoInnerMatchDTO.getYellowCards());
    }
}
