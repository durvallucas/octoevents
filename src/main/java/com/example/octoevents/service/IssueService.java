/*
 * Interface para o serviço de Issues e Events
 */
package com.example.octoevents.service;

import com.example.octoevents.model.dto.IssueEventDto;
import com.example.octoevents.model.entity.IssueEvent;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface IssueService {
    
    public IssueEvent registrarEvento(IssueEventDto issueEventDto);
    
    public List<IssueEvent> obterEventsDeUmaIssue(Integer numeroIssue);
    
}
