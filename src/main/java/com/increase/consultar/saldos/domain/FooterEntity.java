package com.increase.consultar.saldos.domain;


import lombok.*;

import java.io.Serializable;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "footer")
public class FooterEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceFooter")
    @SequenceGenerator(name = "sequenceFooter",sequenceName="sequence_footer")
    private Long id;

    @Column(name = "fecha_pago")
    private Long fechaPago;

    @Column(name = "cliente_id")
    private String clienteID;

}
