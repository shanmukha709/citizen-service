package com.village.basicinfo.repository;

import com.village.basicinfo.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    List<Citizen> findByAreaId(Long areaId);
    Optional<Citizen> findByUsername(String username);
    List<Citizen> findByDesignationId(Long designationId);
}
