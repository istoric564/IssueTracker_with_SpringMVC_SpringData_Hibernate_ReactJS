package com.istoric564.springboot.controller;

import com.istoric564.springboot.model.Issue;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.istoric564.springboot.service.DefaultIssueService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
@Log
public class IssuesController {

    private final DefaultIssueService issueService;

    public IssuesController(DefaultIssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/issues")
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }

    @PostMapping("/issues")
    public Issue createIssue(@RequestBody Issue issue) {
        return issueService.createIssue(issue);
    }

    @GetMapping("/issues/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable Integer id){
        return issueService.getIssueById(id);
    }

    @RequestMapping(value = "/issues/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Issue> updateIssue(@PathVariable Integer id, @RequestBody Issue issueDetails){
        return  issueService.updateIssue(id,issueDetails);
    }

    @DeleteMapping("/issues/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteIssue(@PathVariable Integer id){
        return issueService.deleteIssue(id);
    }


}
