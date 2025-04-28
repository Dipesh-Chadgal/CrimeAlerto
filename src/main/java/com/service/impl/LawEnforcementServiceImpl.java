package com.service.impl;


import com.mapper.CitizenMapper;
import com.mapper.LawEnforcementMapper;
import com.repository.CitizenRepository;
import com.repository.LawEnforcementRepository;
import org.springframework.stereotype.Service;

@Service
public class LawEnforcementServiceImpl {

    private final LawEnforcementMapper lawEnforcementMapper;
    private final LawEnforcementRepository lawEnforcementRepository;

    public LawEnforcementServiceImpl(LawEnforcementMapper lawEnforcementMapper, LawEnforcementRepository lawEnforcementRepository) {
        this.lawEnforcementMapper = lawEnforcementMapper;
        this.lawEnforcementRepository = lawEnforcementRepository;
    }

}
