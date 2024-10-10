package com.tomas.miproyecto.clients.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class TeamClientDTO {

    private long id;
    private String name;
    private String country;
    @JsonProperty("world_ranking")
    private long worldRanking;
    private String pool;




}
