package com.increase.consultar.saldos.service.Implementacion;

import com.increase.consultar.saldos.Enums.TiposRegistroEnum;
import com.increase.consultar.saldos.service.Interface.Iparseador;
import com.increase.consultar.saldos.dto.DescuentoDTO;
import com.increase.consultar.saldos.service.DescuentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImplParsearDescuento implements Iparseador {

    @Autowired
    private DescuentoService descuentoService;

    private Iparseador nexParseador;

    private final Logger log = LoggerFactory.getLogger(ImplParsearDescuento.class);

    private String descuentoId;
    private String monto;
    private String tipo;


    @Override
    public void parsearLinea(String linea, String clienteId) {

        if (linea.startsWith(TiposRegistroEnum.DESCUENTO.getTipo())){
            String trimLinea = linea.trim();
            descuentoId = trimLinea.substring(1,33);
            monto = trimLinea.substring(33,46);
            tipo = trimLinea.substring(49);
            DescuentoDTO descuentoDTO = new DescuentoDTO();
            descuentoDTO.setDescuentoID(descuentoId);
            descuentoDTO.setClienteID(clienteId);
            descuentoDTO.setMonto(Long.valueOf(monto));
            descuentoDTO.setTipo(Long.valueOf(tipo));
            descuentoService.saveEntity(descuentoDTO);
            log.debug("se a parseado e insertado un registro tipo [descuento]");
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
