package com.increase.consultar.saldos.service.Implementacion;

import com.increase.consultar.saldos.Enums.TiposRegistroEnum;
import com.increase.consultar.saldos.dto.TransaccionDTO;
import com.increase.consultar.saldos.service.Interface.Iparseador;
import com.increase.consultar.saldos.service.TransacccionService;
//import TransacccionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImplParsearTransaccion implements Iparseador {

    @Autowired
    private TransacccionService transacccionService;

    private Iparseador nexParseador;

    private final Logger log = LoggerFactory.getLogger(ImplParsearTransaccion.class);

    private String transaccionID;
    private String monto;
    private String tipo;

    @Override
    public void parsearLinea(String linea, String clienteId) {

        if (linea.startsWith(TiposRegistroEnum.TRANSACCCION.getTipo())){
            String trimLinea = linea.trim();
            transaccionID = trimLinea.substring(1,33);
            monto = trimLinea.substring(33,46);
            tipo = trimLinea.substring(51);
            TransaccionDTO transaccionDTO = new TransaccionDTO();
            transaccionDTO.setTransaccionID(transaccionID);
            transaccionDTO.setMonto(Long.valueOf(monto));
            transaccionDTO.setTipo(Long.valueOf(tipo));
            transaccionDTO.setClienteID(clienteId);

            transacccionService.saveEntity(transaccionDTO);
            log.debug("se a parseado e insertado un registro tipo [transacccion]");
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
