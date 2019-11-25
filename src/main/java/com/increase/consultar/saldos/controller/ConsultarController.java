package com.increase.consultar.saldos.controller;

import com.increase.consultar.saldos.dto.response.ResponseBalanceDTO;
import com.increase.consultar.saldos.dto.response.ResponseClienteDTO;
import com.increase.consultar.saldos.dto.response.ResponseTransaccionesDTO;
import com.increase.consultar.saldos.service.BalanceControllerService;
import com.increase.consultar.saldos.service.ClientesControllerService;
import com.increase.consultar.saldos.service.TransaccionesControllerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller para clientes.
 */

@RestController
@RequestMapping("/V1/consultar")
@Api(value = "ConsultarController")
public class ConsultarController {

    @Autowired
    private BalanceControllerService balanceControllerService;
    @Autowired
    private ClientesControllerService clientesControllerService;
    @Autowired
    private TransaccionesControllerService transaccionesControllerService;

    private final Logger log = LoggerFactory.getLogger(ConsultarController.class);

    @ApiOperation(value = "Lista del monto a cobrar de cada cliente", nickname = "consultarBalance", notes = "", response = com.increase.consultar.saldos.dto.response.ResponseBalanceDTO.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ResponseBalanceDTO.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "list of transacction not found") })
    @RequestMapping(value = "/balance", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<ResponseBalanceDTO>> consultarBalance() {
        log.info("solicitando el balance de los clientes");
        List<ResponseBalanceDTO> responseBalanceDTOS = balanceControllerService.consultarBalance();
        return new ResponseEntity<>(responseBalanceDTOS, HttpStatus.OK);
    }

    @ApiOperation(value = "Lista de la informacion de los clientes", nickname = "consultarClientes", notes = "", response = com.increase.consultar.saldos.dto.response.ResponseClienteDTO.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ResponseClienteDTO.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "list of client not found") })
    @RequestMapping(value = "/clientes", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<ResponseClienteDTO>> consultarClientes() {
        log.info("solicitando informacion de los clientes");
        List<ResponseClienteDTO> responseClienteDTOS = clientesControllerService.consultarClientes();
        return new ResponseEntity<>(responseClienteDTOS, HttpStatus.OK);
    }

    @ApiOperation(value = "Lista de las transacciones de cada cliente", nickname = "consultarTransacciones", notes = "", response = com.increase.consultar.saldos.dto.response.ResponseTransaccionesDTO.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ResponseTransaccionesDTO.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "list of transacction not found") })
    @RequestMapping(value = "/transacciones", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<ResponseTransaccionesDTO>> consultarTransacciones() {
        log.info("solicitando las transacciones clientes");
        List<ResponseTransaccionesDTO> responseTransaccionesDTOS = transaccionesControllerService.consultarTransacciones() ;
        return new ResponseEntity<>(responseTransaccionesDTOS, HttpStatus.OK);
    }


}
