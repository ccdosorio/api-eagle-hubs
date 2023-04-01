package com.christianosorio.eagle.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class Auditable {
    @Basic(optional = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Basic(optional = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Basic(optional = false)
    @CreatedBy
    private String createdBy;

    @Basic(optional = false)
    @LastModifiedBy
    private String updatedBy;
}
