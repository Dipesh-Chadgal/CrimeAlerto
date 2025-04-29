package com.repository;


import com.entity.LawEnforcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawEnforcementRepository extends JpaRepository<LawEnforcement, Integer> {

}
