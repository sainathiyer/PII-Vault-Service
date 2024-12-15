package com.piivault.repository;

import com.piivault.domain.PiiData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PiiDataRepository extends JpaRepository<PiiData, Long> {
    // You can define custom query methods here if needed
}
