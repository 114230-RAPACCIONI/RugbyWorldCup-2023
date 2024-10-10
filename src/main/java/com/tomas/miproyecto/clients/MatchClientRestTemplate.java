package com.tomas.miproyecto.clients;

import com.tomas.miproyecto.clients.dtos.MatchClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MatchClientRestTemplate {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<MatchClientDTO[]> getMatches() {

        ResponseEntity<MatchClientDTO[]> response = null;
        try {
            response = restTemplate.getForEntity("https://my-json-server.typicode.com/LCIV-2023/fake-api-rwc2023/matches", MatchClientDTO[].class);

            if (response.getStatusCode().equals(200)) {
                return response;
            }
        } catch (Exception ex) {
            System.out.println("ERROR " + ex.getMessage());
        }
        return response;
    }
}
