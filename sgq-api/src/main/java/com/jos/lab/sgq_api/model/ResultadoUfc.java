package com.jos.lab.sgq_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_resultados")
public class ResultadoUfc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoCalculo; // Ex: "Geral" ou "Estafilococos"
    private String resultado;    // Ex: "1.50 × 10^06"
    private LocalDateTime dataHora;

    // Construtor que gera a data automática ao salvar
    public ResultadoUfc() {
        this.dataHora = LocalDateTime.now();
    }

    // Getters e Setters (Necessários para o banco de dados ler os dados)
    public Long getId() { return id; }
    public String getTipoCalculo() { return tipoCalculo; }
    public void setTipoCalculo(String tipoCalculo) { this.tipoCalculo = tipoCalculo; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    public LocalDateTime getDataHora() { return dataHora; }
}