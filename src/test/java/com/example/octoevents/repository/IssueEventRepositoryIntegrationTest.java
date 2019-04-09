/*
 * Testes do repositório de Issues Events
 */
package com.example.octoevents.repository;

import com.example.octoevents.model.entity.Issue;
import com.example.octoevents.model.entity.IssueEvent;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author lucas
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class IssueEventRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private IssueEventRepository repository;
    
    @Test
    public void deveRetornarOsEventosDeUmaIssue(){
        //dado
        Issue issueUm = new Issue();
        issueUm.setNumero(1);
        issueUm.setDataCriacao(LocalDateTime.now());
        entityManager.persist(issueUm);
        
        Issue issueDois = new Issue();
        issueDois.setNumero(2);
        issueDois.setDataCriacao(LocalDateTime.now());
        entityManager.persist(issueDois);
        
        IssueEvent issueEventUm = new IssueEvent();
        issueEventUm.setIssue(issueUm);
        issueEventUm.setDataCriacao(LocalDateTime.now());
        issueEventUm.setAcao("opened");
        entityManager.persist(issueEventUm);
        
        IssueEvent issueEventDois = new IssueEvent();
        issueEventDois.setIssue(issueDois);
        issueEventDois.setDataCriacao(LocalDateTime.now());
        issueEventDois.setAcao("closed");
        entityManager.persist(issueEventDois);
        
        entityManager.flush();
        
        //quando
        List<IssueEvent> events = repository.findByIssue(issueUm);
        
        //então
        Assert.assertEquals(1, events.size());
        Assert.assertEquals(issueEventUm, events.get(0));
        
    }
    
    
}
