package com.piivault.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PiiData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Buyer Information
    private String buyerIdentificationCode;
    private String buyerFirstName;
    private String buyerSurname;
    private String buyerDateOfBirth;

    // Buyer Decision Maker Information
    private String buyerDecisionMakerCode;
    private String buyerDecisionMakerFirstName;
    private String buyerDecisionMakerSurname;
    private String buyerDecisionMakerDateOfBirth;

    // Seller Information
    private String sellerIdentificationCode;
    private String sellerFirstName;
    private String sellerSurname;
    private String sellerDateOfBirth;

    // Seller Decision Maker Information
    private String sellerDecisionMakerCode;
    private String sellerDecisionMakerFirstName;
    private String sellerDecisionMakerSurname;
    private String sellerDecisionMakerDateOfBirth;

    // Investment & Execution Information
    private String investmentDecisionWithinFirm;
    private String countryOfBranchResponsibleForInvestmentDecision;
    private String executionWithinFirm;
    private String countryOfBranchSupervisingExecution;

    // Relationship with User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Link to the user who owns this PII data

    @CreatedDate
    private LocalDateTime createdDate;  // Automatically set when the entity is created

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;  // Automatically set when the entity is updated

    @CreatedBy
    private String createdBy;  // Automatically set to the user who created the entity

    @LastModifiedBy
    private String lastModifiedBy;  // Automatically set to the user who last modified the entity


}
