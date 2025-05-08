package com.fiap.brinquedos_api.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "TDS_TB_BRINQUEDOS")
public class Brinquedo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    private String classificacao;
    
    @Column(nullable = false)
    private String tamanho;
    
    @Column(nullable = false)
    private Double preco;
} 