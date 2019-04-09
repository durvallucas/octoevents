/*
 * Repositório para os Issues Events
 */
package com.example.octoevents.repository;

import com.example.octoevents.model.entity.Issue;
import com.example.octoevents.model.entity.IssueEvent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lucas
 */
public interface IssueEventRepository extends JpaRepository<IssueEvent, Long>{
    
    List<IssueEvent> findByIssue(Issue issue);
    
}
