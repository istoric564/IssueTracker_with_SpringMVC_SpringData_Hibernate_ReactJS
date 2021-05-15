package com.istoric564.springboot.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "issue_description")
    private String issueDescription;

    @Column(name = "issue_summary")
    private String issueSummary;

    @Column(name = "status")
    private String status;

    @Column(name = "title")
    private String title;
}
