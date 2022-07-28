package com.example.ecodationtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@JsonIgnoreProperties(value = {""}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "created_date")
    @CreationTimestamp
    private Instant createdDate;


    @Column(name = "update_date")
    @UpdateTimestamp
    private Instant updateDate;

}
