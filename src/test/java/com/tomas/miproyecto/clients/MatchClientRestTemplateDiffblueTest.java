package com.tomas.miproyecto.clients;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNull;

@ContextConfiguration(classes = {MatchClientRestTemplate.class})
@ExtendWith(SpringExtension.class)
class MatchClientRestTemplateDiffblueTest {
    @Autowired
    private MatchClientRestTemplate matchClientRestTemplate;

    /**
     * Method under test: {@link MatchClientRestTemplate#getMatches()}
     */
    @Test
    void testGetMatches() {
        assertNull(matchClientRestTemplate.getMatches());
    }
}
