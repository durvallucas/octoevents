/*
 * Testes do repositório de Issues
 */
package com.example.octoevents.repository;

import com.example.octoevents.model.entity.Issue;
import java.time.LocalDateTime;
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
public class IssueRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private IssueRepository repository;
    
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
        
        entityManager.flush();
        
        //quando
        Issue issue = repository.findByNumero(2);
        
        //então
        Assert.assertEquals(issueDois, issue);
        
    }
    
    
}
