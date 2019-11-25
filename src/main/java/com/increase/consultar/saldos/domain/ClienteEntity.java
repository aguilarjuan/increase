package com.increase.consultar.saldos.domain;

import lombok.*;

import java.io.Serializable;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCliente")
    @SequenceGenerator(name = "sequenceCliente",sequenceName="sequence_cliente")
    private Long id;

    @Column(name = "cliente_id")
    private String clienteID;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "job")
    private String job;

    @Column(name = "country")
    private String country;

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "phone")
    private String phone;


}
