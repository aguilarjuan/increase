package com.increase.consultar.saldos.service;

import com.increase.consultar.saldos.Enums.TipoTransaccionEnum;
import com.increase.consultar.saldos.domain.TransaccionEntity;
import com.increase.consultar.saldos.dto.response.ResponseTransaccionesDTO;
import com.increase.consultar.saldos.repository.TransaccionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransaccionesControllerService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    private final Logger log = LoggerFactory.getLogger(TransaccionesControllerService.class);

    @Value("${sistema.saldos.constantes.aprobado}")
    private String APROBADO;

    @Value("${sistema.saldos.constantes.rechazado}")
    private String RECHAZADO;


    public List<ResponseTransaccionesDTO> consultarTransacciones() {

        List<ResponseTransaccionesDTO> responseTransaccionesDTOS = new ArrayList<>();
        List<TransaccionEntity> entityList = transaccionRepository.findAll();

        for (TransaccionEntity transaccionEntity:entityList){
            responseTransaccionesDTOS.add(responseTransaccionesDto(transaccionEntity));
        }

        return responseTransaccionesDTOS;
    }


    private ResponseTransaccionesDTO responseTransaccionesDto(TransaccionEntity transaccionEntity){

        ResponseTransaccionesDTO responseDto = new  ResponseTransaccionesDTO();
        responseDto.setTransaccionID(transaccionEntity.getTransaccionID());
        responseDto.setClienteID(transaccionEntity.getClienteID());
        Integer monto = Integer.valueOf(transaccionEntity.getMonto().intValue());
        responseDto.setMonto(monto);

        if(TipoTransaccionEnum.APROBADO.getTipo().equalsIgnoreCase(transaccionEntity.getTipo().toString())){
            responseDto.setTipo(APROBADO);
        }

        if(TipoTransaccionEnum.RECHAZADO.getTipo().equalsIgnoreCase(transaccionEntity.getTipo().toString())){
            responseDto.setTipo(RECHAZADO);
        }

        return responseDto;
    }

}
