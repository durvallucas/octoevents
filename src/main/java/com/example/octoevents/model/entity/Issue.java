/*
 * Entidade com os dados pertinentes a um Issue
 */
package com.example.octoevents.model.entity;

import java.time.LocalDateTime;
import java.util.Objects;
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
@Table(name = "issue", schema = "octo")
public class Issue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_issue")
    @SequenceGenerator(name = "sq_issue", sequenceName = "octo.sq_issue", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "dt_criacao")
    private LocalDateTime dataCriacao;
    
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Issue other = (Issue) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
