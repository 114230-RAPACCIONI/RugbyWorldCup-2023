package com.tomas.miproyecto.clients;

import com.tomas.miproyecto.clients.dtos.TeamListClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TeamClientRestTemplate {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<TeamListClientDTO> getTeams() {

        ResponseEntity<TeamListClientDTO> response = null;
        try {
            response = restTemplate.getForEntity("https://my-json-server.typicode.com/LCIV-2023/fake-api-rwc2023/db", TeamListClientDTO.class);

            if (response.getStatusCode().equals(200)) {
                return response;
            }
        } catch (Exception ex) {
            System.out.println("ERROR  " + ex.getMessage());
        }
        return response;
    }
}
