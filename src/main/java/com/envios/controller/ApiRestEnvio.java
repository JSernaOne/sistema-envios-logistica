package com.envios.controller;


import com.envios.entity.EnvioEntity;
import com.envios.service.EnvioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/envio", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRestEnvio {

    private EnvioService service;

    @PostMapping("/crearEnvio")
    public EnvioCreadoDTO crear(@RequestBody EnvioDTO envio){
        return service.crear(envio);
    }

    @PutMapping("/estado")
    public EnvioCreadoDTO cambiarEstado(@RequestBody EnvioCambiarEstadoDTO envioCambiarEstadoDTO) throws Exception {
        return service.cambiarEstado(envioCambiarEstadoDTO);
    }

    @GetMapping("/buscar/{num-guia}")
    public EnvioDetalleDTO buscar(@PathVariable("num-guia") Integer numGuia){
        return service.buscar(numGuia);
    }

    @GetMapping("/estado/{estado}")
    public List<EnvioEntity> filtrar (@PathVariable("estado") String estado) throws Exception {
        return service.filtrar(estado);
    }
}
