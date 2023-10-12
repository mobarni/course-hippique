package com.pmu.course.repository;

import com.pmu.course.model.Partant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartantRepository extends JpaRepository<Partant, UUID>  {

}
