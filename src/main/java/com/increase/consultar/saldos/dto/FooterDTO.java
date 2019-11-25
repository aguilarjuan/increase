package com.increase.consultar.saldos.dto;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FooterDTO implements Serializable {

private String clienteID;

private Long fechaPago;

}
