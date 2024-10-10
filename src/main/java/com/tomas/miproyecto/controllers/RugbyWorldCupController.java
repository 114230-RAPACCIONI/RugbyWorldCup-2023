package com.tomas.miproyecto.controllers;

import com.tomas.miproyecto.dtos.RugbyWorldCupResponseDTO;
import com.tomas.miproyecto.services.RugbyWolrdCupServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RugbyWorldCupController {

    @Autowired
    RugbyWolrdCupServiceInterface rugbyWolrdCupServiceInterface;

    @GetMapping("/rwc/2023/pools/{pool_id}")
    public ResponseEntity<RugbyWorldCupResponseDTO> getDataByPool(@PathVariable String pool_id) {
        return ResponseEntity.ok(rugbyWolrdCupServiceInterface.getPool(pool_id));
    }

}
