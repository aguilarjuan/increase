package com.increase.consultar.saldos.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel("ResponseTransaccionesDTO")
public class ResponseTransaccionesDTO implements Serializable {

    @JsonProperty("transaccionID")
    @ApiModelProperty(value = "transaccionID")
    private String transaccionID;

    @JsonProperty("monto")
    @ApiModelProperty(value = "monto")
    private Integer monto;

    @JsonProperty("tipo")
    @ApiModelProperty(value = "tipo")
    private String tipo;

    @JsonProperty("clienteID")
    @ApiModelProperty(value = "clienteID")
    private String clienteID;
}
