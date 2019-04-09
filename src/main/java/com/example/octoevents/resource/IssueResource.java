/*
 * Rest Controller para gerenciar requisições para uma Issue 
 */
package com.example.octoevents.resource;

import com.example.octoevents.model.dto.IssueEventDto;
import com.example.octoevents.model.entity.IssueEvent;
import com.example.octoevents.service.IssueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IssueResource {
    
    @Autowired
    private IssueService service;
    
    @PostMapping()
    public ResponseEntity<IssueEvent> registrarEvent(@RequestBody IssueEventDto issueEvent){
        IssueEvent novoIssueEvent = service.registrarEvento(issueEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoIssueEvent);
    }
    
    @GetMapping("/{numero}/events")
    @ResponseStatus(HttpStatus.OK)
    public List<IssueEvent> pesquisarEvents(@PathVariable Integer numero){
        return service.obterEventsDeUmaIssue(numero);
    }
}
