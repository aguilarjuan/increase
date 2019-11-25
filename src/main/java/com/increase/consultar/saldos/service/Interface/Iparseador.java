package com.increase.consultar.saldos.service.Interface;

public interface Iparseador {

    public void parsearLinea(String linea, String clienteId);
    public void  setNext(Iparseador parseador);
    public Iparseador  getNext();
}
