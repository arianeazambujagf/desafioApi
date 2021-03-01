package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class StatementModel {

    private String conta;
    private int id;
    private String descricao;
    private String envolvido;
    private String observacao;
    private String tipo;
    private String data_transacao;
    private String data_pagamento;
    private String valor;
    private Boolean status;
    private int conta_id;
    private int usuario_id;
    private int transferencia_id;
    private int parcelamento_id;
}
