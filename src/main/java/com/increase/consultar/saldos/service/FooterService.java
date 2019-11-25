package com.increase.consultar.saldos.service;

import com.increase.consultar.saldos.domain.FooterEntity;
import com.increase.consultar.saldos.dto.FooterDTO;
import com.increase.consultar.saldos.repository.FooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FooterService {

    @Autowired
    private FooterRepository footerRepository;

    public FooterEntity saveEntity(FooterDTO footerDTO){
        return footerRepository.save(toEntity(footerDTO));
    }

private FooterEntity toEntity(FooterDTO footerDTO){

        FooterEntity entity = new FooterEntity();
        entity.setFechaPago(footerDTO.getFechaPago());
        entity.setClienteID(footerDTO.getClienteID());
        return entity;
}

}
