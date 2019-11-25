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
public class DescuentoDTO  implements Serializable {

    private String descuentoID;

    private String clienteID;

    private Long monto;

    private Long tipo;

}
