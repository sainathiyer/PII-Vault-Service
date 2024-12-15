package com.piivault.service;

import com.piivault.domain.AuditLog;
import com.piivault.domain.PiiData;
import com.piivault.domain.User;
import com.piivault.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public void logAuditAction(Long userId, Long piiDataId, String action, String description) {
        AuditLog auditLog = new AuditLog();
        auditLog.setUserId(userId);  // This can be a User object reference
        auditLog.setPiiDataId(piiDataId);  // Link to the specific PiiData entity
        auditLog.setAction(action);  // Action like CREATE, UPDATE, DELETE
        auditLog.setTimestamp(LocalDateTime.now());
        auditLog.setDescription(description);
        auditLogRepository.save(auditLog);
    }
}
