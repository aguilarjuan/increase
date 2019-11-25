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
public class TransaccionDTO implements Serializable {

    private String transaccionID;

    private String clienteID;

    private Long monto;

    private Long tipo;


}
