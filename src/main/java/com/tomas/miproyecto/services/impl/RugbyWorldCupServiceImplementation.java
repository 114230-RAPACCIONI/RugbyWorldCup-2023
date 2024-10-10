package com.tomas.miproyecto.services.impl;


import com.tomas.miproyecto.clients.MatchClientRestTemplate;
import com.tomas.miproyecto.clients.TeamClientRestTemplate;
import com.tomas.miproyecto.clients.dtos.MatchClientDTO;
import com.tomas.miproyecto.clients.dtos.TeamClientDTO;
import com.tomas.miproyecto.clients.dtos.TeamClientInnerMatchDTO;
import com.tomas.miproyecto.dtos.RugbyWorldCupResponseDTO;
import com.tomas.miproyecto.dtos.TeamDTO;
import com.tomas.miproyecto.services.RugbyWolrdCupServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RugbyWorldCupServiceImplementation implements RugbyWolrdCupServiceInterface {

    @Autowired
    TeamClientRestTemplate teamClientRestTemplate;

    @Autowired
    MatchClientRestTemplate matchClientRestTemplate;

    @Autowired
    ModelMapper modelMapper;

    public RugbyWorldCupResponseDTO getPool(String pool) {

        Map<Long, TeamDTO> teamDTOResponseMap = new HashMap<>();

        Map<Long, TeamClientInnerMatchDTO> teamInnerClientMatchMap = new HashMap<>();

        List<TeamClientDTO> teamClientDTOS = teamClientRestTemplate.getTeams().getBody().getTeams().stream().filter(x -> x.getPool().equals(pool)).toList();

        teamClientDTOS.forEach(x -> teamDTOResponseMap.put(x.getId(), modelMapper.map(x, TeamDTO.class)));

        List<MatchClientDTO> matchClientDTOList = Arrays.stream(matchClientRestTemplate.getMatches().getBody()).filter(x -> x.getPool().equals(pool)).toList();


        for (int i = 0; i < matchClientDTOList.size(); i++) {

            for (int j = 0; j < matchClientDTOList.get(i).getListTeamClientInnerMatchDTO().size(); j++) {

                TeamDTO teamDTO = teamDTOResponseMap.get(matchClientDTOList.get(i).getListTeamClientInnerMatchDTO().get(j).getId());

                if (teamDTO != null) {
                    teamDTO.setMatchesPlayed(teamDTO.getMatchesPlayed() + 1);
                    teamDTO.setTriesMade(teamDTO.getTriesMade() + matchClientDTOList.get(i).getListTeamClientInnerMatchDTO().get(j).getTries());
                    teamDTO.setTotalYellowCards(teamDTO.getTotalYellowCards() + matchClientDTOList.get(i).getListTeamClientInnerMatchDTO().get(j).getYellowCards());
                    teamDTO.setTotalRedCards(teamDTO.getTotalRedCards() + matchClientDTOList.get(i).getListTeamClientInnerMatchDTO().get(j).getRedCards());
                    getWinner(teamDTOResponseMap,matchClientDTOList.get(i).getListTeamClientInnerMatchDTO().get(0),matchClientDTOList.get(i).getListTeamClientInnerMatchDTO().get(1));
                    getBonusPoints(teamDTOResponseMap,matchClientDTOList.get(i).getListTeamClientInnerMatchDTO().get(0),matchClientDTOList.get(i).getListTeamClientInnerMatchDTO().get(1));
                    teamDTOResponseMap.replace(teamDTO.getId(), teamDTO);
                }
            }
        }
        matchClientDTOList.forEach(x -> x.getListTeamClientInnerMatchDTO().forEach(z -> teamInnerClientMatchMap.put(z.getId(), z)));

        return new RugbyWorldCupResponseDTO(pool, teamDTOResponseMap.values().stream().toList());
    }

    public void getWinner(Map<Long, TeamDTO> teamDTOMap, TeamClientInnerMatchDTO teamOneInnerMatchDTO, TeamClientInnerMatchDTO teamTwoInnerMatchDTO) {
        TeamDTO teamOne = teamDTOMap.get(teamOneInnerMatchDTO.getId());
        TeamDTO teamTwo = teamDTOMap.get(teamTwoInnerMatchDTO.getId());

        if( teamOne != null && teamTwo != null)
        {
            if (teamOne.getPoints() > teamTwo.getPoints()) {
                teamOne.setWins(teamOne.getWins() + 1);
                teamOne.setPoints(teamOne.getPoints() + 4);
                replaceOnMap(teamDTOMap,teamOne);
                teamTwo.setLosses(teamTwo.getLosses() + 1);
                replaceOnMap(teamDTOMap,teamTwo);

                if ((teamOne.getPoints() - teamTwo.getPoints()) <= 7) {

                    teamTwo.setBonusPoints(teamTwo.getBonusPoints() + 1);
                    replaceOnMap(teamDTOMap, teamTwo);
                }

            } else if (teamOne.getPoints() < teamTwo.getPoints()) {

                teamTwo.setWins(teamTwo.getWins() + 1);
                teamTwo.setPoints(teamTwo.getPoints() + 4);
                replaceOnMap(teamDTOMap,teamTwo);
                teamOne.setLosses(teamOne.getLosses() + 1);
                replaceOnMap(teamDTOMap,teamOne);

                if ((teamTwo.getPoints() - teamOne.getPoints()) <= 7) {

                    teamOne.setBonusPoints(teamOne.getBonusPoints() + 1);
                    replaceOnMap(teamDTOMap, teamTwo);
                }
            } else {
                teamOne.setDraws(teamOne.getDraws() + 1);
                teamOne.setPoints(teamOne.getPoints() + 2);
                replaceOnMap(teamDTOMap,teamOne);
                teamTwo.setDraws(teamTwo.getLosses() + 1);
                teamTwo.setPoints(teamTwo.getPoints() + 2);
                replaceOnMap(teamDTOMap,teamTwo);
            }
        }
    }

    public void replaceOnMap(Map<Long, TeamDTO> teamDTOMap, TeamDTO teamDTO) {
        TeamDTO teamDTO1 = teamDTOMap.get(teamDTO.getId());

        if (teamDTO1 != null) {
            teamDTOMap.replace(teamDTO.getId(), teamDTO);
        }
    }

    public void getBonusPoints(Map<Long, TeamDTO> teamDTOMap, TeamClientInnerMatchDTO teamOneInnerMatchDTO, TeamClientInnerMatchDTO teamTwoInnerMatchDTO){
        TeamDTO teamOne = teamDTOMap.get(teamOneInnerMatchDTO.getId());
        TeamDTO teamTwo = teamDTOMap.get(teamTwoInnerMatchDTO.getId());

        if( teamOne != null && teamTwo != null)
        {
            if (teamOneInnerMatchDTO.getTries() > 4) {
                teamOne.setBonusPoints(teamOne.getBonusPoints() + 1);
                replaceOnMap(teamDTOMap, teamOne);
            } else if (teamTwoInnerMatchDTO.getTries() > 4) {
                teamTwo.setBonusPoints(teamTwo.getBonusPoints() + 1);
                replaceOnMap(teamDTOMap, teamTwo);
            }
        }
    }
}

