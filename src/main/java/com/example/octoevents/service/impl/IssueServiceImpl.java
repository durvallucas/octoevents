/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.octoevents.service.impl;

import com.example.octoevents.model.dto.IssueEventDto;
import com.example.octoevents.model.entity.Issue;
import com.example.octoevents.model.entity.IssueEvent;
import com.example.octoevents.repository.IssueEventRepository;
import com.example.octoevents.repository.IssueRepository;
import com.example.octoevents.service.IssueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lucas
 */
@Service
public class IssueServiceImpl implements IssueService{
    
    @Autowired
    private IssueRepository issueRepository;
    
    @Autowired
    private IssueEventRepository issueEventRepository;
    
    @Transactional
    @Override
    public IssueEvent registrarEvento(IssueEventDto issueEventDto){
        Issue issue = issueRepository.findByNumero(issueEventDto.getNumero());
        
        if (issue == null){
            issue = new Issue();
            issue.setNumero(issueEventDto.getNumero());
            issue.setDataCriacao(issueEventDto.getDataCriacao());
            
            issueRepository.save(issue);
        }
        
        IssueEvent issueEvent = new IssueEvent();
        issueEvent.setIssue(issue);
        issueEvent.setDataCriacao(issueEventDto.getDataAtualizacao());
        issueEvent.setAcao(issueEventDto.getAcao());
        
        issueEventRepository.save(issueEvent);
        return issueEvent;
    }
    
    @Override
    public List<IssueEvent> obterEventsDeUmaIssue(Integer numeroIssue){
        Issue issue = issueRepository.findByNumero(numeroIssue);
        return issueEventRepository.findByIssue(issue);
    }
    
}
