package com.increase.consultar.saldos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CabeceraDTO implements Serializable {

    private String pagoID;

    private String clienteID;

    private Long moneda;

    private Long montoTotal;

    private Long totalDescuentos;

    private Long totalConDescuentos;


}
