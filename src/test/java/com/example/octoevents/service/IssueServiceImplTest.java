/*
 * Testes do serviço de Issues.
 */
package com.example.octoevents.service;

import com.example.octoevents.model.dto.IssueEventDto;
import com.example.octoevents.model.entity.Issue;
import com.example.octoevents.model.entity.IssueEvent;
import com.example.octoevents.repository.IssueEventRepository;
import com.example.octoevents.repository.IssueRepository;
import com.example.octoevents.service.impl.IssueServiceImpl;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author lucas
 */
@RunWith(SpringRunner.class)
public class IssueServiceImplTest {
    
    @TestConfiguration
    static class IssueServiceImplContextConfiguration {

        @Bean
        public IssueService issueService() {
            return new IssueServiceImpl();
        }
    }

    private IssueEventDto issueEventDto;
    
    @Autowired
    private IssueService issueService;

    @MockBean
    private IssueRepository issueRepository;

    @MockBean
    private IssueEventRepository issueEventRepository;

    
    @Before
    public void setUp(){
        issueEventDto = new IssueEventDto();
        issueEventDto.setAcao("opened");
        issueEventDto.setNumero(1000);
        issueEventDto.setDataCriacao(LocalDateTime.of(2019, Month.MARCH, 10, 12, 0));
        issueEventDto.setDataAtualizacao(LocalDateTime.of(2019, Month.MARCH, 10, 12, 0));
    }
    
    @Test
    public void aoRegistrarUmEventoDeUmaIssueNaoExistenteAIssueDeveSerCriada() {
        Mockito.when(issueRepository.findByNumero(issueEventDto.getNumero()))
                .thenReturn(null);
        
        IssueEvent issueEventCriada = issueService.registrarEvento(issueEventDto);
        
        Mockito.verify(issueRepository).save(Mockito.any(Issue.class));
        Assert.assertEquals(issueEventDto.getDataCriacao(), issueEventCriada.getIssue().getDataCriacao());
        Assert.assertEquals(issueEventDto.getNumero(), issueEventCriada.getIssue().getNumero());
    }
    
    @Test
    public void aoRegistrarUmEventoDeUmaIssueExistenteOEventoDeveSerCriadoParaEssaIssue(){
        Issue issue = new Issue();
        issue.setId(1L);
        
        Mockito.when(issueRepository.findByNumero(issueEventDto.getNumero()))
                .thenReturn(issue);
        
        IssueEvent issueEventCriada = issueService.registrarEvento(issueEventDto);
        
        Assert.assertEquals(issue, issueEventCriada.getIssue());
    }
    
    @Test
    public void deveRegistrarOEventoInformado(){
        Issue issue = new Issue();
        issue.setId(1L);
        
        Mockito.when(issueRepository.findByNumero(issueEventDto.getNumero()))
                .thenReturn(issue);
        
        IssueEvent issueEventCriada = issueService.registrarEvento(issueEventDto);
        
        Assert.assertEquals(issueEventDto.getAcao(), issueEventCriada.getAcao());
        Assert.assertEquals(issueEventDto.getDataAtualizacao(), issueEventCriada.getDataCriacao());
        Assert.assertEquals(issue, issueEventCriada.getIssue());
    }
    
    @Test
    public void deveObterOsEventsDeUmaIssue(){
        IssueEvent issueEventUm = new IssueEvent();
        IssueEvent issueEventDois = new IssueEvent();
        
        Issue issue = new Issue();
        issue.setNumero(1000);
        
        Mockito.when(issueRepository.findByNumero(issue.getNumero()))
                .thenReturn(issue);
        
        Mockito.when(issueEventRepository.findByIssue(issue))
                .thenReturn(Arrays.asList(issueEventUm, issueEventDois));
        
        List<IssueEvent> events = issueService.obterEventsDeUmaIssue(issue.getNumero());
        
        Assert.assertEquals(2, events.size());
        Assert.assertTrue(events.contains(issueEventUm));
        Assert.assertTrue(events.contains(issueEventDois));
    }
        
        
}
