package com.tomas.miproyecto.clients.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchClientDTO {

    private long id;
    private String date;
    @JsonProperty("teams")
    private List<TeamClientInnerMatchDTO> listTeamClientInnerMatchDTO;
    private long stadium;
    private String pool;
}
