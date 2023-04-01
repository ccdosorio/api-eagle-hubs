package com.christianosorio.eagle.repository;

import com.christianosorio.eagle.model.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long> {
}
