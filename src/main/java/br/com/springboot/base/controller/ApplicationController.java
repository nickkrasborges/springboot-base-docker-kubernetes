package br.com.springboot.base.controller;

import br.com.springboot.base.feature.calculo.bean.CalculoTransporteRequest;
import br.com.springboot.base.feature.calculo.bean.CalculoTransporteResponse;
import br.com.springboot.base.feature.calculo.service.CalculoService;
import br.com.springboot.base.feature.transporte.bean.ConsultaVeiculosResponse;
import br.com.springboot.base.feature.transporte.service.TransporteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nick Kras Borges
 */
@RestController
@RequestMapping("/api")
public class ApplicationController implements ApplicationControllerApi {

    private final Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    private TransporteService transporteService;

    @Autowired
    private CalculoService calculoService;

    @Override
    @ResponseBody
    @GetMapping("/teste")
    public ResponseEntity<String> teste(){
        return ResponseEntity.ok("Hello world!");
    }

    @Override
    @ResponseBody
    @GetMapping("/veiculos")
    public ResponseEntity<ConsultaVeiculosResponse> consultaVeiculos(){
        return ResponseEntity.ok(transporteService.consultaVeiculos());
    }

    @Override
    @ResponseBody
    @GetMapping("/calculo")
    public ResponseEntity<CalculoTransporteResponse> calculoTransporte(
            @RequestBody final CalculoTransporteRequest calculoTransporteRequest){
            return ResponseEntity.ok(calculoService.calculoTransporte(calculoTransporteRequest));
    }
}
