package com.istoric564.springboot.service;

import com.istoric564.springboot.exception.ResourceNotFoundException;
import com.istoric564.springboot.model.Issue;
import com.istoric564.springboot.repository.IssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class DefaultIssueService implements IssueService {

    private final IssueRepository issueRepository;


    @Override
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    @Override
    public Issue createIssue(@RequestBody Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public ResponseEntity<Issue> getIssueById(@PathVariable Integer id) {
        Issue issue = issueRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Issue not exist with id: " + id));
        return ResponseEntity.ok(issue);
    }

    @Override
    public ResponseEntity<Issue> updateIssue(@PathVariable Integer id, @RequestBody Issue issueDetails) {
        Issue issue = issueRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Issue not exist with id: " + id));
        issue.setId(issueDetails.getId());
        issue.setCreatedBy(issueDetails.getCreatedBy());
        issue.setIssueSummary(issueDetails.getIssueSummary());
        issue.setIssueDescription(issueDetails.getIssueDescription());
        issue.setCreatedOn(issueDetails.getCreatedOn());
        issue.setStatus(issueDetails.getStatus());
        issue.setTitle(issueDetails.getTitle());
        Issue updateIssue = issueRepository.save(issue);
        return ResponseEntity.ok(updateIssue);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteIssue(Integer id) {
        Issue issue = issueRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Issue not exist with id: " + id));
        issueRepository.delete(issue);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
