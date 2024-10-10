package com.tomas.miproyecto.services;

import com.tomas.miproyecto.dtos.RugbyWorldCupResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface RugbyWolrdCupServiceInterface {

    RugbyWorldCupResponseDTO getPool(String pool);
}
