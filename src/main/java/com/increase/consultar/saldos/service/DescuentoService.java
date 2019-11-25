package com.increase.consultar.saldos.service;

import com.increase.consultar.saldos.domain.DescuentoEntity;
import com.increase.consultar.saldos.repository.DescuentoRepository;
import com.increase.consultar.saldos.dto.DescuentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DescuentoService {

    @Autowired
    private DescuentoRepository descuentoRepository;

    public DescuentoEntity saveEntity(DescuentoDTO descuentoDTO){
        return descuentoRepository.save(toEntity(descuentoDTO));

    }

    private DescuentoEntity toEntity(DescuentoDTO descuentoDTO){
        DescuentoEntity entity = new DescuentoEntity();
        entity.setDescuentoID(descuentoDTO.getDescuentoID());
        entity.setClienteID(descuentoDTO.getClienteID());
        entity.setMonto(descuentoDTO.getMonto());
        entity.setTipo(descuentoDTO.getTipo());

        return entity;
    }

}
