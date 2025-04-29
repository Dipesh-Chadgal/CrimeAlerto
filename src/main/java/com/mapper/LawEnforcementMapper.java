package com.mapper;

import com.dto.LawEnforcementDTO.LawEnforcementRegister;
import com.entity.LawEnforcement;
import org.springframework.stereotype.Component;

@Component
public class LawEnforcementMapper {

    public LawEnforcement RegisterToEntity(LawEnforcementRegister lawEnforcementRegister) {
        LawEnforcement lawEnforcement = new LawEnforcement();
                lawEnforcement.setPoliceStationName(lawEnforcementRegister.getPoliceStationName());
                lawEnforcement.setPoliceStationEmail(lawEnforcementRegister.getPoliceStationEmail());
                lawEnforcement.setPoliceStationContactNo(lawEnforcementRegister.getPoliceStationContactNo());
                lawEnforcement.setSho(lawEnforcementRegister.getSho());
                lawEnforcement.setAddress(lawEnforcementRegister.getAddress());
                lawEnforcement.setPassword(lawEnforcementRegister.getPassword());
               return lawEnforcement;
    }
}
