package com.increase.consultar.saldos.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel("ResponseBalanceDTO")
public class ResponseBalanceDTO implements Serializable {

    @JsonProperty("clienteID")
    @ApiModelProperty(value = "clienteID")
    private String clienteID;

    @JsonProperty("montoTotal")
    @ApiModelProperty(value = "montoTotal")
    private Integer montoTotal;

    @JsonProperty("totalConDescuentos")
    @ApiModelProperty(value = "totalConDescuentos")
    private Integer totalConDescuentos;

}
