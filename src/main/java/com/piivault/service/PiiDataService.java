package com.piivault.service;

import com.piivault.domain.PiiData;
import com.piivault.repository.PiiDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PiiDataService {

    @Autowired
    private PiiDataRepository piiDataRepository;

    @Autowired
    private AuditService auditService;  // To log actions

    // Method to save PII Data (Create)
    public PiiData save(PiiData piiData) {
        PiiData savedPiiData = piiDataRepository.save(piiData);
        // Log the creation action (you can modify the logic to capture the current user)
        auditService.logAuditAction(piiData.getUser().getId(), savedPiiData.getId(), "CREATE", "Created new PII data");
        return savedPiiData;
    }

    // Method to update PII Data
    public PiiData update(PiiData piiData) {
        Optional<PiiData> existingPiiData = piiDataRepository.findById(piiData.getId());

        if (existingPiiData.isPresent()) {
            PiiData updatedPiiData = piiDataRepository.save(piiData);

            // Log the update action
            auditService.logAuditAction(piiData.getUser().getId(), updatedPiiData.getId(), "UPDATE", "Updated PII data");

            return updatedPiiData;
        }

        // Handle the case where the PII data doesn't exist
        return null;
    }

    // Method to delete PII Data
    public boolean delete(Long id) {
        Optional<PiiData> existingPiiData = piiDataRepository.findById(id);
        if (existingPiiData.isPresent()) {
            piiDataRepository.deleteById(id);

            // Log the delete action but need to capture the user who deleted it
            auditService.logAuditAction(1L, id, "DELETE", "Deleted PII data");
            return true;
        }
        return false;
    }

    // Method to fetch a specific PII Data by its ID
    public PiiData getPiiDataById(Long id) {
        if(piiDataRepository.findById(id).isPresent()){
            return piiDataRepository.findById(id).get();
        }
        return null;
    }

    // Method to fetch all PII Data
    public List<PiiData> getAllPiiData() {
        return piiDataRepository.findAll();
    }
}
