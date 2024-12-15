package com.piivault.controller;

import com.piivault.domain.PiiData;
import com.piivault.service.PiiDataService;
import com.piivault.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/pii-data")
public class PiiDataController {

    @Autowired
    private PiiDataService piiDataService;

    @Autowired
    private AuditService auditService;

    @PostMapping
    public PiiData createPiiData(@Valid @RequestBody PiiData piiData) {
        PiiData savedPiiData = piiDataService.save(piiData);

        // Log the audit action manually (CREATE action)
        auditService.logAuditAction(piiData.getUser().getId(), savedPiiData.getId(), "CREATE", "Created new PII data");

        return savedPiiData;
    }

    // Endpoint to update existing PII data
    @PutMapping()
    public ResponseEntity<PiiData> updatePiiData(@Valid @RequestBody PiiData piiData) {
        PiiData updatedPiiData = piiDataService.update(piiData);
        if (Objects.nonNull(updatedPiiData)) {
            return ResponseEntity.ok(updatedPiiData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to get PII data by ID
    @GetMapping("/{id}")
    public ResponseEntity<PiiData> getPiiDataById(@PathVariable Long id) {
        PiiData piiData = piiDataService.getPiiDataById(id);
        if (Objects.nonNull(piiData)) {
            return ResponseEntity.ok(piiData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to get all PII data
    @GetMapping
    public ResponseEntity<List<PiiData>> getAllPiiData() {
        List<PiiData> piiDataList = piiDataService.getAllPiiData();
        return ResponseEntity.ok(piiDataList);
    }

    // Endpoint to delete PII data by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePiiData(@PathVariable Long id) {
        boolean deleted = piiDataService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
