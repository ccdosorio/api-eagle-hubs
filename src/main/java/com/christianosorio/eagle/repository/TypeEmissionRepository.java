package com.christianosorio.eagle.repository;

import com.christianosorio.eagle.model.TypeEmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEmissionRepository extends JpaRepository<TypeEmission, Long> {
}
