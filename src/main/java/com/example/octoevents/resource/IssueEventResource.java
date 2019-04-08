/*
 * Rest Controller para gerenciar requisições para uma Issue 
 */
package com.example.octoevents.resource;

import com.example.octoevents.model.IssueEvent;
import com.example.octoevents.repository.IssueEventRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    
    @GetMapping("/{numero}/events")
    @ResponseStatus(HttpStatus.OK)
    public List<IssueEvent> pesquisar(@PathVariable Integer numero){
        IssueEvent issueEvent = new IssueEvent();
        issueEvent.setNumero(numero);
        return repository.findAll(Example.of(issueEvent));
    }
}
