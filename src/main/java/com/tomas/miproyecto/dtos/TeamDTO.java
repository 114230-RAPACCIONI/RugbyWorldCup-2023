package com.tomas.miproyecto.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"team_id", "team_name", "country", "matches_played", "wins", "draws", "losses", "points_for", "points_against", "points_differential", "tries_made", "bonus points", "points", "total_yellow_cards", "total_red_cards"})
public class TeamDTO {
    @JsonProperty("team_id")
    private long id;
    @JsonProperty("team_name")
    private String name;
    private String country;
    @JsonProperty("matches_played")
    private long matchesPlayed;
    private long wins;
    private long draws;
    private long losses;
    @JsonProperty("points_for")
    private long pointsFor;
    @JsonProperty("points_against")
    private long pointsAgainst;
    @JsonProperty("points_differential")
    private long pointsDifferential;
    @JsonProperty("tries_made")
    private long triesMade;
    @JsonProperty("bonus points")
    private long bonusPoints;
    private long points;
    @JsonProperty("total_yellow_cards")
    private long totalYellowCards;
    @JsonProperty("total_red_cards")
    private long totalRedCards;
}
