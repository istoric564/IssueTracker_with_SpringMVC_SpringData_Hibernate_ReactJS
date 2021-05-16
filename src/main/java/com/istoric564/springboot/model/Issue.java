package com.istoric564.springboot.model;

import com.istoric564.springboot.model.enums.IssueEnums;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "issues")
public class Issue {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_on")
    @NotNull
    private LocalDateTime createdOn;

    @NotNull
    @Column(name = "issue_description")
    private String issueDescription;

    @Column(name = "issue_summary")
    private String issueSummary;

    @Column(name = "status")
    private IssueEnums status;

    @Column(name = "title")
    private String title;
}
