package com.christianosorio.eagle.model.consumption;

import com.christianosorio.eagle.model.Auditable;
import com.christianosorio.eagle.model.Measure;
import com.christianosorio.eagle.model.TypeEmission;
import com.christianosorio.eagle.model.fuel.TypeFuel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "consumption", schema = "eagle_hubs")
public class Consumption extends Auditable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "consumption_id")
    private Long consumptionId;

    private String name;
    private String description;
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "measure_id", nullable = false)
    private Measure measure;

    @ManyToOne
    @JoinColumn(name = "type_fuel_id", nullable = false)
    private TypeFuel typeFuel;

    @ManyToOne
    @JoinColumn(name = "type_consumption_id", nullable = false)
    private TypeConsumption typeConsumption;

    @ManyToOne
    @JoinColumn(name = "type_emission_id", nullable = false)
    private TypeEmission typeEmission;

}
