package com.increase.consultar.saldos.domain;


import lombok.*;

import java.io.Serializable;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "descuento")
public class DescuentoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceDescuento")
    @SequenceGenerator(name = "sequenceDescuento",sequenceName="sequence_descuento")
    private Long id;

    @Column(name = "descuento_id")
    private String descuentoID;

    @Column(name = "cliente_id")
    private String clienteID;

    @Column(name = "monto")
    private Long monto;

    @Column(name = "tipo")
    private Long tipo;
}
