package com.increase.consultar.saldos.scheduled;

import com.increase.consultar.saldos.service.SincronizarTransacciones;
import com.increase.consultar.saldos.service.ClientService;
import com.increase.consultar.saldos.service.SincronizarClientesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class sincronizarClientesTaskService {

    private final Logger log = LoggerFactory.getLogger(sincronizarClientesTaskService.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private SincronizarClientesService sincronizarClientesService;

    @Autowired
    private SincronizarTransacciones sincronizarTransacciones;

    @Scheduled(fixedDelayString = "${sistema.saldos.api.scheduled.miliseconds}")
    public void sincronizarClientes(){
        //log.info("Inicio la tarea programada de sincronizacion de clientes.");
        log.info("Inicio la tarea programada de sincronizacion de todas las Transacciones.");
        //sincronizarClientesService.getCliente("86c3612665f84416b86ccbca649828ff");
        sincronizarTransacciones.getTransacciones();
    }
}
