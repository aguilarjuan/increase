package com.increase.consultar.saldos.service;


import com.increase.consultar.saldos.domain.CabeceraEntity;
import com.increase.consultar.saldos.dto.CabeceraDTO;
import com.increase.consultar.saldos.repository.CabeceraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CabeceraService {

    @Autowired
    private CabeceraRepository cabeceraRepository;


    public CabeceraEntity saveEntity(CabeceraDTO cabeceraDTO){
        return cabeceraRepository.save(toEntity(cabeceraDTO));
    }

    private CabeceraEntity toEntity(CabeceraDTO cabeceraDTO){

        CabeceraEntity entity = new CabeceraEntity();
        entity.setPagoID(cabeceraDTO.getPagoID());
        entity.setClienteID(cabeceraDTO.getClienteID());
        entity.setMoneda(cabeceraDTO.getMoneda());
        entity.setMontoTotal(cabeceraDTO.getMontoTotal());
        entity.setTotalDescuentos(cabeceraDTO.getTotalDescuentos());
        entity.setTotalConDescuentos(cabeceraDTO.getTotalConDescuentos());

        return entity;
    }


}
