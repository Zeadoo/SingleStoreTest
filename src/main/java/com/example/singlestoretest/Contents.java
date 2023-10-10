package com.example.singlestoretest;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contents {
    @Id
    @Column(nullable = false, updatable = false)
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;
}
