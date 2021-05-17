package com.istoric564.springboot.controller;

import com.istoric564.springboot.exception.ResourceNotFoundException;
import com.istoric564.springboot.model.Issue;
import com.istoric564.springboot.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class IssuesController {

    private final IssueRepository issueRepository;

    public IssuesController(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @GetMapping("/issues" )
    public List<Issue> getAllIssues(){
        return issueRepository.findAll();
    }

    @PostMapping("/issues")
    public Issue createIssue(@RequestBody Issue issue){

        return issueRepository.save(issue);
    }

    @GetMapping("/issues/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable Integer id){
        Issue issue = issueRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Issue not exist with id: " + id));
        return ResponseEntity.ok(issue);
    }

    @RequestMapping(value = "/issues/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Issue> updateIssue(@PathVariable Integer id,@RequestBody Issue issueDetails){
        Issue issue = issueRepository.findById(id).orElseThrow(()->
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
    @DeleteMapping("/issues/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteIssue(@PathVariable Integer id){
        Issue issue = issueRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Issue not exist with id: " + id));

        issueRepository.delete(issue);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
