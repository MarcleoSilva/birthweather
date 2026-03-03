package com.projects.birthweather.repository;

import com.projects.birthweather.domain.birthdata.BirthData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BirthDataRepository extends JpaRepository<BirthData, UUID> {


}
