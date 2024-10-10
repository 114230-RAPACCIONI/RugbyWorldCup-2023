package com.tomas.miproyecto.clients.dtos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {TeamClientInnerMatchDTO.class})
@ExtendWith(SpringExtension.class)
class TeamClientInnerMatchDTOTest {
    @Autowired
    private TeamClientInnerMatchDTO teamClientInnerMatchDTO;

    /**
     * Method under test: {@link TeamClientInnerMatchDTO#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(teamClientInnerMatchDTO.canEqual("Other"));
        assertTrue(teamClientInnerMatchDTO.canEqual(teamClientInnerMatchDTO));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamClientInnerMatchDTO#TeamClientInnerMatchDTO()}
     *   <li>{@link TeamClientInnerMatchDTO#setId(long)}
     *   <li>{@link TeamClientInnerMatchDTO#setPoints(long)}
     *   <li>{@link TeamClientInnerMatchDTO#setRedCards(long)}
     *   <li>{@link TeamClientInnerMatchDTO#setTries(long)}
     *   <li>{@link TeamClientInnerMatchDTO#setYellowCards(long)}
     *   <li>{@link TeamClientInnerMatchDTO#toString()}
     *   <li>{@link TeamClientInnerMatchDTO#getId()}
     *   <li>{@link TeamClientInnerMatchDTO#getPoints()}
     *   <li>{@link TeamClientInnerMatchDTO#getRedCards()}
     *   <li>{@link TeamClientInnerMatchDTO#getTries()}
     *   <li>{@link TeamClientInnerMatchDTO#getYellowCards()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TeamClientInnerMatchDTO actualTeamClientInnerMatchDTO = new TeamClientInnerMatchDTO();
        actualTeamClientInnerMatchDTO.setId(1L);
        actualTeamClientInnerMatchDTO.setPoints(1L);
        actualTeamClientInnerMatchDTO.setRedCards(1L);
        actualTeamClientInnerMatchDTO.setTries(1L);
        actualTeamClientInnerMatchDTO.setYellowCards(1L);
        String actualToStringResult = actualTeamClientInnerMatchDTO.toString();
        long actualId = actualTeamClientInnerMatchDTO.getId();
        long actualPoints = actualTeamClientInnerMatchDTO.getPoints();
        long actualRedCards = actualTeamClientInnerMatchDTO.getRedCards();
        long actualTries = actualTeamClientInnerMatchDTO.getTries();
        assertEquals("TeamClientInnerMatchDTO(id=1, points=1, tries=1, yellowCards=1, redCards=1)", actualToStringResult);
        assertEquals(1L, actualId);
        assertEquals(1L, actualPoints);
        assertEquals(1L, actualRedCards);
        assertEquals(1L, actualTries);
        assertEquals(1L, actualTeamClientInnerMatchDTO.getYellowCards());
    }

    /**
     * Method under test:
     * {@link TeamClientInnerMatchDTO#TeamClientInnerMatchDTO(long, long, long, long, long)}
     */
    @Test
    void testConstructor2() {
        TeamClientInnerMatchDTO actualTeamClientInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L);

        assertEquals(1L, actualTeamClientInnerMatchDTO.getId());
        assertEquals(1L, actualTeamClientInnerMatchDTO.getPoints());
        assertEquals(1L, actualTeamClientInnerMatchDTO.getRedCards());
        assertEquals(1L, actualTeamClientInnerMatchDTO.getTries());
        assertEquals(1L, actualTeamClientInnerMatchDTO.getYellowCards());
    }

    /**
     * Method under test: {@link TeamClientInnerMatchDTO#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L), null);
        assertNotEquals(new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L), "Different type to TeamClientInnerMatchDTO");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamClientInnerMatchDTO#equals(Object)}
     *   <li>{@link TeamClientInnerMatchDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        TeamClientInnerMatchDTO teamClientInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L);
        assertEquals(teamClientInnerMatchDTO, teamClientInnerMatchDTO);
        int expectedHashCodeResult = teamClientInnerMatchDTO.hashCode();
        assertEquals(expectedHashCodeResult, teamClientInnerMatchDTO.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamClientInnerMatchDTO#equals(Object)}
     *   <li>{@link TeamClientInnerMatchDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TeamClientInnerMatchDTO teamClientInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L);
        TeamClientInnerMatchDTO teamClientInnerMatchDTO2 = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L);

        assertEquals(teamClientInnerMatchDTO, teamClientInnerMatchDTO2);
        int expectedHashCodeResult = teamClientInnerMatchDTO.hashCode();
        assertEquals(expectedHashCodeResult, teamClientInnerMatchDTO2.hashCode());
    }

    /**
     * Method under test: {@link TeamClientInnerMatchDTO#equals(Object)}
     */
    @Test
    void testEquals4() {
        TeamClientInnerMatchDTO teamClientInnerMatchDTO = new TeamClientInnerMatchDTO(2L, 1L, 1L, 1L, 1L);
        assertNotEquals(teamClientInnerMatchDTO, new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L));
    }

    /**
     * Method under test: {@link TeamClientInnerMatchDTO#equals(Object)}
     */
    @Test
    void testEquals5() {
        TeamClientInnerMatchDTO teamClientInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 3L, 1L, 1L, 1L);
        assertNotEquals(teamClientInnerMatchDTO, new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L));
    }

    /**
     * Method under test: {@link TeamClientInnerMatchDTO#equals(Object)}
     */
    @Test
    void testEquals6() {
        TeamClientInnerMatchDTO teamClientInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 3L, 1L, 1L);
        assertNotEquals(teamClientInnerMatchDTO, new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L));
    }

    /**
     * Method under test: {@link TeamClientInnerMatchDTO#equals(Object)}
     */
    @Test
    void testEquals7() {
        TeamClientInnerMatchDTO teamClientInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 3L, 1L);
        assertNotEquals(teamClientInnerMatchDTO, new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L));
    }

    /**
     * Method under test: {@link TeamClientInnerMatchDTO#equals(Object)}
     */
    @Test
    void testEquals8() {
        TeamClientInnerMatchDTO teamClientInnerMatchDTO = new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 3L);
        assertNotEquals(teamClientInnerMatchDTO, new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L));
    }
}
