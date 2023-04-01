package com.christianosorio.eagle.model.user;

import com.christianosorio.eagle.model.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value = {"password"})
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users", schema = "eagle_hubs")
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String name;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email_address")
    private String emailAddress;

    private String password;

    @Builder.Default
    private Boolean enabled = true;

    @Override
    public String toString() {
        return userName;
    }
}
