package com.christianosorio.eagle.model.trip;

import com.christianosorio.eagle.model.Auditable;
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
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "type_trip", schema = "eagle_hubs")
public class TypeTrip extends Auditable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "type_trip_id")
    private Long typeTripId;

    private String name;
    private String description;
}
