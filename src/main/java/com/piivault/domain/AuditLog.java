package com.piivault.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // User who performed the action

    private Long piiDataId; // The PII data that was audited

    private String action; // Action performed (CREATE, UPDATE, DELETE)

    private LocalDateTime timestamp; // When the action occurred

    private String description; // Additional description of the action performed (optional)

}
