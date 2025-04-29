package com.service.impl;


import com.Tokens.CommonJwtUtil;
import com.dto.CitizenDTO.CitizenLogin;
import com.dto.CitizenDTO.CitizenRegister;
import com.dto.LawEnforcementDTO.LawEnforcementLogin;
import com.dto.LawEnforcementDTO.LawEnforcementRegister;
import com.entity.Citizen;
import com.entity.LawEnforcement;
import com.exceptions.NoSuchUserFoundException;
import com.mapper.CitizenMapper;
import com.mapper.LawEnforcementMapper;
import com.repository.CitizenRepository;
import com.repository.LawEnforcementRepository;
import com.service.LawEnforcementService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class LawEnforcementServiceImpl implements LawEnforcementService {

    private final LawEnforcementMapper lawEnforcementMapper;
    private final LawEnforcementRepository lawEnforcementRepository;
    private final PasswordEncoder passwordEncoder;
    private final CommonJwtUtil jwtUtil;

    public LawEnforcementServiceImpl(LawEnforcementMapper lawEnforcementMapper, LawEnforcementRepository lawEnforcementRepository, @Lazy PasswordEncoder passwordEncoder, CommonJwtUtil jwtUtil) {
        this.lawEnforcementMapper = lawEnforcementMapper;
        this.lawEnforcementRepository = lawEnforcementRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil=jwtUtil;
    }

    @Override
    public LawEnforcement register(LawEnforcementRegister lawEnforcementRegister){
        Optional<LawEnforcement> lawEnforcementOptional = lawEnforcementRepository.findByEmail(lawEnforcementRegister.getPoliceStationEmail());
        if(lawEnforcementOptional.isPresent()){
            throw new RuntimeException("Citizen already exists with this email");
        }
        LawEnforcement lawEnforcement = lawEnforcementMapper.RegisterToEntity(lawEnforcementRegister);
        return lawEnforcementRepository.save(lawEnforcement);
    }

    @Override
    public String login(LawEnforcementLogin lawEnforcementLogin) {
        LawEnforcement lawEnforcement=lawEnforcementRepository.findByEmail(lawEnforcementLogin.getEmail()).orElseThrow(() -> new NoSuchUserFoundException("No User found"));
        if(!passwordEncoder.matches(lawEnforcementLogin.getPassword(), lawEnforcement.getPassword())){
            throw new RuntimeException("Invalid email or password");
        }
        return jwtUtil.generateToken(lawEnforcement.getPoliceStationEmail());
    }




}
