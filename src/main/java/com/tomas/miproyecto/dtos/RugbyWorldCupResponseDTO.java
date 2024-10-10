package com.tomas.miproyecto.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"pool_id", "teams"})
public class RugbyWorldCupResponseDTO {

    @JsonProperty("pool_id")
    private String pool;

    private List<TeamDTO> teams;
}
