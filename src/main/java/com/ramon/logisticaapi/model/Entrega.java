package com.ramon.logisticaapi.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.ramon.logisticaapi.ValidationGroups;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
@Entity
public class Entrega {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @Embedded
    private Destinatario destinatario;

    //private List<Ocorrencia> ocorrencias = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    private BigDecimal taxa;

    private OffsetDateTime dataPedido;

    private OffsetDateTime dataFinalizacao;
}
