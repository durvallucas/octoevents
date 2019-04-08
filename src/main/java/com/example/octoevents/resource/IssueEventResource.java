/*
 * Rest Controller para gerenciar requisições para uma Issue 
 */
package com.example.octoevents.resource;

import com.example.octoevents.model.entity.IssueEvent;
import com.example.octoevents.repository.IssueEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */

@RestController
@RequestMapping("/issues")
public class IssueEventResource {
    @Autowired
    private IssueEventRepository repository;
    
    @PostMapping()
    public ResponseEntity<IssueEvent> criar(@RequestBody IssueEvent issueEvent){
        IssueEvent novoIssueEvent = repository.save(issueEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoIssueEvent);
    }
}
