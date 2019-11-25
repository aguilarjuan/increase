package com.increase.consultar.saldos.Enums;

public enum TiposRegistroEnum {

    CABECERA("1"),
    TRANSACCCION("2"),
    DESCUENTO("3"),
    FOOTER("4");

    String tipoRegistro;

     TiposRegistroEnum(String tipoRegistro) {

        this.tipoRegistro = tipoRegistro;
    }

    public String getTipo() {
        return tipoRegistro;
    }


}
