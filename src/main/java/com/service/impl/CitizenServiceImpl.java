package com.service.impl;


import com.repository.CitizenRepository;
import com.service.CitizenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CitizenDTO.CitizenLogin;
import com.dto.CitizenDTO.CitizenRegister;
import com.entity.Citizen;
import com.mapper.CitizenMapper;

@Service
public class CitizenServiceImpl implements CitizenService {


    private CitizenMapper citizenMapper;
    private CitizenRepository citizenRepository;
    public CitizenServiceImpl(CitizenMapper citizenMapper, CitizenRepository citizenRepository) {
        this.citizenMapper = citizenMapper;
        this.citizenRepository = citizenRepository;
    }
    
    public Citizen register(CitizenRegister citizenRegister){
        Citizen citizen=citizenMapper.RegisterToEntity(citizenRegister);
        return citizenRepository.save(citizen);
    }

    @Override
    public String login(CitizenLogin citizenLogin) {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    

    
}
