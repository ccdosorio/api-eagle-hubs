package com.christianosorio.eagle.repository.fuel;

import com.christianosorio.eagle.model.fuel.TypeFuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeFuelRepository extends JpaRepository<TypeFuel, Long> {
}
