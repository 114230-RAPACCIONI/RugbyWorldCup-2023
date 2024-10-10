package com.tomas.miproyecto.clients.dtos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {TeamClientDTO.class})
@ExtendWith(SpringExtension.class)
class TeamClientDTOTest {
    @Autowired
    private TeamClientDTO teamClientDTO;

    /**
     * Method under test: {@link TeamClientDTO#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(teamClientDTO.canEqual("Other"));
        assertTrue(teamClientDTO.canEqual(teamClientDTO));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamClientDTO#TeamClientDTO()}
     *   <li>{@link TeamClientDTO#setCountry(String)}
     *   <li>{@link TeamClientDTO#setId(long)}
     *   <li>{@link TeamClientDTO#setName(String)}
     *   <li>{@link TeamClientDTO#setPool(String)}
     *   <li>{@link TeamClientDTO#setWorldRanking(long)}
     *   <li>{@link TeamClientDTO#toString()}
     *   <li>{@link TeamClientDTO#getCountry()}
     *   <li>{@link TeamClientDTO#getId()}
     *   <li>{@link TeamClientDTO#getName()}
     *   <li>{@link TeamClientDTO#getPool()}
     *   <li>{@link TeamClientDTO#getWorldRanking()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TeamClientDTO actualTeamClientDTO = new TeamClientDTO();
        actualTeamClientDTO.setCountry("GB");
        actualTeamClientDTO.setId(1L);
        actualTeamClientDTO.setName("Name");
        actualTeamClientDTO.setPool("Pool");
        actualTeamClientDTO.setWorldRanking(1L);
        String actualToStringResult = actualTeamClientDTO.toString();
        String actualCountry = actualTeamClientDTO.getCountry();
        long actualId = actualTeamClientDTO.getId();
        String actualName = actualTeamClientDTO.getName();
        String actualPool = actualTeamClientDTO.getPool();
        assertEquals("GB", actualCountry);
        assertEquals("Name", actualName);
        assertEquals("Pool", actualPool);
        assertEquals("TeamClientDTO(id=1, name=Name, country=GB, worldRanking=1, pool=Pool)", actualToStringResult);
        assertEquals(1L, actualId);
        assertEquals(1L, actualTeamClientDTO.getWorldRanking());
    }

    /**
     * Method under test:
     * {@link TeamClientDTO#TeamClientDTO(long, String, String, long, String)}
     */
    @Test
    void testConstructor2() {
        TeamClientDTO actualTeamClientDTO = new TeamClientDTO(1L, "Name", "GB", 1L, "Pool");

        assertEquals("GB", actualTeamClientDTO.getCountry());
        assertEquals("Name", actualTeamClientDTO.getName());
        assertEquals("Pool", actualTeamClientDTO.getPool());
        assertEquals(1L, actualTeamClientDTO.getId());
        assertEquals(1L, actualTeamClientDTO.getWorldRanking());
    }

    /**
     * Method under test: {@link TeamClientDTO#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new TeamClientDTO(1L, "Name", "GB", 1L, "Pool"), null);
        assertNotEquals(new TeamClientDTO(1L, "Name", "GB", 1L, "Pool"), "Different type to TeamClientDTO");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamClientDTO#equals(Object)}
     *   <li>{@link TeamClientDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, "Name", "GB", 1L, "Pool");
        assertEquals(teamClientDTO, teamClientDTO);
        int expectedHashCodeResult = teamClientDTO.hashCode();
        assertEquals(expectedHashCodeResult, teamClientDTO.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamClientDTO#equals(Object)}
     *   <li>{@link TeamClientDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, "Name", "GB", 1L, "Pool");
        TeamClientDTO teamClientDTO2 = new TeamClientDTO(1L, "Name", "GB", 1L, "Pool");

        assertEquals(teamClientDTO, teamClientDTO2);
        int expectedHashCodeResult = teamClientDTO.hashCode();
        assertEquals(expectedHashCodeResult, teamClientDTO2.hashCode());
    }

    /**
     * Method under test: {@link TeamClientDTO#equals(Object)}
     */
    @Test
    void testEquals4() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(2L, "Name", "GB", 1L, "Pool");
        assertNotEquals(teamClientDTO, new TeamClientDTO(1L, "Name", "GB", 1L, "Pool"));
    }

    /**
     * Method under test: {@link TeamClientDTO#equals(Object)}
     */
    @Test
    void testEquals5() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, "GB", "GB", 1L, "Pool");
        assertNotEquals(teamClientDTO, new TeamClientDTO(1L, "Name", "GB", 1L, "Pool"));
    }

    /**
     * Method under test: {@link TeamClientDTO#equals(Object)}
     */
    @Test
    void testEquals6() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, null, "GB", 1L, "Pool");
        assertNotEquals(teamClientDTO, new TeamClientDTO(1L, "Name", "GB", 1L, "Pool"));
    }

    /**
     * Method under test: {@link TeamClientDTO#equals(Object)}
     */
    @Test
    void testEquals7() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, "Name", "GBR", 1L, "Pool");
        assertNotEquals(teamClientDTO, new TeamClientDTO(1L, "Name", "GB", 1L, "Pool"));
    }

    /**
     * Method under test: {@link TeamClientDTO#equals(Object)}
     */
    @Test
    void testEquals8() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, "Name", null, 1L, "Pool");
        assertNotEquals(teamClientDTO, new TeamClientDTO(1L, "Name", "GB", 1L, "Pool"));
    }

    /**
     * Method under test: {@link TeamClientDTO#equals(Object)}
     */
    @Test
    void testEquals9() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, "Name", "GB", 3L, "Pool");
        assertNotEquals(teamClientDTO, new TeamClientDTO(1L, "Name", "GB", 1L, "Pool"));
    }

    /**
     * Method under test: {@link TeamClientDTO#equals(Object)}
     */
    @Test
    void testEquals10() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, "Name", "GB", 1L, "Name");
        assertNotEquals(teamClientDTO, new TeamClientDTO(1L, "Name", "GB", 1L, "Pool"));
    }

    /**
     * Method under test: {@link TeamClientDTO#equals(Object)}
     */
    @Test
    void testEquals11() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, "Name", "GB", 1L, null);
        assertNotEquals(teamClientDTO, new TeamClientDTO(1L, "Name", "GB", 1L, "Pool"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamClientDTO#equals(Object)}
     *   <li>{@link TeamClientDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, null, "GB", 1L, "Pool");
        TeamClientDTO teamClientDTO2 = new TeamClientDTO(1L, null, "GB", 1L, "Pool");

        assertEquals(teamClientDTO, teamClientDTO2);
        int expectedHashCodeResult = teamClientDTO.hashCode();
        assertEquals(expectedHashCodeResult, teamClientDTO2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamClientDTO#equals(Object)}
     *   <li>{@link TeamClientDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, "Name", null, 1L, "Pool");
        TeamClientDTO teamClientDTO2 = new TeamClientDTO(1L, "Name", null, 1L, "Pool");

        assertEquals(teamClientDTO, teamClientDTO2);
        int expectedHashCodeResult = teamClientDTO.hashCode();
        assertEquals(expectedHashCodeResult, teamClientDTO2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TeamClientDTO#equals(Object)}
     *   <li>{@link TeamClientDTO#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14() {
        TeamClientDTO teamClientDTO = new TeamClientDTO(1L, "Name", "GB", 1L, null);
        TeamClientDTO teamClientDTO2 = new TeamClientDTO(1L, "Name", "GB", 1L, null);

        assertEquals(teamClientDTO, teamClientDTO2);
        int expectedHashCodeResult = teamClientDTO.hashCode();
        assertEquals(expectedHashCodeResult, teamClientDTO2.hashCode());
    }
}
