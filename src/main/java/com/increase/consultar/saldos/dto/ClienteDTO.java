package com.increase.consultar.saldos.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClienteDTO  implements Serializable {

    @JsonProperty("id")
    private String clienteID;

    @JsonProperty("email")
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("job")
    private String job;

    @JsonProperty("country")
    private String country;

    @JsonProperty("address")
    private String address;

    @JsonProperty("zip_code")
    private String zipCode;

    @JsonProperty("phone")
    private String phone;

}
