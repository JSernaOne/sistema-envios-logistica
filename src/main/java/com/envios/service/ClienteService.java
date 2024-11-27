package com.envios.service;

import com.envios.controller.ClienteDTO;
import com.envios.entity.ClienteEntity;
import com.envios.model.Cliente;
import com.envios.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private List<ClienteEntity> clientes;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.clientes = new ArrayList<>();
    }

    public Cliente crear(Cliente cliente) {

        if(cliente == null){
           /* throw new ApiRequestException("El cliente no puede ser nulo ");*/
            System.out.println("El cliente no puede ser nulo");

        }
        if(cliente.getCedula() == null || cliente.getApellido() == null || cliente.getNombre() == null){
           /* throw new ApiRequestException("la cedula, el apellido o el nombre son invalidos");*/
            System.out.println("la cedula, el apellido o el nombre son invalidos");
        }

        ClienteEntity clienteEntity = new ClienteEntity(
                cliente.getCedula(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCelular(),
                cliente.getEmail(),
                cliente.getDirResidencia(),
                cliente.getCiudad()
        );

        clienteRepository.save(clienteEntity);
        return cliente;
    }
}
