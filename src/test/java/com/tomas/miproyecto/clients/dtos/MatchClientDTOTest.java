package com.tomas.miproyecto.clients.dtos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = {MatchClientDTO.class})
@ExtendWith(SpringExtension.class)
class MatchClientDTOTest {
  @Autowired
  private MatchClientDTO matchClientDTO;

  /**
   * Method under test: {@link MatchClientDTO#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    assertFalse(matchClientDTO.canEqual("Other"));
    assertTrue(matchClientDTO.canEqual(matchClientDTO));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link MatchClientDTO#MatchClientDTO()}
   *   <li>{@link MatchClientDTO#setDate(String)}
   *   <li>{@link MatchClientDTO#setId(long)}
   *   <li>{@link MatchClientDTO#setListTeamClientInnerMatchDTO(List)}
   *   <li>{@link MatchClientDTO#setPool(String)}
   *   <li>{@link MatchClientDTO#setStadium(long)}
   *   <li>{@link MatchClientDTO#toString()}
   *   <li>{@link MatchClientDTO#getDate()}
   *   <li>{@link MatchClientDTO#getId()}
   *   <li>{@link MatchClientDTO#getListTeamClientInnerMatchDTO()}
   *   <li>{@link MatchClientDTO#getPool()}
   *   <li>{@link MatchClientDTO#getStadium()}
   * </ul>
   */
  @Test
  void testConstructor() {
    MatchClientDTO actualMatchClientDTO = new MatchClientDTO();
    actualMatchClientDTO.setDate("2020-03-01");
    actualMatchClientDTO.setId(1L);
    ArrayList<TeamClientInnerMatchDTO> listTeamClientInnerMatchDTO = new ArrayList<>();
    actualMatchClientDTO.setListTeamClientInnerMatchDTO(listTeamClientInnerMatchDTO);
    actualMatchClientDTO.setPool("Pool");
    actualMatchClientDTO.setStadium(1L);
    String actualToStringResult = actualMatchClientDTO.toString();
    String actualDate = actualMatchClientDTO.getDate();
    long actualId = actualMatchClientDTO.getId();
    List<TeamClientInnerMatchDTO> actualListTeamClientInnerMatchDTO = actualMatchClientDTO
            .getListTeamClientInnerMatchDTO();
    String actualPool = actualMatchClientDTO.getPool();
    assertEquals("2020-03-01", actualDate);
    assertEquals("MatchClientDTO(id=1, date=2020-03-01, listTeamClientInnerMatchDTO=[], stadium=1, pool=Pool)",
            actualToStringResult);
    assertEquals("Pool", actualPool);
    assertEquals(1L, actualId);
    assertEquals(1L, actualMatchClientDTO.getStadium());
    assertSame(listTeamClientInnerMatchDTO, actualListTeamClientInnerMatchDTO);
  }

  /**
   * Method under test:
   * {@link MatchClientDTO#MatchClientDTO(long, String, List, long, String)}
   */
  @Test
  void testConstructor2() {
    MatchClientDTO actualMatchClientDTO = new MatchClientDTO(1L, "2020-03-01", new ArrayList<>(), 1L, "Pool");

    assertEquals("2020-03-01", actualMatchClientDTO.getDate());
    assertEquals("Pool", actualMatchClientDTO.getPool());
    assertEquals(1L, actualMatchClientDTO.getId());
    assertEquals(1L, actualMatchClientDTO.getStadium());
    assertTrue(actualMatchClientDTO.getListTeamClientInnerMatchDTO().isEmpty());
  }

  /**
   * Method under test:
   * {@link MatchClientDTO#MatchClientDTO(long, String, List, long, String)}
   */
  @Test
  void testConstructor3() {
    ArrayList<TeamClientInnerMatchDTO> listTeamClientInnerMatchDTO = new ArrayList<>();
    listTeamClientInnerMatchDTO.add(new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L));
    MatchClientDTO actualMatchClientDTO = new MatchClientDTO(1L, "2020-03-01", listTeamClientInnerMatchDTO, 1L, "Pool");

    assertEquals("2020-03-01", actualMatchClientDTO.getDate());
    assertEquals("Pool", actualMatchClientDTO.getPool());
    assertEquals(1, actualMatchClientDTO.getListTeamClientInnerMatchDTO().size());
    assertEquals(1L, actualMatchClientDTO.getId());
    assertEquals(1L, actualMatchClientDTO.getStadium());
  }

  /**
   * Method under test:
   * {@link MatchClientDTO#MatchClientDTO(long, String, List, long, String)}
   */
  @Test
  void testConstructor4() {
    ArrayList<TeamClientInnerMatchDTO> listTeamClientInnerMatchDTO = new ArrayList<>();
    listTeamClientInnerMatchDTO.add(new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L));
    listTeamClientInnerMatchDTO.add(new TeamClientInnerMatchDTO(1L, 1L, 1L, 1L, 1L));
    MatchClientDTO actualMatchClientDTO = new MatchClientDTO(1L, "2020-03-01", listTeamClientInnerMatchDTO, 1L, "Pool");

    assertEquals("2020-03-01", actualMatchClientDTO.getDate());
    assertEquals("Pool", actualMatchClientDTO.getPool());
    assertEquals(1L, actualMatchClientDTO.getId());
    assertEquals(1L, actualMatchClientDTO.getStadium());
    assertEquals(2, actualMatchClientDTO.getListTeamClientInnerMatchDTO().size());
  }

  /**
   * Method under test:
   * {@link MatchClientDTO#MatchClientDTO(long, String, List, long, String)}
   */
  @Test
  void testConstructor5() {
    ArrayList<TeamClientInnerMatchDTO> listTeamClientInnerMatchDTO = new ArrayList<>();
    listTeamClientInnerMatchDTO.add(mock(TeamClientInnerMatchDTO.class));
    MatchClientDTO actualMatchClientDTO = new MatchClientDTO(1L, "2020-03-01", listTeamClientInnerMatchDTO, 1L, "Pool");

    assertEquals("2020-03-01", actualMatchClientDTO.getDate());
    assertEquals("Pool", actualMatchClientDTO.getPool());
    assertEquals(1, actualMatchClientDTO.getListTeamClientInnerMatchDTO().size());
    assertEquals(1L, actualMatchClientDTO.getId());
    assertEquals(1L, actualMatchClientDTO.getStadium());
  }

  /**
   * Method under test: {@link MatchClientDTO#equals(Object)}
   */
  @Test
  void testEquals() {
    assertNotEquals(new MatchClientDTO(), null);
    assertNotEquals(new MatchClientDTO(), "Different type to MatchClientDTO");
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link MatchClientDTO#equals(Object)}
   *   <li>{@link MatchClientDTO#hashCode()}
   * </ul>
   */
  @Test
  void testEquals2() {
    MatchClientDTO matchClientDTO = new MatchClientDTO();
    assertEquals(matchClientDTO, matchClientDTO);
    int expectedHashCodeResult = matchClientDTO.hashCode();
    assertEquals(expectedHashCodeResult, matchClientDTO.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link MatchClientDTO#equals(Object)}
   *   <li>{@link MatchClientDTO#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    MatchClientDTO matchClientDTO = new MatchClientDTO();
    MatchClientDTO matchClientDTO2 = new MatchClientDTO();
    assertEquals(matchClientDTO, matchClientDTO2);
    int expectedHashCodeResult = matchClientDTO.hashCode();
    assertEquals(expectedHashCodeResult, matchClientDTO2.hashCode());
  }

  /**
   * Method under test: {@link MatchClientDTO#equals(Object)}
   */
  @Test
  void testEquals4() {
    MatchClientDTO matchClientDTO = new MatchClientDTO(1L, "2020-03-01", new ArrayList<>(), 1L, "Pool");
    assertNotEquals(matchClientDTO, new MatchClientDTO());
  }

  /**
   * Method under test: {@link MatchClientDTO#equals(Object)}
   */
  @Test
  void testEquals5() {
    MatchClientDTO matchClientDTO = new MatchClientDTO();
    matchClientDTO.setDate("2020-03-01");
    assertNotEquals(matchClientDTO, new MatchClientDTO());
  }

  /**
   * Method under test: {@link MatchClientDTO#equals(Object)}
   */
  @Test
  void testEquals6() {
    MatchClientDTO matchClientDTO = new MatchClientDTO();
    matchClientDTO.setListTeamClientInnerMatchDTO(new ArrayList<>());
    assertNotEquals(matchClientDTO, new MatchClientDTO());
  }

  /**
   * Method under test: {@link MatchClientDTO#equals(Object)}
   */
  @Test
  void testEquals7() {
    MatchClientDTO matchClientDTO = new MatchClientDTO();
    matchClientDTO.setStadium(1L);
    assertNotEquals(matchClientDTO, new MatchClientDTO());
  }

  /**
   * Method under test: {@link MatchClientDTO#equals(Object)}
   */
  @Test
  void testEquals8() {
    MatchClientDTO matchClientDTO = new MatchClientDTO();
    matchClientDTO.setPool("Pool");
    assertNotEquals(matchClientDTO, new MatchClientDTO());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link MatchClientDTO#equals(Object)}
   *   <li>{@link MatchClientDTO#hashCode()}
   * </ul>
   */
  @Test
  void testEquals9() {
    MatchClientDTO matchClientDTO = new MatchClientDTO(1L, "2020-03-01", new ArrayList<>(), 1L, "Pool");
    MatchClientDTO matchClientDTO2 = new MatchClientDTO(1L, "2020-03-01", new ArrayList<>(), 1L, "Pool");

    assertEquals(matchClientDTO, matchClientDTO2);
    int expectedHashCodeResult = matchClientDTO.hashCode();
    assertEquals(expectedHashCodeResult, matchClientDTO2.hashCode());
  }

  /**
   * Method under test: {@link MatchClientDTO#equals(Object)}
   */
  @Test
  void testEquals10() {
    MatchClientDTO matchClientDTO = new MatchClientDTO();

    MatchClientDTO matchClientDTO2 = new MatchClientDTO();
    matchClientDTO2.setDate("2020-03-01");
    assertNotEquals(matchClientDTO, matchClientDTO2);
  }

  /**
   * Method under test: {@link MatchClientDTO#equals(Object)}
   */
  @Test
  void testEquals11() {
    MatchClientDTO matchClientDTO = new MatchClientDTO();

    MatchClientDTO matchClientDTO2 = new MatchClientDTO();
    matchClientDTO2.setListTeamClientInnerMatchDTO(new ArrayList<>());
    assertNotEquals(matchClientDTO, matchClientDTO2);
  }

  /**
   * Method under test: {@link MatchClientDTO#equals(Object)}
   */
  @Test
  void testEquals12() {
    MatchClientDTO matchClientDTO = new MatchClientDTO();

    MatchClientDTO matchClientDTO2 = new MatchClientDTO();
    matchClientDTO2.setPool("Pool");
    assertNotEquals(matchClientDTO, matchClientDTO2);
  }
}
