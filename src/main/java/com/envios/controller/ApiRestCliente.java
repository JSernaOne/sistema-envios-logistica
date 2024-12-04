package com.envios.controller;


import com.envios.entity.ClienteEntity;
import com.envios.model.Cliente;
import com.envios.repository.ClienteRepository;
import com.envios.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRestCliente {

    private ClienteService clienteService;


    @PostMapping(path="/crearCliente")
    public Cliente crearCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.crear(clienteDTO.toEntity());
    }

    @PostMapping(path="/buscarCliente/{cc}")
    public Cliente buscarCliente(@PathVariable Integer cc) {
        return clienteService.buscar(cc);
    }

    @DeleteMapping(path="/eliminarCliente/{cc}")
    public void eliminarCliente(@PathVariable Integer cc) {
        clienteService.eliminar(cc);
    }

    @PutMapping(path="/actualizarCliente")
    public Cliente actualizarCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.actualizar(clienteDTO.toEntity());
    }
}
