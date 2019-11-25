package com.increase.consultar.saldos.service.Implementacion;

import com.increase.consultar.saldos.Enums.TiposRegistroEnum;
import com.increase.consultar.saldos.service.Interface.Iparseador;
import com.increase.consultar.saldos.dto.FooterDTO;
import com.increase.consultar.saldos.service.FooterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImplParsearFooter implements Iparseador {

    @Autowired
    private FooterService footerService;

    private Iparseador nexParseador;

    private final Logger log = LoggerFactory.getLogger(ImplParsearFooter.class);

    private String fechaPago;
    private String clienteId;

    @Override
    public void parsearLinea(String linea, String extClienteId) {

        if (linea.startsWith(TiposRegistroEnum.FOOTER.getTipo())){
            String trimLinea = linea.trim();
            fechaPago = trimLinea.substring(16,24);
            clienteId = trimLinea.substring(24,56);
            FooterDTO footerDTO = new FooterDTO();
            footerDTO.setFechaPago(Long.valueOf(fechaPago));
            footerDTO.setClienteID(clienteId);
            footerService.saveEntity(footerDTO);
            log.debug("se a parseado e insertado un registro tipo [footer]");
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
