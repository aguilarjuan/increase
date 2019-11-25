package com.increase.consultar.saldos.domain;

import lombok.*;

import java.io.Serializable;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "transaccion")
public class TransaccionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceTransaccion")
    @SequenceGenerator(name = "sequenceTransaccion",sequenceName="sequence_transaccion")
    private Long id;

    @Column(name = "transaccion_id")
    private String transaccionID;

    @Column(name = "cliente_id")
    private String clienteID;

    @Column(name = "monto")
    private Long monto;

    @Column(name = "tipo")
    private Long tipo;


}
