package com.increase.consultar.saldos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.increase.consultar.saldos.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

@Service
public class SincronizarClientesService {

    private final Logger log = LoggerFactory.getLogger(SincronizarClientesService.class);

    @Autowired
    private ClientService clientService;

    @Value("${sistema.saldos.api.cliente}")
    private String URL_CLIENTE;

    @Value("${sistema.saldos.api.accessToken}")
    private String ACCESS_TOKEN;

    public void getCliente(String clienteID, List<String> colaRetry){

        try {

            log.debug("se solicita la informacion del cliente = " + clienteID);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.ALL));
            headers.add("User-Agent","spring boot");
            headers.set("Authorization", "Bearer "+ ACCESS_TOKEN);

            HttpEntity<String> request = new HttpEntity(headers);

            ResponseEntity<String> response = restTemplate.exchange(URL_CLIENTE + clienteID , HttpMethod.GET, request, String.class);

            String jsonResponse = response.getBody();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.findAndRegisterModules(); //Registers all modules on classpath
            ClienteDTO clienteDTO = objectMapper.readValue(jsonResponse, ClienteDTO.class);

            clientService.saveEntity(clienteDTO);

            log.debug("RESPONSE DE API EXTERNA = " + clienteDTO.toString());

        } catch (Exception e){
            log.warn("ocurrio un error al tratar de optener la info de un cliente especifico");
            colaRetry.add(clienteID);
            e.printStackTrace();
        }
    }


    public void retry(String clienteIdRetry){

        try {

            log.debug("se ejecuta reintento para el cliente = " + clienteIdRetry);

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.ALL));
            headers.add("User-Agent","spring boot");
            headers.set("Authorization", "Bearer "+ ACCESS_TOKEN);
            HttpEntity<String> request = new HttpEntity(headers);
            ResponseEntity<String> response = restTemplate.exchange(URL_CLIENTE + clienteIdRetry , HttpMethod.GET, request, String.class);
            String jsonResponse = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.findAndRegisterModules(); //Registers all modules on classpath
            ClienteDTO clienteDTO = objectMapper.readValue(jsonResponse, ClienteDTO.class);
            clientService.saveEntity(clienteDTO);
            log.debug("RESPONSE DE API EXTERNA = " + clienteDTO.toString());
        } catch (Exception e){
            log.error("la cola de reintentos no fue exitosa para un cliente especifico");
            e.printStackTrace();
        }
    }

}
