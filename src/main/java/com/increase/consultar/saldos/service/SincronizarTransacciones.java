package com.increase.consultar.saldos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.util.Arrays;

@Service
public class SincronizarTransacciones {

    @Autowired
    private LecturaTransacciones lecturaTransacciones;

    private final Logger log = LoggerFactory.getLogger(SincronizarTransacciones.class);

    @Value("${sistema.saldos.api.trasnsacciones}")
    private String URL_TRANSACCIONES;
    @Value("${sistema.saldos.api.accessToken}")
    private String ACCESS_TOKEN;

    public void getTransacciones(){

        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.ALL));
            headers.add("User-Agent","spring boot");
            headers.set("Authorization", "Bearer "+ ACCESS_TOKEN);

            HttpEntity<String> request = new HttpEntity(headers);

            ResponseEntity<String> response = restTemplate.exchange(URL_TRANSACCIONES, HttpMethod.GET, request, String.class);

            String listaTransacciones = response.getBody();

            crearArchivo(listaTransacciones);
            lecturaTransacciones.iniciarLectura();

        } catch (Exception e){
            log.error("ocurrio un error durante la conneccion a la API externa");
            e.printStackTrace();
        }


    }

    private void crearArchivo(String contenido){

        log.info("se genera el archivo de texto de las transacciones");

        try {
            PrintWriter writer = new PrintWriter("src/main/resources/static/transacciones.txt", "UTF-8");
            writer.println(contenido);
            writer.close();
        } catch (Exception e) {
            log.error("ocurrio un error al intentar generar el archivo de las transacciones");
            e.printStackTrace();
        }
    }
}
