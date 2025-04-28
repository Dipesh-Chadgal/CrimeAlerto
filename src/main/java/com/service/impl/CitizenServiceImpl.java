package com.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CitizenDTO.CitizenRegister;
import com.entity.Citizen;
import com.mapper.CitizenMapper;

@Service
public class CitizenServiceImpl {

    @Autowired
    private CitizenMapper citizenMapper;
    
    public Citizen register(CitizenRegister citizenRegister){
        Citizen citizen=citizenMapper.RegisterToEntity(citizenRegister);
        return repo.save(citizen);

    }
}
