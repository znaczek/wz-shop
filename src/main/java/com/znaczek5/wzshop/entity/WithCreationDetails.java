package com.znaczek5.wzshop.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class WithCreationDetails {

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    @CreatedBy
    private LocalDateTime createdBy;
}
