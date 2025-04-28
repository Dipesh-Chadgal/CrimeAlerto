package com.service.impl;


import com.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CitizenDTO.CitizenRegister;
import com.entity.Citizen;
import com.mapper.CitizenMapper;

@Service
public class CitizenServiceImpl {


    private final CitizenMapper citizenMapper;
    private final CitizenRepository citizenRepository;

    public CitizenServiceImpl(CitizenMapper citizenMapper, CitizenRepository citizenRepository) {
        this.citizenMapper = citizenMapper;
        this.citizenRepository = citizenRepository;
    }
    
    public Citizen register(CitizenRegister citizenRegister){
        Citizen citizen=citizenMapper.RegisterToEntity(citizenRegister);
        return citizenRepository.save(citizen);

    }
}
