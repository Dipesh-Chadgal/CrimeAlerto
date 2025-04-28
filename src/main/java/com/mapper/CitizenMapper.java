package com.mapper;

import com.dto.CitizenDTO.CitizenRegister;
import com.entity.Citizen;

public class CitizenMapper {
    public Citizen RegisterToEntity(CitizenRegister citizenRegister) {
        Citizen citizen = new Citizen();
        citizen.setName(citizenRegister.getName());
        citizen.setEmail(citizenRegister.getEmail());
        citizen.setPhoneNumber(citizenRegister.getPhoneNumber());
        citizen.setCreatedAt(citizenRegister.getCreatedAt());
        citizen.setPassword(citizenRegister.getPassword());
        return citizen;
    }
}
