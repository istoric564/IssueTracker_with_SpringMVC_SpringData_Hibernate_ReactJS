package com.istoric564.springboot.service;

import com.istoric564.springboot.model.Issue;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public interface IssueService {

    List<Issue> getAllIssues();
    Issue createIssue(@RequestBody Issue issue);
    ResponseEntity<Issue> getIssueById(@PathVariable Integer id);
    ResponseEntity<Issue> updateIssue(@PathVariable Integer id, @RequestBody Issue issueDetails);
    ResponseEntity<Map<String, Boolean>> deleteIssue(@PathVariable Integer id);
}
