package com.piivault.repository;

import com.piivault.domain.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    // Custom queries can be added here
}
