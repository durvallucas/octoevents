/*
 * Repositório para os Issues
 */
package com.example.octoevents.repository;

import com.example.octoevents.model.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lucas
 */
public interface IssueRepository extends JpaRepository<Issue, Long>{
    
    Issue findByNumero(Integer numero);
}
