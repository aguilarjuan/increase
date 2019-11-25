package com.increase.consultar.saldos.service;

import com.increase.consultar.saldos.domain.CabeceraEntity;
import com.increase.consultar.saldos.dto.response.ResponseBalanceDTO;
import com.increase.consultar.saldos.repository.CabeceraRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BalanceControllerService {

    @Autowired
    private CabeceraRepository cabeceraRepository;

    private final Logger log = LoggerFactory.getLogger(BalanceControllerService.class);

    public List<ResponseBalanceDTO> consultarBalance() {

        List<ResponseBalanceDTO> responseBalanceDTOS = new ArrayList<>();
        List<CabeceraEntity> entityList = cabeceraRepository.findAll();

        for (CabeceraEntity cabeceraEntity : entityList) {
            responseBalanceDTOS.add(responseBalanceDto(cabeceraEntity));
        }
        return responseBalanceDTOS;
    }

    private ResponseBalanceDTO responseBalanceDto(CabeceraEntity cabeceraEntity){

        ResponseBalanceDTO responseDto = new ResponseBalanceDTO();
        responseDto.setClienteID(cabeceraEntity.getClienteID());
        Integer montoTotal = Integer.valueOf(cabeceraEntity.getMontoTotal().intValue());
        responseDto.setMontoTotal(montoTotal);
        Integer totalConDescuento = Integer.valueOf(cabeceraEntity.getTotalConDescuentos().intValue());
        responseDto.setTotalConDescuentos(totalConDescuento);

        return responseDto;

    }
}