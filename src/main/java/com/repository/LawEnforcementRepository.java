package com.repository;

import com.entity.Citizen;
import com.entity.LawEnforcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawEnforcementRepository extends JpaRepository<LawEnforcement, Integer> {

}
