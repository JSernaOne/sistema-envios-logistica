package com.envios.controller;

import com.envios.model.Empleado;
import com.envios.service.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/empleado", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRestEmpleado {

    private EmpleadoService service;

    @Autowired
    public ApiRestEmpleado(EmpleadoService service) {
        this.service = service;
    }

    @PostMapping("/crear")
    public Empleado crear(@RequestBody EmpleadoDTO empleado){
        return service.crear(empleado.toEntity());
    }

   @GetMapping("/buscar/{cedula}")
    public Empleado buscar(@PathVariable("cedula") Integer cedula){
        return service.buscar(cedula);
    }

    @PutMapping("/update/{cedula}")
    public Empleado actualizar(@PathVariable("cedula") Integer cedula, @RequestBody EmpleadoDTO empleado){
        return service.actualizar(cedula, empleado);
    }

   @DeleteMapping("/delete/{cedula}")
    public void eliminar(@PathVariable("cedula") Integer cedula){
       service.eliminar(cedula);
    }
}
