package com.increase.consultar.saldos.service;

import com.increase.consultar.saldos.domain.TransaccionEntity;
import com.increase.consultar.saldos.dto.TransaccionDTO;
import com.increase.consultar.saldos.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransacccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;


    public TransaccionEntity saveEntity(TransaccionDTO transaccionDTO){
        return transaccionRepository.save(toEntity(transaccionDTO));
    }

    private TransaccionEntity toEntity(TransaccionDTO transaccionDTO){
        TransaccionEntity entity = new TransaccionEntity();
        entity.setTransaccionID(transaccionDTO.getTransaccionID());
        entity.setClienteID(transaccionDTO.getClienteID());
        entity.setMonto(transaccionDTO.getMonto());
        entity.setTipo(transaccionDTO.getTipo());

        return entity;
    }

}
