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
@ApiModel("ResponseClienteDTO")
public class ResponseClienteDTO implements Serializable {

    @JsonProperty("clienteID")
    @ApiModelProperty(value = "clienteID")
    private String clienteID;

    @JsonProperty("email")
    @ApiModelProperty(value = "email")
    private String email;

    @JsonProperty("firstName")
    @ApiModelProperty(value = "firstName")
    private String firstName;

    @JsonProperty("lastName")
    @ApiModelProperty(value = "lastName")
    private String lastName;

    @JsonProperty("job")
    @ApiModelProperty(value = "job")
    private String job;

    @JsonProperty("country")
    @ApiModelProperty(value = "country")
    private String country;

    @JsonProperty("address")
    @ApiModelProperty(value = "address")
    private String address;

    @JsonProperty("zipCode")
    @ApiModelProperty(value = "zipCode")
    private String zipCode;

    @JsonProperty("phone")
    @ApiModelProperty(value = "phone")
    private String phone;
}
