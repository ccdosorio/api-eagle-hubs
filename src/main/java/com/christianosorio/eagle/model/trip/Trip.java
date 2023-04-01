package com.christianosorio.eagle.model.trip;

import com.christianosorio.eagle.model.Auditable;
import com.christianosorio.eagle.model.consumption.Consumption;
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

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "trips", schema = "eagle_hubs")
public class Trip extends Auditable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "trip_id")
    private Long tripId;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_trip_id", nullable = false)
    private TypeTrip typeTrip;

    @Column(name = "date_trip", nullable = false)
    private Date dateTrip;

    @ManyToOne
    @JoinColumn(name = "consumption_id", nullable = false)
    private Consumption consumption;
}
