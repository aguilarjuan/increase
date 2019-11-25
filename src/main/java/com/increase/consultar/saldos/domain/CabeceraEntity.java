package com.increase.consultar.saldos.domain;

import lombok.*;

import java.io.Serializable;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "cabecera")
public class CabeceraEntity implements Serializable  {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCabecera")
    @SequenceGenerator(name = "sequenceCabecera",sequenceName="sequenceCabecera")
    private Long id;

    @Column(name = "pago_id")
    private String pagoID;

    @Column(name = "cliente_id")
    private String clienteID;

    @Column(name = "moneda")
    private Long moneda;

    @Column(name = "monto_total")
    private Long montoTotal;

    @Column(name = "total_descuentos")
    private Long totalDescuentos;

    @Column(name = "total_con_descuentos")
    private Long totalConDescuentos;

}
