package com.christianosorio.eagle.model.fuel;

import com.christianosorio.eagle.model.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "type_fuel", schema = "eagle_hubs")
public class TypeFuel extends Auditable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "type_fuel_id")
    private Long typeFuelId;

    private String name;
    private String description;
}
