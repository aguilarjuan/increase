package com.increase.consultar.saldos.service;

import com.increase.consultar.saldos.domain.ClienteEntity;
import com.increase.consultar.saldos.dto.response.ResponseClienteDTO;
import com.increase.consultar.saldos.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientesControllerService {

    @Autowired
    private ClienteRepository clienteRepository;

    private final Logger log = LoggerFactory.getLogger(ClientesControllerService.class);

    public List<ResponseClienteDTO> consultarClientes() {

        List<ResponseClienteDTO> responseClienteDTOS = new ArrayList<>();
        List<ClienteEntity> entityList = clienteRepository.findAll();

        for (ClienteEntity clienteEntity:entityList){
            responseClienteDTOS.add(ResponseClientesDto(clienteEntity));
        }

        return responseClienteDTOS;
    }


    private ResponseClienteDTO ResponseClientesDto(ClienteEntity clienteEntityList){

        ResponseClienteDTO responseClienteDTO = new ResponseClienteDTO();
        responseClienteDTO.setClienteID(clienteEntityList.getClienteID());
        responseClienteDTO.setEmail(clienteEntityList.getEmail());
        responseClienteDTO.setFirstName(clienteEntityList.getFirstName());
        responseClienteDTO.setLastName(clienteEntityList.getLastName());
        responseClienteDTO.setJob(clienteEntityList.getJob());
        responseClienteDTO.setCountry(clienteEntityList.getCountry());
        responseClienteDTO.setAddress(clienteEntityList.getAddress());
        responseClienteDTO.setZipCode(clienteEntityList.getZipCode());
        responseClienteDTO.setPhone(clienteEntityList.getPhone());

        return responseClienteDTO;
    }

}
