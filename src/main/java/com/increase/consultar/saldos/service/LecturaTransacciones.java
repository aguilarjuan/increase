package com.increase.consultar.saldos.service;

import com.increase.consultar.saldos.Enums.TiposRegistroEnum;
import com.increase.consultar.saldos.service.Implementacion.ImplParseador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class LecturaTransacciones {

    @Autowired
    private ImplParseador parseador;

    @Autowired
    private SincronizarClientesService sincronizarClientesService;

    private final Logger log = LoggerFactory.getLogger(LecturaTransacciones.class);
    private String clienteID;
    private List<String> bloqueTransaccion = new ArrayList<>();
    private List<String> colaRetry = new ArrayList<>();

    private int nroBloques = 0;


    public void iniciarLectura(){

        try {
            File archivo = new File("src/main/resources/static/transacciones.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(fr);

            String parsearLinea;

            while ((parsearLinea = buffer.readLine())!= null){
                armarBloque(parsearLinea,colaRetry);
            }
            if(colaRetry.size() > 0){
                ejecutarColaDeReintentos(colaRetry);
            }
            buffer.close();
        } catch (Exception e){
            log.error(" se produjo en error durante la lectura del archivo");
            e.printStackTrace();
        }
    }

    private void armarBloque(String parsearLinea,List<String> colaRetry) {

        if (parsearLinea.startsWith(TiposRegistroEnum.CABECERA.getTipo())){
            log.debug("inicio de armado de bloque ");
            bloqueTransaccion.add(parsearLinea);
        }

        if (parsearLinea.startsWith(TiposRegistroEnum.TRANSACCCION.getTipo())){
            bloqueTransaccion.add(parsearLinea);

        }

        if(parsearLinea.startsWith(TiposRegistroEnum.DESCUENTO.getTipo())){
            bloqueTransaccion.add(parsearLinea);
        }

        if(parsearLinea.startsWith(TiposRegistroEnum.FOOTER.getTipo())) {
            nroBloques = nroBloques + 1;
            log.debug("fin del armado de bloque ");
            clienteID = parsearLinea;
            bloqueTransaccion.add(parsearLinea);
            //log.info("mostrando el bloque: " + bloqueTransaccion);
            log.info("se genera el bloque nro   = " + nroBloques);

            sincronizarClientesService.getCliente(getClienteID(clienteID),colaRetry);

            for (String registroSecuencial : bloqueTransaccion){
                parseador.parsearLinea(registroSecuencial,getClienteID(clienteID));
            }
            // usamos el bloque de infromacion
            bloqueTransaccion.clear();
        }

    }


    private String getClienteID(String footer){
        return footer.substring(24,56);
    }

    private void ejecutarColaDeReintentos(List<String> colaRetry){
        log.info("iniciando la cola de reintentos");
        for (String retry : colaRetry){
            sincronizarClientesService.retry(retry);
        }
    }

}
