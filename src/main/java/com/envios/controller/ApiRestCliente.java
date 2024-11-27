package com.envios.controller;


import com.envios.entity.ClienteEntity;
import com.envios.model.Cliente;
import com.envios.repository.ClienteRepository;
import com.envios.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRestCliente {

    private ClienteService clienteService;


    @PostMapping(path="/crearCliente")
    public Cliente crearCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.crear(clienteDTO.toEntity());
    }

}
