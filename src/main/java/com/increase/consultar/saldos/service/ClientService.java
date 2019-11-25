package com.increase.consultar.saldos.service;

import com.increase.consultar.saldos.domain.ClienteEntity;
import com.increase.consultar.saldos.dto.ClienteDTO;
import com.increase.consultar.saldos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity saveEntity(ClienteDTO clienteDTO){
       return clienteRepository.save(toEntity(clienteDTO));
    }

    private ClienteEntity toEntity(ClienteDTO clienteDTO){
        ClienteEntity entity = new ClienteEntity();
        entity.setClienteID(clienteDTO.getClienteID());
        entity.setEmail(clienteDTO.getEmail());
        entity.setFirstName(clienteDTO.getFirstName());
        entity.setLastName(clienteDTO.getLastName());
        entity.setJob(clienteDTO.getJob());
        entity.setCountry(clienteDTO.getCountry());
        entity.setAddress(clienteDTO.getAddress());
        entity.setZipCode(clienteDTO.getZipCode());
        entity.setPhone(clienteDTO.getPhone());

        return entity;
    }

}
