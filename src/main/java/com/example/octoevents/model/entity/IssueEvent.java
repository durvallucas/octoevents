/*
 * Entidade com os dados pertinentes a um Issue Event
 */
package com.example.octoevents.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "issue_event", schema = "octo")
public class IssueEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_issue_event")
    @SequenceGenerator(name = "sq_issue_event", sequenceName = "octo.sq_issue_event", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @JsonProperty("action")
    @Column(name = "acao")
    private String acao;
    
    @Column(name = "dt_criacao")
    private LocalDateTime dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issu_id", nullable = false)
    private Issue issue;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IssueEvent other = (IssueEvent) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
