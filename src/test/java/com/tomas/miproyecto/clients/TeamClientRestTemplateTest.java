package com.tomas.miproyecto.clients;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(classes = {TeamClientRestTemplate.class})
@ExtendWith(SpringExtension.class)
class TeamClientRestTemplateTest {
    @Autowired
    private TeamClientRestTemplate teamClientRestTemplate;

    /**
     * Method under test: {@link TeamClientRestTemplate#getTeams()}
     */
    @Test
    void testGetTeams() {
        assertNotNull(teamClientRestTemplate.getTeams());
    }
}
