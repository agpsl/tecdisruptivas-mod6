package com.github.agpsl.mod6.entity;


import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "corridas")
public class Corrida {
    // ID único para identificar a corrida
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corrida_id")
    private Integer corridaId;

    // Início da corrida
    @Column(name = "corrida_inicio")
    private LocalDateTime corridaInicio;

    // Distância em metros percorrida durante a corrida
    @Column(name = "corrida_distancia")
    private Integer corridaDistancia;

    // Final da corrida
    @Column(name = "corrida_final")
    private LocalDateTime corridaFinal;

    // Local da corrida
    @Column(name = "corrida_local")
    private String corridaLocal;

    public void setCorridaId(Integer corridaId) {
        this.corridaId = corridaId;
    }

    public Integer getCorridaId() {
        return corridaId;
    }

    public void setCorridaInicio(LocalDateTime corridaInicio) {
        this.corridaInicio = corridaInicio;
    }

    public LocalDateTime getCorridaInicio() {
        return corridaInicio;
    }

    public void setCorridaDistancia(Integer corridaDistancia) {
        this.corridaDistancia = corridaDistancia;
    }

    public Integer getCorridaDistancia() {
        return corridaDistancia;
    }

    public void setCorridaFinal(LocalDateTime corridaFinal) {
        this.corridaFinal = corridaFinal;
    }

    public LocalDateTime getCorridaFinal() {
        return corridaFinal;
    }

    public void setCorridaLocal(String corridaLocal) {
        this.corridaLocal = corridaLocal;
    }

    public String getCorridaLocal() {
        return corridaLocal;
    }

    // Retorna a duração da corrida
    public Long getCorridaDuracao() {
        Duration duracao = Duration.between(corridaInicio, corridaFinal);
        return duracao.toMinutes();
    }
}
