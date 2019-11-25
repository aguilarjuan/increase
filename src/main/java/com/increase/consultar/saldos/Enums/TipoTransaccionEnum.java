package com.increase.consultar.saldos.Enums;

public enum TipoTransaccionEnum {

    APROBADO("1"),
    RECHAZADO("2");

    String tipoTransaccion;

    TipoTransaccionEnum(String tipoTransaccion) {

        this.tipoTransaccion = tipoTransaccion;
    }

    public String getTipo() {
        return tipoTransaccion;
    }
}
