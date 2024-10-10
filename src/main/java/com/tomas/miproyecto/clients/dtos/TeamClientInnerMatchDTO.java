package com.tomas.miproyecto.clients.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamClientInnerMatchDTO {

    private long id;
    private long points;
    private long tries;
    @JsonProperty("yellow_cards")
    private long yellowCards;
    @JsonProperty("red_cards")
    private long redCards;


}
