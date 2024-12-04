package com.envios.service;

import com.envios.entity.PaqueteEntity;
import com.envios.model.Paquete;
import com.envios.repository.PaqueteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaqueteService {
    private final PaqueteRepository paqueteRepository;

    public Paquete crear(Paquete paquete) {
        if (paquete == null) {
            System.out.println("El paquete no puede ser nulo");
        }
        if (paquete.getTipo() == null || paquete.getPeso() == 0 || paquete.getValorDeclarado() == 0) {
            System.out.println("El tipo, el peso o el valor declarado son invalidos");
        }
        PaqueteEntity paqueteEntity = new PaqueteEntity(
                paquete.getTipo(),
                paquete.getPeso(),
                paquete.getValorDeclarado()
        );
        paqueteRepository.save(paqueteEntity);
        return paquete;
    }
}