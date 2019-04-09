/*
 * Entidade com os dados pertinentes a um Issue Event
 */
package com.example.octoevents.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author lucas
 */

public class IssueEventDto {
    
    private Integer numero;
    
    @JsonProperty("action")
    private String acao;
    
    private LocalDateTime dataCriacao;
    
    private LocalDateTime dataAtualizacao;
    

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
