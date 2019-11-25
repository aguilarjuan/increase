package com.increase.consultar.saldos.service.Implementacion;

import com.increase.consultar.saldos.service.Interface.Iparseador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImplParseador implements Iparseador {

    @Autowired
    private ImplParsearCabecera implParsearCabecera;

    @Autowired
    private ImplParsearTransaccion implParsearTransaccion;

    @Autowired
    private ImplParsearDescuento implParsearDescuento;

    @Autowired
    private ImplParsearFooter implParsearFooter;

    private Iparseador nexParseador;

    @Override
    public void parsearLinea(String linea, String clienteId) {

        this.setNext(implParsearCabecera);

        implParsearCabecera.setNext(implParsearTransaccion);

        implParsearTransaccion.setNext(implParsearDescuento);

        implParsearDescuento.setNext(implParsearFooter);

        nexParseador.parsearLinea(linea,clienteId);

    }

    @Override
    public void setNext(Iparseador parseador) {
        nexParseador = parseador;
    }

    @Override
    public Iparseador getNext() {
        return nexParseador;
    }
}
