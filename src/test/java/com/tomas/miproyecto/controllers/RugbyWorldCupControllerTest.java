package com.tomas.miproyecto.controllers;

import com.tomas.miproyecto.dtos.RugbyWorldCupResponseDTO;
import com.tomas.miproyecto.services.RugbyWolrdCupServiceInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {RugbyWorldCupController.class})
@ExtendWith(SpringExtension.class)
class RugbyWorldCupControllerTest {
    @MockBean
    private RugbyWolrdCupServiceInterface rugbyWolrdCupServiceInterface;

    @Autowired
    private RugbyWorldCupController rugbyWorldCupController;

    /**
     * Method under test: {@link RugbyWorldCupController#getDataByPool(String)}
     */
    @Test
    void testGetDataByPool() throws Exception {
        when(rugbyWolrdCupServiceInterface.getPool(Mockito.<String>any())).thenReturn(new RugbyWorldCupResponseDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rwc/2023/pools/{pool_id}", "Pool id");
        MockMvcBuilders.standaloneSetup(rugbyWorldCupController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"pool_id\":null,\"teams\":null}"));
    }
}
