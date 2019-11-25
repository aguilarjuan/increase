package com.increase.consultar.saldos.service.Implementacion;

import com.increase.consultar.saldos.Enums.TiposRegistroEnum;
import com.increase.consultar.saldos.dto.CabeceraDTO;
import com.increase.consultar.saldos.service.CabeceraService;
import com.increase.consultar.saldos.service.Interface.Iparseador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImplParsearCabecera implements Iparseador {

    @Autowired
    private CabeceraService cabeceraService;

    private Iparseador nexParseador;

    private final Logger log = LoggerFactory.getLogger(ImplParsearCabecera.class);

    private String pagoID;
    private String moneda;
    private String montoTotal;
    private String totalDescuentos;
    private String totalConDescuentos;

    @Override
    public void parsearLinea(String linea, String clienteId) {

        if (linea.startsWith(TiposRegistroEnum.CABECERA.getTipo())){

            String trimLinea = linea.trim();
            pagoID = trimLinea.substring(1,33);
            moneda = trimLinea.substring(36,39);
            montoTotal = trimLinea.substring(39,52);
            totalDescuentos = trimLinea.substring(52,65);
            totalConDescuentos = trimLinea.substring(65,78);
            CabeceraDTO cabeceraDTO = new CabeceraDTO();

            cabeceraDTO.setPagoID(pagoID);
            cabeceraDTO.setMoneda(Long.valueOf(moneda));
            cabeceraDTO.setMontoTotal(Long.valueOf(montoTotal));
            cabeceraDTO.setTotalDescuentos(Long.valueOf(totalDescuentos));
            cabeceraDTO.setTotalConDescuentos(Long.valueOf(totalConDescuentos));
            cabeceraDTO.setClienteID(clienteId);
            cabeceraService.saveEntity(cabeceraDTO);
            log.debug("se a parseado e insertado un registro tipo [cabecera]");
        } else {
            nexParseador.parsearLinea(linea,clienteId);
        }

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
