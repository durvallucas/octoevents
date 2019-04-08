/*
 * Entidade com os dados pertinentes a um Issue Event
 */
package com.example.octoevents.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Column(name = "numero")
    private Integer numero;
    
    @JsonProperty("action")
    @Column(name = "acao")
    private String acao;
    
    @Column(name = "dt_criacao")
    private LocalDateTime dataCriacao;
    
    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    
    
    @SuppressWarnings("unchecked")
    @JsonProperty("issue")
    private void unpackNested(Map<String,Object> issue) {
        this.numero  = (Integer)issue.get("number");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        this.dataCriacao = LocalDateTime.parse((String)issue.get("created_at"), formatter);
        this.dataAtualizacao = LocalDateTime.parse((String)issue.get("updated_at"), formatter);
    }


    
    
    
    
}
